package com.memoryGame.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private List<String> players;
    private final int numOfPlayers;
    public Player(int numOfPlayers, boolean customName) {
        this.numOfPlayers = numOfPlayers;
        if (customName) playerName();
        else createRandomName();
    }

    private void playerName() {
        System.out.println("Kindly type " + numOfPlayers + " player's name...");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < numOfPlayers; i++) {
            players.add(in.nextLine());
        }
    }
    private void createRandomName(){
        RandomNameGenerator r = new RandomNameGenerator();
        players = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            players.add(r.randomName());
        }
    }
    public List<String> getPlayersName() {
        return players;
    }
}
