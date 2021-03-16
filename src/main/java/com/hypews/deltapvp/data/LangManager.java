package com.hypews.deltapvp.data;

import com.hypews.deltapvp.DeltaPVP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

import static com.hypews.deltapvp.utils.CoreUtils.log_error;

public class LangManager {
    static Plugin main = DeltaPVP.getInstance();
    private static File lang;
    private static FileConfiguration langFile;

    public static void setup() {
        lang = new File(main.getDataFolder(), "lang.yml");
        if (!lang.exists()) {
            try {
                lang.createNewFile();
            } catch (IOException e) {
                log_error("An error occurred within the Language Manager");
                e.printStackTrace();
            }
        }
        langFile = YamlConfiguration.loadConfiguration(lang);

    }

    public static FileConfiguration getData() {
        return langFile;
    }

    public static void saveData() {
        try {
            langFile.save(lang);
        } catch (IOException e) {
            log_error("An error occurred within the Language Manager");
            e.printStackTrace();
        }
    }

    public static void dataReload() {
        langFile = YamlConfiguration.loadConfiguration(lang);
    }
}
