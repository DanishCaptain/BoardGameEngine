package com.danishcaptain.gameengine.android.tictactoe.model;

import com.danishcaptain.gameengine.android.tictactoe.BoardPiece;
import com.danishcaptain.gameengine.android.tictactoe.activity.Player;

public class TicTacToePiece extends BoardPiece {
    private final Player player;

    public TicTacToePiece(Player player) {
        super(player.getCellDisplayText());
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TicTacToePiece) {
            return player == ((TicTacToePiece)o).player;
        } else {
            return false;
        }
    }
}
