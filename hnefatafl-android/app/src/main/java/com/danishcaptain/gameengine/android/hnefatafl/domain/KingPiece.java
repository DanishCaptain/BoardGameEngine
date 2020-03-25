package com.danishcaptain.gameengine.android.hnefatafl.domain;

import com.danishcaptain.gameengine.core.model.domain.BoardPiece;
import com.danishcaptain.gameengine.core.model.domain.Player;

public class KingPiece extends BoardPiece {
    private final Player player;

    public KingPiece(Player player) {
        super(player.getCellDisplayText());
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof KingPiece) {
            return player == ((KingPiece)o).player;
        } else {
            return false;
        }
    }
}
