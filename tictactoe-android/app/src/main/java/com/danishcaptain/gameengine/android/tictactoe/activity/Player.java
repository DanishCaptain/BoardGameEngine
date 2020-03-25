package com.danishcaptain.gameengine.android.tictactoe.activity;

public class Player {
    private String cellDisplayText;

    public void setCellDisplayText(String cellDisplayText) {
        this.cellDisplayText = cellDisplayText;
    }

    public String getCellDisplayText() {
        return cellDisplayText;
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
