import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random rng = new Random();
        int generatedNumber = rng.nextInt(100);

        int input = takeUserInput();

        boolean isCorrectGuess = checkNumber(input, generatedNumber);
        while (!isCorrectGuess){
            input = takeUserInput();
            isCorrectGuess = checkNumber(input, generatedNumber);
        }

        System.out.println("You guessed it!");
    }

    public static int takeUserInput(){
        System.out.print("Guess the number (1-100): ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

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