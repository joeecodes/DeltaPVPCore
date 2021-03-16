package com.hypews.deltapvp.ui;

import com.hypews.deltapvp.DeltaPVP;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public abstract class CoreListener implements Listener {

    public CoreListener() {
        Bukkit.getPluginManager().registerEvents(this, DeltaPVP.getInstance());
        if (listenerName() != null) {
            Bukkit.getLogger().info("[Neutronic Log] Registered Listener " + listenerName());
        } else {
            Bukkit.getLogger().info("[Neutronic Log] Registered Listener " + this.getClass().getName() + " (No name provided)");
        }
    }

    public abstract String listenerName();

    @EventHandler
    public void attack(EntityDamageByEntityEvent e) {
        this.onAttack(e);
    }

    @EventHandler
    public void damage(EntityDamageEvent e) {
        this.onDamage(e);
    }

    @EventHandler
    public void move(PlayerMoveEvent e) {
        this.onMove(e);
    }

    @EventHandler
    public void bb(BlockBreakEvent e) {
        this.onBlockBreak(e);
    }

    @EventHandler
    public void bp(BlockPlaceEvent e) {
        this.onBlockPlace(e);
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        this.onJoin(e);
    }

    @EventHandler
    public void quit(PlayerQuitEvent e) {
        this.onQuit(e);
    }

    @EventHandler
    public void chat(AsyncPlayerChatEvent e) {
        this.onChat(e);
    }


    public void onAttack(EntityDamageByEntityEvent event) {

    }

    public void onDamage(EntityDamageEvent event) {

    }

    public void onMove(PlayerMoveEvent event) {

    }

    public void onBlockBreak(BlockBreakEvent event) {

    }

    public void onBlockPlace(BlockPlaceEvent event) {

    }

    public void onJoin(PlayerJoinEvent event) {

    }

    public void onQuit(PlayerQuitEvent event) {

    }

    public void onChat(AsyncPlayerChatEvent event) {

    }

    public DeltaPVP getCore() {
        return DeltaPVP.getInstance();
    }
}
