package com.memoryGame.main;

import com.memoryGame.game.*;
import com.memoryGame.user.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many players are going to play?");
        int numOfPlayers = sc.nextInt();
        System.out.println("Do you want to give player name? If not, system will assign unique name to the players");
        System.out.println("Type 'Yes' or 'NO'! Wrong input will select NO by default");
        Player p;
        String ans = sc.nextLine().toLowerCase();
        if (ans.equalsIgnoreCase("yes")) p = new Player(numOfPlayers,true);
        else p = new Player(numOfPlayers, false);

        Game game = new Game(p.getPlayersName());
        game.startGame();
    }
}
