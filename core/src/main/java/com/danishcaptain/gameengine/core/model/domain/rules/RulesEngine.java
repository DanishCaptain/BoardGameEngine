package com.danishcaptain.gameengine.core.model.domain.rules;

import com.danishcaptain.gameengine.core.model.domain.BoardCell;
import com.danishcaptain.gameengine.core.model.domain.GameBoard;

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

}
