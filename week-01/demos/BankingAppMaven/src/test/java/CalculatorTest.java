import com.revature.misc.Calculator;
import org.junit.*;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CalculatorTest {

    /*
    This class will leverage the JUnit testing framework to allow us to write simple unit tests using some annotations

    Notes about Unit Testing:
    We use JUnit for a process known as unit testing which is taking the smallest piece of our code and testing in
    multiple ways to validate its ability to work.

    Positive Testing -> Expected result equals actual result
    Negative -> Expected result does not equal some specific result

    Annotations from JUnit:
    - @Test
        - Used to mark a method for testing
    - @BeforeClass
        - Used for setup before any tests run
    - @Before
        - Used for setup before EACH test
    - @After
        - Used for tear down after EACH test
    - @AfterClass
        - Used for tear down after all tests have run
     */

    @BeforeClass
    public static void beforeAll(){
        System.out.println("Runs before all tests");
    }

    @Before
    public void beforeEach(){
        System.out.println("Runs before each test");
    }

    @After
    public void afterEach(){
        System.out.println("Runs after each test");
    }

    @AfterClass
    public static void afterAll(){
        System.out.println("Runs after all tests");
    }


    // Our first test method
    // This uses the @Test annotation to let us know this method is a test method
    @Test
    public void positiveAdditionTest(){
        // AAA Pattern
        // Arrange (Set up)
        int num1 = 1;
        int num2 = 2;

        // Act (Perform the action)
        // Testing the method itself
        int result = Calculator.add(num1, num2);

        // Assert (Validate the result)
        // Assertion is a statement that says "This should be true/false" if the expected does not match the actual
        // the test is marked as failed. Tests should have at LEAST one assertion line
        assertEquals(3, result);
    }

    @Test
    public void negativeAdditionTest(){
        // Arrange
        int num1 = 1;
        int num2 = 2;

        // Act
        int result = Calculator.add(num1, num2);

        // Arrange
        assertNotEquals(4, result);
    }
}
