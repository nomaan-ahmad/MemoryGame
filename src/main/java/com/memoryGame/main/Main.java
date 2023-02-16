package com.memoryGame.main;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.print(generateRandom(20) + " ");
        }
    }

    public static int generateRandom(int upperBound) {
        return new Random().nextInt(upperBound);
    }
    private static boolean wordValidation(String word, int maxLen) {
        // Checking for presence of number
        String regex = String.format("[a-z]{1,%s}", maxLen);
        System.out.println(regex);
        return word.matches(regex);
    }
}
