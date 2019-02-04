package org.sct.itemprefix.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.sct.itemprefix.dto.CacheMap;

/**
 * @author SCT_Alchemy
 * @date 2019/2/2 11:27 PM
 */

public class QuitListener implements Listener {

    @EventHandler
    void onLeave(PlayerQuitEvent e) {

        /**
         * 玩家离开游戏了，将他的信息清空
         */
        CacheMap.remove(e.getPlayer());
    }
}
