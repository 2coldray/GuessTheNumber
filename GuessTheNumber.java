import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main (String[] args) {
        // Welcome Prompt
        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("What is your name?");

        // Take user's input for name
        Scanner getInput = new Scanner(System.in);
        String nameInput = getInput.nextLine();
        System.out.println("Well, " + nameInput + ", I  am thinking of a number between 1 and 20.");
        System.out.println("Take a guess.");
        int userGuess = getInput.nextInt();
        //System.out.println(userGuess);

        // Make the computer guess a random number between 1 and 20
        Random rand = new Random();
        int min = 1;
        int max = 20;
        int computerGuess = rand.nextInt(max + min) + min;
        //System.out.println(computerGuess);

        /*
        Game Logic
        * Need variable for tries that will increment
        * Need conditional
        * If userGuess > ComputerGuess, too high, Guess again
        * If userGuess < ComputerGuess, too low, Guess again
        * If userGuess == ComputerGuess, You win, exit loop
        */

        /*
        * Play Again Logic
        * Use Switch Statement
        * If User chooses Y, reset tries to 0, need new number, clear scanners
        * If User chooses N, break out of loop*/

        //Variable for tries
        int tries = 0;
        boolean playing = true;

        //While Loop for game
        while (playing) {
            if (userGuess > computerGuess) {
                System.out.println("Your guess is too high");
                System.out.println("Take a guess");
                userGuess = getInput.nextInt();
                tries++;
                //System.out.println(tries);
            } else if (userGuess < computerGuess) {
                System.out.println("Your guess is too low");
                System.out.println("Take a guess");
                userGuess = getInput.nextInt();
                tries++;
                //System.out.println(tries);
            } else if (userGuess == computerGuess) {
                System.out.println("Good job, " + nameInput + "!");
                System.out.println("You guessed my number in " + tries + " guesses!");
                System.out.println("Would you like to play again? (y or n)");
            } else if (tries == 6) {
                System.out.println("Sorry you ran out of tries");
            }

            String endGameInput = getInput.nextLine();
            System.out.println(endGameInput);
            switch (endGameInput) {
                case "y":
                    System.out.println("Guess a new number");
                    userGuess = getInput.nextInt();
                    tries = 0;
                    playing = true;
                    computerGuess = rand.nextInt(21);
                    break;
                case "n":
                    System.out.println("Game Over!");
                    tries = 6;
                    playing = false;
                    break;
            }
        }

    }
}
