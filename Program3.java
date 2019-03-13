

//Brian Byrne CS140 Program 3 Mr. Klein 3/26/2013

package program3;

import java.util.Scanner;
import program3.Dictionary;
import program3.WordHider;

public class Program3 {

    
    public static void main(String[] args) {

        WordHider hidden = new WordHider();
        Dictionary reference = new Dictionary();
        Scanner keyboard = new Scanner(System.in);

        int guessCounter = 6;
        String choice; 


        System.out.println("Welcome to the Hangman Game.");
        String board = reference.getRandomWord();
        hidden.setSecretWord(board);
        String view = hidden.getWordMask();
        do {

            if (hidden.isHiddenWordFound()) {
                System.out.println("Congratulations, you won");
                System.exit(0);

            } else {
                System.out.println("Word: " + hidden.getWordMask());
                System.out.println("Guesses left: " + guessCounter);
                System.out.println("Please enter your guess");
                choice = keyboard.next();

                if (hidden.revealLetter(choice) >= 1) {
                    hidden.revealLetter(choice);                    
                    System.out.println(hidden.getWordMask());
                } else {
                    System.out.println("Miss, try again");
                    guessCounter = guessCounter - 1;     
                }
            }
        } while (guessCounter >= 1);
        System.out.println("Sorry, out of guesses");
        System.out.println("You lose");
        System.out.println("The word was: " + board);
    }
}
