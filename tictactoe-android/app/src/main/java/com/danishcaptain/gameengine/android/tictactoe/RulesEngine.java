package com.danishcaptain.gameengine.android.tictactoe;

import com.danishcaptain.gameengine.android.tictactoe.activity.CellRule;
import com.danishcaptain.gameengine.android.tictactoe.activity.Player;

import java.util.ArrayList;

public class RulesEngine {
    private final GameBoard gameBoard;
    private ArrayList<CellRule> cellRulesL = new ArrayList<>();
    private ArrayList<EndOfGameRule> eogRulesL = new ArrayList<>();

    public RulesEngine(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public boolean isSelectedValid(BoardCell cell) {
        for (CellRule rule : cellRulesL) {
            if (!rule.isValid(cell)) {
                return false;
            }
        }
        return true;
    }

    public void select(BoardCell cell) {
        cell.selectCell();
    }

    public void addRule(CellRule rule) {
        cellRulesL.add(rule);
    }

    public void addRule(EndOfGameRule rule) {
        eogRulesL.add(rule);
    }

    public boolean checkForEndOfGame() {
        for (EndOfGameRule rule : eogRulesL) {
            if (!rule.hasGameEnded()) {
                return false;
            }
        }
        return true;
    }

    public Player getWinner() {
        Player result = null;
        for (EndOfGameRule rule : eogRulesL) {
            result = rule.getWinner();
            if (result != null) {
                return result;
            }
        }
        return result;
    }
}
