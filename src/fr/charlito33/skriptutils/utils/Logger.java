package fr.charlito33.skriptutils.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logger {
    public static void info(String... message) {
        StringBuilder finalMessage = new StringBuilder();

        for (String messagePart : message) {
            finalMessage.append(messagePart);
        }

        Bukkit.getServer().getConsoleSender().sendMessage("[" + ChatColor.GOLD + "SkriptUtils" + ChatColor.RESET + "] " + finalMessage.toString());

    }
}
