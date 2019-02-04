package org.sct.itemprefix.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import org.sct.core.file.FileTool;

import org.sct.itemprefix.ItemPrefix;
import org.sct.itemprefix.listener.InvCloseListener;
import org.sct.itemprefix.listener.JoinListener;
import org.sct.itemprefix.listener.QuitListener;

/**
 * @author SCT_Alchemy
 * @date 2019/2/2 10:50 PM
 */

public class BasicUtil {

    public static String convert (String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static ItemStack toItem(String key) {
        return FileTool.getItem(key);
    }

    public static void regist() {
        register(new InvCloseListener());
        register(new JoinListener());
        register(new QuitListener());
    }

    private static void register(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, ItemPrefix.getInstance());
    }
}
