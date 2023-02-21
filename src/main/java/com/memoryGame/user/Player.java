package com.memoryGame.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private final List<String> players;
    private final int numOfPlayers;
    public Player(int numOfPlayers, boolean customName) {
        this.numOfPlayers = numOfPlayers;
        players = new ArrayList<>();
        if (customName) playerName();
        else createRandomName();
    }

    private void playerName() {
        System.out.println("Kindly type " + numOfPlayers + " player name...");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < numOfPlayers; i++) {
            String name = in.nextLine();
            players.add(name);
        }
    }
    private void createRandomName(){
        RandomNameGenerator r = new RandomNameGenerator();
        for (int i = 0; i < numOfPlayers; i++) {
            players.add(r.randomName());
        }

        System.out.println("System has generated names which are as follows:");
        System.out.println(players + "\n");
    }
    public List<String> getPlayersName() {
        return players;
    }
}
