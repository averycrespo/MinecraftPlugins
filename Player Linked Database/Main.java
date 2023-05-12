package com.ave.test;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Main extends JavaPlugin implements Listener {

    private Database database;

    private PlayerManager playerManager;

    @Override
    public void onEnable() {
        database = new Database();
        try {
            database.connect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        playerManager = new PlayerManager();
        Bukkit.getPluginManager().registerEvents(new ConnectionListener(this), this);
    }

    public Database getDatabase() { return database; }

    public void onDisable() {
        database.disconnect();
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

}
