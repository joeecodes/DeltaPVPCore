package com.hypews.deltapvp.listeners.server;

import com.hypews.deltapvp.data.DataManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class Whitelist implements Listener {
    @EventHandler
    @Deprecated
    public void playerWhitelistCheck(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        List<String> whitelisted = DataManager.getData().getStringList("whitelisted-players");
        if (whitelisted.contains(p.getUniqueId())) {
            e.getPlayer().kickPlayer("You are not whitelisted on DeltaPVP");
        }
    }
}
