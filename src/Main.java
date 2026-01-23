//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int correct = 0;
        int incorrectCount = 0;
        int attempt = 0;
        Scanner scanner = new Scanner(System.in);

        String paragraph = "Two households, both alike in dignity,\n" +
                "In fair Verona, where we lay our scene,\n" +
                "From ancient grudge break to new mutiny,\n" +
                "Where civil blood makes civil hands unclean.\n" +
                "From forth the fatal loins of these two foes\n" +
                "A pair of star-cross’d lovers take their life;\n" +
                "Whose misadventured piteous overthrows\n" +
                "Do with their death bury their parents’ strife.\n" +
                "The fearful passage of their death-mark’d love,\n" +
                "And the continuance of their parents’ rage,\n" +
                "Which, but their children’s end, nought could remove,\n" +
                "Is now the two hours’ traffic of our stage;\n" +
                "The which if you with patient ears attend,\n" +
                "What here shall miss, our toil shall strive to mend.\n";

        while (incorrectCount < 3 && correct < 3) {
            Random rand = new Random();
            int i = rand.nextInt(paragraph.length());

            // Ensure we start on a valid letter
            while (!isWordChar(paragraph.charAt(i))) {
                i = rand.nextInt(paragraph.length());
            }

            // Find the start of the word (lowIndex)
            int lowIndex = i;
            while (lowIndex > 0 && isWordChar(paragraph.charAt(lowIndex - 1))) {
                lowIndex--;
            }

            // Find the end of the word (highIndex)
            int highIndex = i;
            while (highIndex < paragraph.length() - 1 && isWordChar(paragraph.charAt(highIndex + 1))) {
                highIndex++;
            }

            // Extract the target word
            // substring is exclusive on the end index, so we use highIndex + 1
            String word = paragraph.substring(lowIndex, highIndex + 1);

            // DISPLAY LOGIC

            System.out.println("\n--- Complete the line ---");

            //Print the paragraph UP TO the missing word
            System.out.print(paragraph.substring(0, lowIndex));

            // Print underscores based on word length
            for (int k = 0; k < word.length(); k++) {
                System.out.print("_");
            }

            // Print a newline to separate the text from the prompt
            System.out.println();

            // --- DISPLAY LOGIC CHANGE END ---

            System.out.println("\nGuess what the missing word is:");
            String guess = scanner.nextLine();

            // Logic to ignore case sensitivity can be added by using .equalsIgnoreCase()
            // But keeping strict equality as per your original code:
            if (guess.equals(word)) {
                System.out.println("Correct! The word was: " + word);
                correct += 1;
            } else {
                System.out.println("Wrong. Your guess was: " + guess + " and the word was " + word);
                incorrectCount += 1;
            }
            attempt += 1;
        }

        if (correct == 3) {
            System.out.println("Great Job. You got the right answer three times.");
        } else {
            System.out.println("Three of your guesses were wrong.");
        }
    }

    // Helper method to check if a character is part of a word
    // (Excludes spaces, newlines, and punctuation)
    public static boolean isWordChar(char c) {
        return c != ' ' && c != '\n' && c != '.' && c != ',' && c != ';' && c != ':';
    }
}



