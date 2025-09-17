package fr.dreyfox.foxessentials.util;

import org.bukkit.ChatColor;

public final class Text {
    private Text() {}
    public static String cc(String s) {
        return ChatColor.translateAlternateColorCodes('&', s == null ? "" : s);
    }
}
