package io.th0rgal.skribe.settings;

import io.th0rgal.skribe.SkribePlugin;
import org.bukkit.ChatColor;

import java.util.List;

public enum Plugin implements ConfigEnum {

    NAME("Plugin.name"),
    PREFIX("Plugin.prefix");

    private final Object value;

    Plugin(String section) {
        this.value = new ResourcesManager(SkribePlugin.get()).getSettings().get(section);
    }

    public Object getValue() {
        return this.value;
    }

    @SuppressWarnings("unchecked")
    public List<String> getAsStringList() {
        return (List<String>) value;
    }

    @Override
    public String toString() {
        return ChatColor.translateAlternateColorCodes('&', this.value.toString());
    }

}