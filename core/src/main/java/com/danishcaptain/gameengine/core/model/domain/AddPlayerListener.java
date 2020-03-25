package com.danishcaptain.gameengine.core.model.domain;

import com.danishcaptain.gameengine.core.model.domain.Player;

public interface AddPlayerListener {
    void playerAdded(Player player, int index);
}
