package com.danishcaptain.gameengine.android.tictactoe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.danishcaptain.gameengine.android.tictactoe.BoardCell;
import com.danishcaptain.gameengine.android.tictactoe.GameActivity;
import com.danishcaptain.gameengine.android.tictactoe.GameBoard;
import com.danishcaptain.gameengine.android.tictactoe.R;
import com.danishcaptain.gameengine.android.tictactoe.RulesEngine;
import com.danishcaptain.gameengine.android.tictactoe.rules.TicTacTocGameRules;

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
