package com.danishcaptain.gameengine.android.hnefatafl.activity;

import com.danishcaptain.gameengine.android.hnefatafl.domain.KingPiece;
import com.danishcaptain.gameengine.core.model.CellAssignmentModel;
import com.danishcaptain.gameengine.core.model.PlayerModel;
import com.danishcaptain.gameengine.core.model.domain.BoardCell;

public class PlayerAssignmentModel extends CellAssignmentModel {
    private final PlayerModel model;

    public PlayerAssignmentModel(PlayerModel model) {
        this.model = model;
    }

    @Override
    public void select(BoardCell boardCell) {
        System.out.println(boardCell.getId()+"::"+boardCell.isEmpty());
//        boardCell.set(new KingPiece(model.getCurrentPlayer()));
//        model.advanceTurn();
    }
}
