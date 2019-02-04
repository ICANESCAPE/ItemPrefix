package org.sct.itemprefix.papi;

import me.clip.placeholderapi.external.EZPlaceholderHook;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.sct.itemprefix.dto.CacheMap;

/**
 * @author SCT_Alchemy
 * @date 2019/2/2 11:10 PM
 */

public class PapiHook extends EZPlaceholderHook {

    private static final String VAR = "prefix";

    public PapiHook(Plugin plugin, String identifier) {
        super(plugin, identifier);
        this.hook();
    }

    @Override
    public String onPlaceholderRequest(Player player, String s) {
        if (VAR.equalsIgnoreCase(s)) {
            /**
             * %itemprefix_prefix% 变量
             */
            return CacheMap.get(player);
        }
        return "无";
    }
}
