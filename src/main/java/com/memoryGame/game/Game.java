package com.memoryGame.game;

import java.util.*;

public class Game extends GameBehaviour{
    private final List<String> players;
    private Difficulty difficulty;
    private int cycle;


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
    public Game(List<String> players) {
        this.players = players;
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
        List<String> answer = new ArrayList<>();
        while (!players.isEmpty()) {
            if (players.size() == 1) {
                if (challenge(answer, 0))
                    System.out.println("Yay!! " + players.get(0) + " won");
                else System.out.println("Oops!! no one win the game :(");
                break;
            }
            for (int i = 0; i < this.cycle; i++) {
                for (String names : players) {
                    System.out.println("Give a word to the team " + names);
                    System.out.println("Word should not be greater than " + map.get(difficulty));
                    answer.add(getWord());
                }
            }

            // Below statement will select any player randomly
            int rand = new Random().nextInt(players.size());
            String player = players.get(rand);
            if (!challenge(answer, rand)) {
                System.out.println(player + "successfully answered all words. Game will continue..");
            }else{
                System.out.println("It looks like, " + player + " didn't able to answer");
                System.out.println(player + " is eliminated");
                players.remove(rand);
            }
        }
    }

    private void rules() {
        System.out.println("Rules is simple");
        System.out.println("""
                There will multiple cycle in the game and in each cycle everyone has to say a word
                and everyone has remember each word in the same order.
                When everybody is done with telling word then random person is selected and has to speak all words in the same order
                if they successfully tell all words in same order then game continues and if not then they will be eliminated""");
    }

    private String getWord() {
        Scanner sc = new Scanner(System.in);
        String ans = null;
        boolean flag = false;
        while (!flag) {
            System.out.println("Type a word : (case insensitive)");
            ans = sc.nextLine().toLowerCase();
            if (wordValidation(ans, map.get(difficulty))) flag = true;
        }
        return ans;
    }

    // Checking input word by user, because word containing numbers and symbols are not accepted by system by default
    private boolean wordValidation(String word, int maxLen) {
        // Checking for presence of number and symbol
        String regex = String.format("[a-z]{1,%s}", maxLen);
        return word.matches(regex);
    }

    /* ********** Challenge ********** */
    private boolean challenge(List<String> allWords, int ran) {
        // selected player has to answer all words in right order
        List<String> given = helper(players.get(ran), allWords.size());

        // Now we will compare the list of word challenged player told with actual list of words
        return compare(allWords, given);
    }

    // While challenged any player, helper method ask all words from the player
    private List<String> helper(String name, int wordLen) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please write all the words in correct order " + name);
        System.out.println("Remember all words are case insensitive");
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < wordLen; i++) {
            System.out.println("Type " + i+1 +"th word");
            temp.add(sc.nextLine().toLowerCase());
        }
        return temp;
    }

    // Compare if two list contains same values in same order or not
    private boolean compare(List<String> actual, List<String> given) {
        int size = actual.size();
        if (given.size() != size) return false;

        for (int i = 0; i < size; i++)
            if (!(actual.get(i).equals(given.get(i)))) return false;

        return true;
    }
}
