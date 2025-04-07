package com.revature.controllers;

import com.revature.exceptions.EmailAlreadyTakenException;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.models.User;
import com.revature.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController // Combines @Controller and @ResponseBody
@RequestMapping("users") // http://localhost:8080/users
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5173"}, allowCredentials = "true") // This allows requests to come in from http://localhost:5500
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // TODO Register
    @PostMapping("register") // POST to http://localhost:8080/users/register
    public ResponseEntity<User> registerHandler(@RequestBody User user){

        // At this point we expect the user to be passed in as the body of the request
        // Let's attempt to register them

        User registeredUser = userService.register(user);

        if (registeredUser ==  null){
            return ResponseEntity.badRequest().build(); // A 400 status return
        }

        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);// 201 response meaning successful creation
    }


    // Todo Login
    @PostMapping("login")
    public User loginHandler(@RequestBody User user, HttpSession session){

        // Attempt to login
        Optional<User> potentialUser = userService.login(user);

        // Verify the user was successfully logged in
//        return potentialUser.orElseThrow(() -> new InvalidCredentialsException("Username or Password is incorrect"));
        if (potentialUser.isPresent()){

            // Set the necessary session attributes
            session.setAttribute("userId", potentialUser.get().getUserId());
            session.setAttribute("role", potentialUser.get().getRole());

            return potentialUser.get();
        }

        throw new InvalidCredentialsException("Username or Password is incorrect");
    }


    // EmailAlreadyTaken Handler
    @ExceptionHandler(EmailAlreadyTakenException.class)
    @ResponseStatus(code=HttpStatus.CONFLICT)
    public Map<String, String> emailTakenExceptionHandler(EmailAlreadyTakenException e){
        return Map.of(
                "error", e.getMessage()
        );
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> invalidCredentialsExceptionHandler(InvalidCredentialsException e){
        return Map.of(
                "error", e.getMessage()
        );
    }
}
