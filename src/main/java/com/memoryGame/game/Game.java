package com.memoryGame.game;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<String> players;
    private int numOfPlayers;
    private Difficulty difficulty;

    // Difficulty enum
    private enum Difficulty {
        EASY,
        MEDIUM,
        HARD
    }

    private final HashMap<Difficulty, Integer> map = new HashMap<>();
    {
        map.put(Difficulty.EASY, 5);
        map.put(Difficulty.MEDIUM, 10);
        map.put(Difficulty.HARD, 15);
    }

    Game(List<String> players, int numOfPlayers) {
        this.players = players;
        this.numOfPlayers = numOfPlayers;
        askDifficulty();
    }

    private void askDifficulty() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose difficulty: max length of the word allowed\nEasy -> 5 length\nMedium -> 10 length\nHard -> 15 length");
        System.out.println("Type Easy, medium or hard, if wrong input typed 'Easy' will be chosen by default");
        String input = sc.nextLine();
        switch (input) {
            default -> difficulty = Difficulty.EASY;
            case "medium" -> difficulty = Difficulty.MEDIUM;
            case "Hard" -> difficulty = Difficulty.HARD;
        }
    }


}
