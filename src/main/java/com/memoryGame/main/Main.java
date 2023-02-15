package com.memoryGame.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        enum level {
            EASY, MEDIUM, HARD
        }

        Scanner in = new Scanner(System.in);
        level diff;
        int n = in.nextInt();
        switch (n) {
            default -> diff = level.EASY;
            case 2 -> diff = level.MEDIUM;
            case 3 -> diff = level.HARD;
        }

        if (diff == level.EASY) {

        }
    }
}
