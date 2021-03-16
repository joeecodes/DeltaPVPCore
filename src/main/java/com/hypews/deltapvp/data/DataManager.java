package com.hypews.deltapvp.data;

import com.hypews.deltapvp.DeltaPVP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

import static com.hypews.deltapvp.utils.CoreUtils.log_error;

public class DataManager {
    static Plugin main = DeltaPVP.getInstance();
    private static File data;
    private static FileConfiguration dataFile;

    public static void setup() {
        data = new File(main.getDataFolder(), "data.yml");
        if (!data.exists()) {
            try {
                data.createNewFile();
            } catch (IOException e) {
                log_error("An error occurred within the Data Manager");
                e.printStackTrace();
            }
        }
        dataFile = YamlConfiguration.loadConfiguration(data);

    }

    public static FileConfiguration getData() {
        return dataFile;
    }

    public static void saveData() {
        try {
            dataFile.save(data);
        } catch (IOException e) {
            log_error("An error occurred within the Data Manager");
            e.printStackTrace();
        }
    }

    public static void dataReload() {
        dataFile = YamlConfiguration.loadConfiguration(data);
    }
}
