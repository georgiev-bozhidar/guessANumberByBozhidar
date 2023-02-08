import java.util.Random;
import java.util.Scanner;

/*
Guess A Number Game

TODO: Make game run in a console window
TODO: Make a text speed function
TODO: Add difficulty
    - make the range custom
TODO: Add game restart
    - once the game is over, ask the player if they want to go back to the main menu or restart the game
TODO: Add story mode
TODO: Add arcade mode
TODO: Add custom game
TODO: Add options (text speed,
TODO: Add quit button to main menu

 */

public class GuessANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            Random rng = new Random();
            int generatedNumber = rng.nextInt(100);

            String userInput = scanner.nextLine();
            boolean isValidInput = evaluateStringToInt(userInput);
            int input;
            if (isValidInput) input = Integer.parseInt(userInput);
            else {
                System.out.println("Invalid input!");
                continue;
            }

            boolean isCorrectGuess = checkNumber(input, generatedNumber);
            while (!isCorrectGuess){
                userInput = scanner.nextLine();
                isValidInput = evaluateStringToInt(userInput);
                if (isValidInput) input = Integer.parseInt(userInput);
                else System.out.println("Invalid input!");
                isCorrectGuess = checkNumber(input, generatedNumber);
            }

            System.out.println("You guessed it!");

        }
    }

    public static boolean evaluateStringToInt(String string){
        char[] stringToCharArr = string.toCharArray();
        for (char ch : stringToCharArr){
            if (!Character.isDigit(ch)) return false;
        }
        return true;
    }

//    public static int takeUserInput(){
//        System.out.print("Guess the number (1-100): ");
//        Scanner scanner = new Scanner(System.in);
//        return Integer.parseInt(scanner.nextLine());
//    }

    public static boolean checkNumber(int n, int generatedNumber){
        if (n > generatedNumber) {
            System.out.println("Too high!");
            return false;
        }
        else if (n < generatedNumber) {
            System.out.println("Too low!");
            return false;
        }
        else return true;
    }
}