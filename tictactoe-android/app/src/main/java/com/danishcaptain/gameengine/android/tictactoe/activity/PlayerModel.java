package com.danishcaptain.gameengine.android.tictactoe.activity;

import java.util.ArrayList;

public class PlayerModel {
    private Player currentPlayer;
    private ArrayList<Player> playersL = new ArrayList<>();

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void addPlayer(Player player) {
        playersL.add(player);
        if (currentPlayer == null) {
            currentPlayer = player;
        }
    }

    public void advanceTurn() {
        if (playersL.size() == 2) {
            if (playersL.get(0) == currentPlayer) {
                currentPlayer = playersL.get(1);
            } else {
                currentPlayer = playersL.get(0);
            }
        } else {
            throw new RuntimeException("Hey you need to implement this!!!");
        }
    }
}
