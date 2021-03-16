package com.hypews.deltapvp.ui;

import com.hypews.deltapvp.DeltaPVP;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class Menu implements Listener {

    Player player;
    Inventory inv;
    int page;

    /**
     * @param viewer - Viewer of the menu
     */
    public Menu(Player viewer) {
        this.player = viewer;
        this.inv = Bukkit.createInventory(null, this.size(), this.name());
        Bukkit.getPluginManager().registerEvents(this, DeltaPVP.getInstance());
    }

    /**
     * @param viewer - Viewer of the menu
     * @param page   - Page number
     */
    public Menu(Player viewer, int page) {
        this.player = viewer;
        this.inv = Bukkit.createInventory(null, this.size(), this.name());
        this.page = page;
        Bukkit.getPluginManager().registerEvents(this, DeltaPVP.getInstance());
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if (e.getView().getTitle().equals(name())) {
            this.onCloseInventory(e);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(name())) {
            e.setCancelled(!this.canTakeItems());
            if (e.getCurrentItem() == null) {
                return;
            }
            this.onClickInventory(e);
        }
    }

    public abstract String name();

    public abstract int size();

    public abstract boolean canTakeItems();

    public void onClickInventory(InventoryClickEvent inventoryClickEvent) {

    }

    public void onCloseInventory(InventoryCloseEvent inventoryCloseEvent) {

    }

    public abstract void Contents(Inventory p0);

    public void open() {
        Contents(inv);
        player.openInventory(inv);
    }

    /**
     * @param index - Slot number
     * @param item  - Item to go into the menu
     */
    public void addItem(int index, ItemStack item) {
        this.inv.setItem(index, item);
    }

}
