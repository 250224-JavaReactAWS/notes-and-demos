package com.revature.util;

import com.revature.controllers.AccountController;
import com.revature.controllers.UserController;
import com.revature.repos.AccountDAO;
import com.revature.repos.AccountDAOImpl;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;
import com.revature.services.AccountService;
import com.revature.services.UserService;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinUtil {


    // This class is not explicitly necessary, this can all be done in the main class but since the main class is
    // just for starting the app I'll do my config information here
    // The parent path for all of our resources has been http://localhost:7070
    public static Javalin create(int port){
        // Create all of our variables
        UserDAO userDAO = new UserDAOImpl();
        UserService userService = new UserService(userDAO);
        UserController userController = new UserController(userService);

        AccountDAO accountDAO = new AccountDAOImpl();
        AccountService accountService = new AccountService(accountDAO);
        AccountController accountController = new AccountController(accountService);


        return Javalin.create(config -> {
                // Inside of here I have a config variable, this can be used for things like CORS configuration
                // This can also be used to set up a set of paths
                config.router.apiBuilder(() -> {
                    path("/users", () -> {
                        post("/register", userController:: registerUserHandler);
                        post("/login", userController:: loginHandler);
                        get("/", userController::getAllUsersHandler);
                    });
                    path("/accounts", () -> {
                        get("/", accountController::getAccountsHandler);
                    });
                });
                })
//                .post("/users/register", ctx -> {userController.registerUserHandler(ctx);})
                // Method Reference Syntax
//                .post("/users/register", userController::registerUserHandler)
//                .post("/users/login", userController::loginHandler)
//                .get("/users", userController::getAllUsersHandler)
                .start(port);
    }
}









