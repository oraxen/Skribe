package io.th0rgal.skribe.settings;

import io.th0rgal.skribe.SkribePlugin;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConfigsManager {

    private JavaPlugin plugin;
    private YamlConfiguration defaultConfiguration;
    private int currentversion;
    private File iconsFolder;

    public ConfigsManager(JavaPlugin plugin) {
        this.plugin = plugin;
        defaultConfiguration = YamlConfiguration
                .loadConfiguration(new InputStreamReader(plugin.getResource("settings.yml")));

        currentversion = defaultConfiguration.getInt("configs_version");
    }

    public boolean validatesConfig() {
        ResourcesManager resourcesManager = new ResourcesManager(SkribePlugin.get());
        File userConfigurationFile = resourcesManager.extractConfiguration("settings.yml");
        YamlConfiguration userConfiguration = YamlConfiguration.loadConfiguration(userConfigurationFile);
        boolean updated = false;
        for (String key : defaultConfiguration.getKeys(true))
            if (userConfiguration.get(key) == null) {
                updated = true;
                MessageOld.UPDATING_CONFIG.logError(key);
                userConfiguration.set(key, defaultConfiguration.get(key));
            }

        if (updated)
            try {
                userConfiguration.save(userConfigurationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        // check itemsFolder
        iconsFolder = new File(plugin.getDataFolder(), "icons");
        if (!iconsFolder.exists()) {
            iconsFolder.mkdirs();
            new ResourcesManager(plugin).extractConfigsInFolder("icons", "yml");
            new ResourcesManager(plugin).extractConfigsInFolder("icons", "png");
        }

        return true; // todo : return false when an error is detected + prints a detailed error
    }


}
