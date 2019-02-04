package org.sct.itemprefix.dto;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存，用于储存玩家称号
 *
 * @author SCT_Alchemy
 * @date 2019/2/2 11:24 PM
 */

public class CacheMap {

    /**
     * 玩家/称号
     */
    private static final Map<Player, String> cache = new HashMap<>();

    public static void put(Player key, String value) {
        cache.put(key, value);
    }

    public static void remove(Player key) { cache.remove(key); }

    public static String get(Player key) { return cache.get(key); }
}
