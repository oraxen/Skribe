package io.th0rgal.skribe.utils.logs;

import io.th0rgal.skribe.settings.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

import java.util.function.BiConsumer;

public final class ConsoleAdapter implements BiConsumer<Boolean, String> {

    public static final ConsoleAdapter INSTANCE = new ConsoleAdapter();

    private final ConsoleCommandSender sender = Bukkit.getConsoleSender();

    private ConsoleAdapter() {
    }

    /*
     *
     */

    @Override
    public void accept(Boolean flag, String message) {
        send(message);
    }

    public ConsoleAdapter send(String message) {
        sender.sendMessage(Plugin.PREFIX + ChatColor.translateAlternateColorCodes('&', message));
        return this;
    }

}
