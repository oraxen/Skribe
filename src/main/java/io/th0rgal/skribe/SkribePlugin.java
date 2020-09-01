package io.th0rgal.skribe;

import io.th0rgal.skribe.settings.ConfigsManager;
import io.th0rgal.skribe.utils.OS;
import io.th0rgal.skribe.utils.logs.Logs;
import org.bstats.bukkit.Metrics;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SkribePlugin extends JavaPlugin {

    private static SkribePlugin skribe;

    public SkribePlugin() throws Exception {
        skribe = this;
        new Metrics(this, 8677);
        Logs.enableFilter();
    }

    public void onEnable() {
        (new ConfigsManager(this)).validatesConfig();
        //Bukkit.getPluginManager().registerEvents(new LanguageListener(), this);
        Logs.log(ChatColor.GREEN + "Successfully loaded on " + OS.getOs().getPlatformName());
    }

    public void onDisable() {
        Logs.log(ChatColor.GREEN + "Successfully unloaded");
    }

    public static SkribePlugin get() {
        return skribe;
    }

}
