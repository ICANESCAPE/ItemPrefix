package org.sct.itemprefix.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import org.sct.itemprefix.dto.CacheMap;
import org.sct.itemprefix.dto.PrefixData;
import org.sct.itemprefix.file.Config;

/**
 * @author SCT_Alchemy
 * @date 2019/2/2 11:09 PM
 */

public class InvCloseListener implements Listener {

    @EventHandler
    void onClose(InventoryCloseEvent e) {
        if (e.getPlayer() instanceof Player) {
            Player player = (Player) e.getPlayer();
            ItemStack item = player.getInventory().getItem(Config.getSlot());
            if (Config.getData(item) != null) {
                PrefixData data = Config.getData(item);
                /**
                 * 如果背包该格子放置的是称号道具，将玩家的data对象和玩家存入缓存中
                 */
                CacheMap.put(player, ChatColor.translateAlternateColorCodes('&', data.getPrefix()));
                player.sendMessage(CacheMap.get(player));
            }
        }
    }
}
