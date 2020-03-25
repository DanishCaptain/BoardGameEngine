package com.danishcaptain.gameengine.android.tictactoe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.danishcaptain.gameengine.android.tictactoe.GameActivity;
import com.danishcaptain.gameengine.android.tictactoe.R;
import com.danishcaptain.gameengine.android.tictactoe.rules.TicTacTocGameRules;
import com.danishcaptain.gameengine.core.model.PlayerModel;
import com.danishcaptain.gameengine.core.model.domain.BoardCell;
import com.danishcaptain.gameengine.core.model.domain.GameBoard;
import com.danishcaptain.gameengine.core.model.domain.Player;
import com.danishcaptain.gameengine.core.model.domain.rules.CellImmutableWhenSet;
import com.danishcaptain.gameengine.core.model.domain.rules.RulesEngine;

import java.util.List;

public class TicTacToeActivity extends GameActivity {
    @Override
    protected int getRowCount() {
        return 3;
    }

    @Override
    protected int getColumnCount() {
        return 3;
    }
    @Override
    protected void initBoard(GameBoard gameBoard) {
        PlayerModel playerModel = gameBoard.getPlayerModel();
        playerModel.addPlayer(new Player.Builder().setCellDisplayText("X").build());
        playerModel.addPlayer(new Player.Builder().setCellDisplayText("O").build());

        List<BoardCell> cells = gameBoard.getCells();
        for (BoardCell cell : cells) {
            cell.setSelectionModel(new PlayerAssignmentModel(playerModel));
        }
    }

    @Override
    protected void initRules(GameBoard gameBoard) {
        RulesEngine rules = gameBoard.getRules();
        rules.addRule(new CellImmutableWhenSet());
        rules.addRule(new TicTacTocGameRules(gameBoard, gameBoard.getCells()));
    }

}
