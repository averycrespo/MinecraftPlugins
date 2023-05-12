package com.ave.test;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class Main extends JavaPlugin implements Listener {

    private Database database;

    @Override
    public void onEnable() {
        database = new Database();
        try {
            database.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(database.isConnected());
    }

    public void onDisable() {
        database.disconnect();
    }

}
