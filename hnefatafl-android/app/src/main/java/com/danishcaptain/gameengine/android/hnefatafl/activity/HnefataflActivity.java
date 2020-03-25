package com.danishcaptain.gameengine.android.hnefatafl.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.danishcaptain.gameengine.android.core_api.activity.GameActivity;
import com.danishcaptain.gameengine.android.hnefatafl.R;
import com.danishcaptain.gameengine.core.model.PlayerModel;
import com.danishcaptain.gameengine.core.model.domain.BoardCell;
import com.danishcaptain.gameengine.core.model.domain.GameBoard;
import com.danishcaptain.gameengine.core.model.domain.Player;
import com.danishcaptain.gameengine.core.model.domain.rules.CellImmutableWhenSet;
import com.danishcaptain.gameengine.core.model.domain.rules.RulesEngine;
import com.danishcaptain.gameengine.android.hnefatafl.rules.HnefataflGameRules;

import java.util.List;

public class HnefataflActivity extends GameActivity {
    @Override
    protected int getRowCount() {
        return 11;
    }

    @Override
    protected int getColumnCount() {
        return 11;
    }
    @Override
    protected void initBoard(GameBoard gameBoard) {
        PlayerModel playerModel = gameBoard.getPlayerModel();
        playerModel.addPlayer(new Player.Builder().setCellDisplayText("1").build());
        playerModel.addPlayer(new Player.Builder().setCellDisplayText("2").build());

        List<BoardCell> cells = gameBoard.getCells();
        for (BoardCell cell : cells) {
            cell.setSelectionModel(new PlayerAssignmentModel(playerModel));
            if ("1::1".equals(cell.getId())) {
                cell.setDefaultDisplayValue("X");
            } else if ("1::11".equals(cell.getId())) {
                cell.setDefaultDisplayValue("X");
            } else if ("6::6".equals(cell.getId())) {
                cell.setDefaultDisplayValue("X");
            } else if ("11::1".equals(cell.getId())) {
                cell.setDefaultDisplayValue("X");
            } else if ("11::11".equals(cell.getId())) {
                cell.setDefaultDisplayValue("X");
            }
        }
    }

    @Override
    protected void initRules(GameBoard gameBoard) {
        RulesEngine rules = gameBoard.getRules();
        rules.addRule(new CellImmutableWhenSet());
        rules.addRule(new HnefataflGameRules(gameBoard, gameBoard.getCells()));
    }

}
