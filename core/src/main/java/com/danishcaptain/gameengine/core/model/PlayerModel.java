package com.danishcaptain.gameengine.core.model;

import com.danishcaptain.gameengine.core.model.domain.AddPlayerListener;
import com.danishcaptain.gameengine.core.model.domain.Player;

import java.util.ArrayList;

public class PlayerModel {
    private Player currentPlayer;
    private ArrayList<Player> playersL = new ArrayList<>();
    private ArrayList<AddPlayerListener> addPlayerListenerL = new ArrayList<>();

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void addPlayer(Player player) {
        playersL.add(player);
        if (currentPlayer == null) {
            currentPlayer = player;
            currentPlayer.setActive(true);
        }
        for (AddPlayerListener lis : addPlayerListenerL) {
            lis.playerAdded(player, playersL.size());
        }
    }

    public void advanceTurn() {
        if (playersL.size() == 2) {
            if (playersL.get(0) == currentPlayer) {
                currentPlayer.setActive(false);
                currentPlayer = playersL.get(1);
                currentPlayer.setActive(true);
            } else {
                currentPlayer.setActive(false);
                currentPlayer = playersL.get(0);
                currentPlayer.setActive(true);
            }
        } else {
            throw new RuntimeException("Hey you need to implement this!!!");
        }
    }

    public void addAddPlayerListener(AddPlayerListener listener) {
        addPlayerListenerL.add(listener);
    }
}
