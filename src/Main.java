import com.dyma.game.GuessGame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var random = new Random();
        final var words = "abuser crotte continetal alpha yaya mamadou école ingenieur".split(" ");
        final var wordToGuess = words[random.nextInt(words.length)];
        final var game = new GuessGame(wordToGuess, 10);

        System.out.println("DEBUT DU JEU DE PENDU");

        while (true) {
            System.out.println(game);
            System.out.print("Entrez une lettre : ");
            final var letter = scanner.nextLine().charAt(0);
        }
    }
}