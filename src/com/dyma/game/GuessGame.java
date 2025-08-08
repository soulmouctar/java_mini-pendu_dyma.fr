package com.dyma.game;

import java.util.*;

/**
 * TO DO
 */
public class GuessGame {

    /**
     * The secret word to guess, represented as a list of characters.
     */
    private final List<Character> secretWord = new ArrayList<>();
    /**
     * The number of life points remaining for the player.
     */
    private int lifePoints;
    /**
     * The current state of the guessed word, represented as a list of characters.
     */
    private final List<Character> guessWord = new ArrayList<>();
    /**
     * The set of letters that have been guessed by the player.
     */
    private final Set<Character> guessLetter = new HashSet<>();

    /**
     * @param wordToGuess
     * @param lifePoints
     */
    public GuessGame(String wordToGuess, int lifePoints) {
        for (char c : wordToGuess.toCharArray()) {
            this.secretWord.add(c);
        }
        this.lifePoints = lifePoints;
        for(int index = 0; index < this.secretWord.size(); index++) {
            this.guessWord.add('_');
        }
    }

    @Override
    public String toString() {
        return "GuessGame{" +
                "lifePoints=" + lifePoints +
                ", guessWord=" + guessWord +
                ", guessLetter=" + guessLetter +
                '}';
    }

    public void guessLetter(char letter) {
        guessLetter.add(letter);
        if(secretWord.contains(letter) && !guessWord.contains(letter)) {
            var index = 0;
            for (char c : secretWord) {
                if (c == letter) {
                    guessWord.set(index, c);
                }
                index++;
            }
        } else {
            lifePoints--;
        }
    }

    public boolean isLost() {
        return lifePoints <= 0;
    }

    public boolean isWon() {
        return !guessWord.contains('_');
    }
}
