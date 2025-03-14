import com.revature.misc.OldUserDAOImpl;
import com.revature.models.User;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;
import com.revature.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class UserServiceTest {

    /*
    This class will contain all of the tests for my UserService. We're mainly going to be testing the Service Layer

    Why is this important?
    Tests are important for validating that code works now and in the future
    When tests exist you can validate that your changes to methods are not affecting expected functionality since
    the tests are still running.

    TDD (Test Driven Development):
    Writing tests before writing code.

    We'll generate some tests that cover all of the expected functionality and any additional edge cases handled by
    some specific method and then have the user develop the method based off those results (Coding challenges are
    designed this way).

    TODO Come back here and talk about Mocking

    Why might we we not want to test the methods that affect the DAO/database?
    Well if I make a call in one test it may fail upon follow up tests
    For example: I register a user with user "testusername", the second time I run the test that user will already be
    taken.

    To get around this we'll mock our UserDAO implementation and inject in the values that we want

    We'll use Mockito for mocking since it allows to mock classes, spy on them and imitate their calls
     */

    private UserService userService;

    private UserDAOImpl mockDAO;

    @Before
    public void setup(){
        // In this before class method I want to mock the userDAO class so that way I can prevent calls that
        // affect the database
        mockDAO = Mockito.mock(UserDAOImpl.class);
        // The mock DAO is a fake version of the original class and now I'll pass it to our UserService
        userService = new UserService(mockDAO);
    }


    // Test the validate Username and validate password methods
    // We will write 2 tests:  one for more than 8 characters and one for less than 8
    @Test
    public void validUsernameShouldReturnTrue(){
        // Arrange
        String testUsername = "ValidUsername";
        // Act
        boolean result = userService.validateUsername(testUsername);
        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void invalidUsernameShouldReturnFalse(){
        // Arrange
        String testUsername = "short";
        // Act
        boolean result = userService.validateUsername(testUsername);
        // Assert
        Assert.assertFalse(result);
    }

    // Password Security
    // Length >= 8, Capital Letter required, Lowercase required, Positive test to make sure it works

    @Test
    public void validPasswordShouldReturnTrue(){
        // Arrange
        String testPassword = "ValidPassword";
        // Act
        boolean result = userService.validatePassword(testPassword);
        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void tooShortPasswordShouldReturnFalse(){
        // Arrange
        String testPassword = "Invalid"; // 7 Characters
        // Act
        boolean result = userService.validatePassword(testPassword);
        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void allLowercasePasswordShouldReturnFalse(){
        // Arrange
        String testPassword = "password";
        // Act
        boolean result = userService.validatePassword(testPassword);
        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void allCapsPasswordShouldReturnFalse(){
        // Arrange
        String testPassword = "PASSWORD";
        // Act
        boolean result = userService.validatePassword(testPassword);
        // Assert
        Assert.assertFalse(result);
    }

    // Let's add in some mocking tests
    @Test
    public void takenUsernameShouldReturnFalse(){
        // Arrange
        String testUsername = "username";
        User mockedUser = new User("test", "test", testUsername, "Password");
        // We want this user to be returned when the method getUserByUsername is called
        when(mockDAO.getUserByUsername(testUsername)).thenReturn(mockedUser);
        // So instead of making a real DB call we just return this user

        // Act
        boolean isUsernameAvailable = userService.isUsernameAvailable(testUsername);

        // Assert
        Assert.assertFalse(isUsernameAvailable);

    }

    @Test
    public void availableUsernameShouldReturnTrue(){
        // Arrange
        String testUsername = "username";

        when(mockDAO.getUserByUsername(testUsername)).thenReturn(null);

        // Act
        boolean isUsernameAvailable = userService.isUsernameAvailable(testUsername);

        // Assert
        Assert.assertTrue(isUsernameAvailable);
    }

    // Login Tests
    // getUserByUsername returns null
    @Test
    public void loginWithNullUserShouldReturnNull(){
        // Arrange
        String username = "username";
        String password = "password";
        when(mockDAO.getUserByUsername(username)).thenReturn(null);
        // This means the user was not found

        // Act
        User returnedUser = userService.loginUser(username, password);

        // Assert
        Assert.assertNull(returnedUser);
    }


    // Password is incorrect
    @Test
    public void incorrectPasswordShouldReturnNullOnLogin(){
        // Arrange
        String username = "username";
        String password = "password";
        String incorrectPassword = "notRight";
        User u = new User("test", "test", username, password); // This user comes back from the db

        when(mockDAO.getUserByUsername(username)).thenReturn(u);
        // This means the user was not found

        // Act
        User returnedUser = userService.loginUser(username, incorrectPassword);

        // Assert
        Assert.assertNull(returnedUser);
    }

    // Everything is correct

    @Test
    public void correctLoginInfoShouldReturnUser(){
        // Arrange
        String username = "username";
        String password = "password";
        User u = new User("test", "test", username, password); // This user comes back from the db

        when(mockDAO.getUserByUsername(username)).thenReturn(u);
        // This means the user was not found

        // Act
        User returnedUser = userService.loginUser(username, password);

        // Assert
        Assert.assertEquals(u, returnedUser);
    }
}
