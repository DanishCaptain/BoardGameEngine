package com.danishcaptain.gameengine.core.model.domain.rules;

import com.danishcaptain.gameengine.core.model.domain.BoardCell;

public abstract class CellRule extends Rule {
    public abstract boolean isValid(BoardCell cell);
}
