import com.dyma.game.GuessGame;

import java.util.Random;
import java.util.Scanner;

/**
 * Main class to run the Guess Game.
 * The game allows players to guess letters of a secret word within a limited number of attempts.
 */
public class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var random = new Random();
        final var words = "abuser crotte continental alpha yaya mamadou école ingenieur".split(" ");
        var wordToGuess = words[random.nextInt(words.length)];
        var game = new GuessGame(wordToGuess, 10);

        System.out.println("DEBUT DU JEU DE PENDU");

        while (true) {
            System.out.println(game);
            final var letter = scanLetter("Entrez une lettre : ");
            game.guessLetter(letter);

            if (game.isLost()) {
                System.out.println("Vous avez perdu !");
                System.out.println(game);
                System.out.println("Le mot était : " + wordToGuess);
            }

            if (game.isWon()) {
                System.out.println(game);
                System.out.println("Félicitations, vous avez gagné !");
                break;
            }

            if(game.isLost() || game.isWon()) {
                var replay = scanLetter("Voulez vous rejouer ? (o/n) : ");
                if(replay == 'o' || replay == 'O') {
                    wordToGuess = words[random.nextInt(words.length)];
                    game = new GuessGame(wordToGuess, 10);
                } else {
                    System.out.println("Merci d'avoir joué !");
                    break;
                }
            }
        }

    }

    private static char scanLetter(String question) {
        final var scanner = new Scanner(System.in);
        Character letter = null;
        do{
            System.out.println(question);
            var input = scanner.nextLine();
            if (input.length() == 1) {
                letter = input.charAt(0);
            }
        } while (letter == null);
        return letter;
    }
}