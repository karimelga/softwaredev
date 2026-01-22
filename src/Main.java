//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
void main() {
    //sonnet
    int rightAnswer = 0;
    int correct = 0;
    int incorrectCount = 0;
    int attempt = 0;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Character> sonnetList = new ArrayList<>();
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
        if (attempt > 0){
            sonnetList.clear();
        }
        Random rand = new Random();
        int i = rand.nextInt(paragraph.length());
        while (paragraph.charAt(i) == '\n' || paragraph.charAt(i) == ' ' || paragraph.charAt(i) == '.' || paragraph.charAt(i) == ',' || paragraph.charAt(i) == ';') {
            i = rand.nextInt(paragraph.length()); //generate random num

        }
        int lowIndex = i;
        int highIndex = i;
        int sizeOfWord = 0;
        while (i != 0 && (paragraph.charAt(lowIndex) != '\n' && paragraph.charAt(lowIndex) != ' ' && paragraph.charAt(lowIndex) != '.' && paragraph.charAt(lowIndex) != ',' && paragraph.charAt(lowIndex) != ';')) {
            lowIndex -= 1; //get left side index of word

        }
        if (lowIndex != i) { //exception case if i = 0
            lowIndex += 1;
        }
        while (i != (paragraph.length() - 1) && (paragraph.charAt(highIndex) != '\n' && paragraph.charAt(highIndex) != ' ' && paragraph.charAt(highIndex) != '.' && paragraph.charAt(highIndex) != ',' && paragraph.charAt(highIndex) != ';')) {
            highIndex += 1; //get right side index of word
        }
        highIndex -= 1;
        sizeOfWord = (highIndex + 1) - lowIndex;
        for (int j = lowIndex; j < (highIndex + 1); j++) {
            sonnetList.add(paragraph.charAt(j));
            //add word to arraylist
        }
        String word = "";
        for (char character : sonnetList) {
            word += character; //the word you are trying to guess
        }
        sonnetList.clear();
        for (int o = 0; o < paragraph.length(); o++){
            sonnetList.add(paragraph.charAt(o)); //add paragraph characters to arraylist
        }
        for (int p = lowIndex; p < (highIndex + 1); p++){
            sonnetList.set(p, '_'); //change that word to underscore
        }
        for (char cha : sonnetList) {
            System.out.print(cha);
        }

        System.out.println("Guess what the missing word is.");
        String guess = scanner.nextLine();
        System.out.println("Your guess was: " + guess + " and the word was " + word);
        if (guess.equals(word)){
            correct += 1;
        }
        else{
            incorrectCount += 1;
        }
        attempt += 1;
    }


    if( correct == 3){
        System.out.println("Great Job. You got the right answer three times.");
    }
    else{
        System.out.println("Three of your guesses were wrong.");
    }
}




