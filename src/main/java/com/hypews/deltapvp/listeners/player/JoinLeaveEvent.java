package com.hypews.deltapvp.listeners.player;

import com.hypews.deltapvp.Messages;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class JoinLeaveEvent implements Listener {
    @Deprecated
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', Messages.JOIN_MESSAGE.replaceAll("%player%", p.getName())));
    }

    @Deprecated
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', Messages.LEAVE_MESSAGE.replaceAll("%player", p.getName())));
    }
}
