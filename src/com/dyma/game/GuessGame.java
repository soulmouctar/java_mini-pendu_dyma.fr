package com.dyma.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessGame {
    private final List<Character> secretWord = new ArrayList<>();
    private int lifePoints;
    private final List<Character> guessWord = new ArrayList<>();

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
                '}';
    }
}
