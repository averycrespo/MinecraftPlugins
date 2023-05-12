package com.ave.test;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    // Diamond hoe = snowball launcher
    // iron hoe = egg launcher
    // netherite hoe = fireball launcher

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if(e.hasItem()) {
            if(e.getItem().getType().equals(Material.DIAMOND_HOE)) {
                player.launchProjectile(Snowball.class);
                player.sendMessage(ChatColor.RED + "You fired a snowball");
            } else if(e.getItem().getType().equals(Material.IRON_HOE)) {
                player.launchProjectile(Egg.class);
                player.sendMessage(ChatColor.BLUE + "You fired an egg");
            } else if(e.getItem().getType().equals(Material.NETHERITE_HOE)) {
                player.launchProjectile(Fireball.class);
                player.sendMessage(ChatColor.GREEN + "You fired a fireball");
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
