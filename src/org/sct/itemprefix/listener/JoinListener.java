package org.sct.itemprefix.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;

import org.sct.itemprefix.dto.CacheMap;
import org.sct.itemprefix.dto.PrefixData;
import org.sct.itemprefix.file.Config;
import org.sct.itemprefix.util.BasicUtil;

/**
 * @author SCT_Alchemy
 * @date 2019/2/2 11:15 PM
 */

public class JoinListener implements Listener {

    @EventHandler
    void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        PlayerInventory inventory = player.getInventory();

        if (Config.getData(inventory.getItem(Config.getSlot())) != null) {
            PrefixData data = Config.getData(inventory.getItem(Config.getSlot()));
            /**
             * 玩家刚刚加入游戏，将之前的称号载入缓存
             */
            CacheMap.put(player, BasicUtil.convert(data.getPrefix()));
            player.sendMessage(CacheMap.get(player));
        } else {
            return;
        }

    }
}
