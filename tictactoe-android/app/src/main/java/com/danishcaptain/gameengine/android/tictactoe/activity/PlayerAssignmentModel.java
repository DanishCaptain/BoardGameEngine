package com.danishcaptain.gameengine.android.tictactoe.activity;

import com.danishcaptain.gameengine.android.tictactoe.BoardCell;
import com.danishcaptain.gameengine.android.tictactoe.model.TicTacToePiece;

public class PlayerAssignmentModel extends CellAssignmentModel {
    private final PlayerModel model;

    public PlayerAssignmentModel(PlayerModel model) {
        this.model = model;
    }

    @Override
    public void select(BoardCell boardCell) {
        boardCell.set(new TicTacToePiece(model.getCurrentPlayer()));
        model.advanceTurn();
    }
}
