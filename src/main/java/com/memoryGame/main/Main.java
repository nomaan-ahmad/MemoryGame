package com.memoryGame.main;

import com.memoryGame.game.*;
import com.memoryGame.user.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("How many players are going to play?");
            int numOfPlayers = Integer.parseInt(br.readLine());
            System.out.println("Do you want to give player name? If not, system will assign unique name to the players");
            System.out.println("Type 'Yes' or 'NO'! Wrong input will select NO by default");
            Player p;
            String ans = br.readLine().toLowerCase();
            if (ans.equalsIgnoreCase("yes")) p = new Player(numOfPlayers,true);
            else p = new Player(numOfPlayers, false);

            Game game = new Game(p.getPlayersName());
            game.startGame();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
