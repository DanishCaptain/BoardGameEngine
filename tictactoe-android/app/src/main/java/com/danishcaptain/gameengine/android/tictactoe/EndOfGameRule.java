package com.danishcaptain.gameengine.android.tictactoe;

import com.danishcaptain.gameengine.android.tictactoe.activity.Player;

public abstract class EndOfGameRule {
    public abstract boolean hasGameEnded();
    public abstract Player getWinner();
}
