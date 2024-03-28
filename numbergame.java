import java.util.Random;
import java.util.Scanner;

public class numbergame
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        
        System.out.println("GUESS THE NUMBER!");
        System.out.println("I've picked a number between " + min + " and " + max + ". Try to guess it!");
        
        int targetNumber = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        int maxAttempts = 8;
        boolean guessedCorrectly = false;

        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                guessedCorrectly = true;
            } else if (guess < targetNumber) {
                System.out.println("Too low! Try once again.");
            } else {
                System.out.println("Too high! Try once again.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've run out of attempts. The number was " + targetNumber + ".");
        }

        scanner.close();
        System.out.println("Thanks for playing!");
    }
}
