package com.revature;

import com.revature.exceptions.EmailAlreadyTakenException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.UserDAO;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// To use mockito with this class we'll need to do a couple of things
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    // Defining the classes we want to mock
    @Mock
    private UserDAO mockedUserDAO;

    @InjectMocks
    private UserService userService;


    @Test
    public void EmailTakenShouldThrowException(){
        // Arrange
        User userToBeRegistered = new User(1, "sample", "sample", "sample", "sample", Role.STUDENT);

        Optional<User> sampleUser = Optional.of(
                new User(1, "sample", "sample", "sample", "sample", Role.STUDENT));

        when(mockedUserDAO.findUserByEmail(any())).thenReturn(sampleUser);

        // Act
//        User returnedUser = userService.register(userToBeRegistered);

        // Assert
        assertThrows(EmailAlreadyTakenException.class, () -> userService.register(userToBeRegistered));
    }
}
