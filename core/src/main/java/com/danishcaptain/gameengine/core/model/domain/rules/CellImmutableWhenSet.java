package com.danishcaptain.gameengine.core.model.domain.rules;

import com.danishcaptain.gameengine.core.model.domain.BoardCell;

public class CellImmutableWhenSet extends CellRule {
    @Override
    public boolean isValid(BoardCell cell) {
        return cell.isEmpty();
    }
}
