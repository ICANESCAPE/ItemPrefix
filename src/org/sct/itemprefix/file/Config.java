package org.sct.itemprefix.file;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.inventivetalent.itembuilder.util.FileUtil;
import org.sct.itemprefix.ItemPrefix;
import org.sct.itemprefix.dto.PrefixData;
import org.sct.itemprefix.util.BasicUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SCT_Alchemy
 * @date 2019/2/2 10:58 PM
 */

public class Config extends FileUtil {

    private static Config config;
    private static List<PrefixData> datas = new ArrayList<>();
    private static Map<String, String> map = new HashMap<>();
    private static String path = "Prefix";

    public Config() {
        super(ItemPrefix.getInstance(), "config.yml");
    }

    public static void reload() {
        config = new Config();
    }

    @Override
    public void check() {
        ConfigurationSection cs = this.getConfigurationSection("Prefix");
        for (String key : cs.getKeys(false)) {
            datas.add(new PrefixData(
                    cs.getString(key + ".prefix"),
                    cs.getString(key + ".item"))
            );
            Bukkit.getConsoleSender().sendMessage("正在几轮");
        }
    }

    public static int getSlot() { return config.getInt("slot"); }

    public static PrefixData getData(ItemStack item) {
        for (PrefixData data : datas) {
            if (item.isSimilar(BasicUtil.toItem(data.getItem()))) {
                return data;
            }
        }
        return null;
    }

    public static List<PrefixData> getDatas() {
        return datas;
    }
}
