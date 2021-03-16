package com.hypews.deltapvp.utils;

import com.hypews.deltapvp.nms.ActionBar;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CoreUtils {

    public static void log(String s) {
        System.out.println(ChatColor.translateAlternateColorCodes('&', "[Neutronic Log] " + s));
    }

    public static void log_error(String s) {
        System.out.println(ChatColor.translateAlternateColorCodes('&', "[ChatFilter] &c&lERROR&r " + s));
    }

    public static void log_warning(String s) {
        System.out.println(ChatColor.translateAlternateColorCodes('&', "[ChatFilter] &6&lWARNING&r " + s));
    }

    public static void log_info(String s) {
        System.out.println(ChatColor.translateAlternateColorCodes('&', "[ChatFilter] &e&lINFO&r " + s));
    }

    public static void log_success(String s) {
        System.out.println(ChatColor.translateAlternateColorCodes('&', "[ChatFilter] &a&lSUCCESS&r " + s));
    }

    public static void log_outline(String s) {
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&7 " + s));
    }

    public static String translateColorCodes(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void sendTitle(Player p, String header, String footer) {
        p.sendTitle(translateColorCodes(header), translateColorCodes(footer));
    }

    public static void sendActionBar(Player p, String message) {
        ActionBar bar = new ActionBar(translateColorCodes(message));
        bar.send(p);
    }

    public static void playerEffect(Player p, Location l, Effect e) {
        p.playEffect(l, e, true);
    }

    public static void worldEffect(Location l, Effect e) {
        l.getWorld().playEffect(l, e, true);
    }

    public static void applyPotionEffect(Player p, PotionEffectType t, int d, int a) {
        if (p.hasPotionEffect(t)) {
            p.removePotionEffect(t);
        }
        p.addPotionEffect(new PotionEffect(t, 20 * d, a - 1));
    }

    public static void applyPotionEffect(LivingEntity e, PotionEffectType t, int d, int a) {
        if (e.hasPotionEffect(t)) {
            e.removePotionEffect(t);
        }
        e.addPotionEffect(new PotionEffect(t, 20 * d, a - 1));
    }
}