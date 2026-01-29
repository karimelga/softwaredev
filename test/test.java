import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
//this test classes tests for when you get three incorrect guesses since it is possible to make that happen
//because the main method uses Random() logic, there is no way to test for the correct input (we don't know what the computer will pick)
//that is why I made an EXCEL sheet with test cases that have the correct input in them
class MainTest {

    @Test
    void testMainMethodThreeWrongGuesses() {
        //SETUP: Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Simulate Input
        // We provide 3 inputs. Since the game picks a random word from Shakespeare,
        // "banana", "apple", and "orange" are almost certainly wrong.
        String simulatedInput = "banana\napple\norange\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        //Run the main method
        Main.main(new String[]{});

        //Check the output
        String output = outContent.toString();

        // Check if the game recognized the wrong answers
        assertTrue(output.contains("Wrong. Your guess was: banana"), "Output should show first wrong guess");

        // Check if the game ended correctly
        assertTrue(output.contains("Three of your guesses were wrong"), "Game should end with failure message");
    }
}