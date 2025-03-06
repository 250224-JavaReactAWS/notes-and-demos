import com.revature.repos.UserDAOImpl;
import com.revature.services.UserService;
import org.junit.Assert;
import org.junit.Test;

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
     */

    private UserService userService = new UserService(new UserDAOImpl());

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
}
