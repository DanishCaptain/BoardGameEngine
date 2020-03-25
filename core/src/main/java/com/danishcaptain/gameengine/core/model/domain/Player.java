package com.danishcaptain.gameengine.core.model.domain;

import java.util.ArrayList;

public class Player {
    private String cellDisplayText;
    private ArrayList<WinCountListener> winCountListenerL = new ArrayList<>();
    private int winCount;

    public void setCellDisplayText(String cellDisplayText) {
        this.cellDisplayText = cellDisplayText;
    }

    public String getCellDisplayText() {
        return cellDisplayText;
    }

    public void addWinCountListener(WinCountListener listener) {
        winCountListenerL.add(listener);
    }

    public void markWin() {
        winCount++;
        for (WinCountListener lis : winCountListenerL) {
            lis.setNewWinCount(winCount);
        }
    }

    public void setActive(boolean b) {
        if (b) {
            for (WinCountListener lis : winCountListenerL) {
                lis.markActive();
            }
        } else {
            for (WinCountListener lis : winCountListenerL) {
                lis.markInactive();
            }
        }
    }

    public static class Builder {
        private Player player = new Player();

        public Builder setCellDisplayText(String text) {
            player.setCellDisplayText(text);
            return this;
        }

        public Player build() {
            return player;
        }
    }
}
