package com.ave.test;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {

    private HashMap<UUID, CustomPlayer> customPlayer = new HashMap<>();

    public CustomPlayer getCustomPlayer(UUID uuid) {
        return customPlayer.get(uuid);
    }

    public void addCustomPlayer(UUID uuid, CustomPlayer player) {
        customPlayer.put(uuid, player);
    }

    public void removeCustomPlayer(UUID uuid) {
        customPlayer.remove(uuid);
    }

}
