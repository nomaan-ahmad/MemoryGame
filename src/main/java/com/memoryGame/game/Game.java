package com.memoryGame.game;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Game extends GameBehaviour{
    private List<String> players;
    private int numOfPlayers;
    private Difficulty difficulty;
    private int cycle;


    // Difficulty enum
    private enum Difficulty {
        EASY,
        MEDIUM,
        HARD;
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
        askCycle();
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

    private void askCycle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tell after how many cycle, someone has to be challenged");
        System.out.println("Cycle should not exceed 10\nType the number of cycle you want: (default -> 1)");
        try {
            int c = Integer.parseInt(sc.nextLine());
            if (c <= 0 || c > 10) this.cycle = 1;
            else this.cycle = c;
        }catch (Exception e) {
            System.out.println("You have type wrong input, 1 is selected as default");
            this.cycle = 1;
        }
    }

    /* ******************* Game features ******************* */
    @Override
    public void startGame() {
        rules();

    }

    private void rules() {
        System.out.println("Rules is simple");
        System.out.println("""
                There will multiple cycle in the game and in each cycle everyone has to say a word
                and everyone has remember each word in the same order.
                When everybody is done with telling word then random person is selected and has to speak all words in the same order
                if they successfully tell all words in same order then game continues and if not then they will be eliminated""");
    }
}
