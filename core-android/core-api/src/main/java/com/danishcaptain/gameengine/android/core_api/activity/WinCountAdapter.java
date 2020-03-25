package com.danishcaptain.gameengine.android.core_api.activity;

import android.graphics.Color;
import android.widget.TextView;

import com.danishcaptain.gameengine.core.model.PlayerModel;
import com.danishcaptain.gameengine.core.model.domain.AddPlayerListener;
import com.danishcaptain.gameengine.core.model.domain.Player;
import com.danishcaptain.gameengine.core.model.domain.WinCountListener;

public class WinCountAdapter implements AddPlayerListener, WinCountListener {
    private final PlayerModel model;
    private final int index;
    private final TextView playerView;
    private final TextView countView;

    public WinCountAdapter(PlayerModel model, int index, TextView playerView, TextView countView) {
        this.model = model;
        this.index = index;
        this.playerView = playerView;
        this.countView = countView;
        countView.setText(Integer.toString(0));
        model.addAddPlayerListener(this);
    }

    @Override
    public void playerAdded(Player player, int index) {
        if (this.index == index) {
            player.addWinCountListener(this);
        }
    }

    @Override
    public void setNewWinCount(int winCount) {
        countView.setText(Integer.toString(winCount));
    }

    @Override
    public void markActive() {
        playerView.setTextColor(Color.parseColor("#AF7AC5"));
    }

    @Override
    public void markInactive() {
        playerView.setTextColor(Color.parseColor("#283747"));
    }
}
