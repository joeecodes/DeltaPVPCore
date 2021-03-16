package com.hypews.deltapvp;

import com.hypews.deltapvp.commands.CommandDeltaPVP;
import com.hypews.deltapvp.data.LangManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeltaPVP extends JavaPlugin {
    static DeltaPVP instance;

    /**
     * @return - Returns instance
     */
    public static DeltaPVP getInstance() {
        return instance;
    }

    /**
     * @param instance - Sets the instance
     */
    public static void setInstance(DeltaPVP instance) {
        DeltaPVP.instance = instance;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        setInstance(this);
        registerCommands();
        registerConfigurations();
        registerEvents();
        registerListener();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void listenerManager(Listener... listeners) {
        PluginManager manager = Bukkit.getPluginManager();
        for (Listener listener : listeners) {
            manager.registerEvents(listener, this);
        }
    }

    private void registerCommands() {
        new CommandDeltaPVP();
    }

    private void registerListener() {
        listenerManager(
                // "new ListenerName();"
        );
    }

    private void registerEvents() {

    }

    private void registerConfigurations() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        saveConfig();
        LangManager.setup();
    }

}
