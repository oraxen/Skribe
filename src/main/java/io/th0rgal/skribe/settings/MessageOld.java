package io.th0rgal.skribe.settings;

import io.th0rgal.skribe.utils.logs.Logs;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public enum MessageOld {

    UPDATING_CONFIG(ChatColor.RED, "Configuration option \"%s\" not found, adding it!"),
    CONFIGS_VALIDATION_FAILED(ChatColor.RED, "Configurations validation failed, plugin automatically disabled!"),
    NOT_A_PLAYER_ERROR(ChatColor.RED, "You must be a player to use this command!"),
    COMMAND_DOES_NOT_EXIST_ERROR(ChatColor.RED, "This command doesn't exist, check the doc!"),
    ZIP_BROWSE_ERROR(ChatColor.RED, "An error occured browsing the zip"),
    DONT_HAVE_PERMISSION(ChatColor.RED, "You need the permission %s to do this"),

    UNCONSISTENT_CONFIG_VERSION(ChatColor.RED, "Config updating error: does this config come from the future?"),
    CONFIGS_NOT_UPDATED(ChatColor.GREEN, "Configs version number is consistent: skipping updating"),
    CONFIGS_UPDATING_FAILED(ChatColor.RED, "Configs updating failed, please post an issue on github"),

    RELOAD(ChatColor.GREEN, "%s successfully reloaded");

    private final String message;

    MessageOld(ChatColor color, String message) {
        this.message = color + message;
    }

    MessageOld(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return Plugin.PREFIX + message;
    }

    public void send(CommandSender sender) {
        sender.sendMessage(toString());
    }

    public void send(CommandSender sender, String... arguments) {
        // the cast is here to indicates to compiler a non-varargs call
        sender.sendMessage(String.format(toString(), (Object[]) arguments));
    }

    public void log(String... arguments) {
        Logs.log(String.format(message, (Object[]) arguments));
    }

    public void log() {
        Logs.log(message);
    }

    public void logWarning(String... arguments) {
        Logs.logWarning(String.format(toString(), (Object[]) arguments));
    }

    public void logWarning() {
        Logs.logWarning(toString());
    }

    public void logError(String... arguments) {
        Logs.logError(String.format(toString(), (Object[]) arguments));
    }

    public void logError() {
        Logs.logError(toString());
    }

}
