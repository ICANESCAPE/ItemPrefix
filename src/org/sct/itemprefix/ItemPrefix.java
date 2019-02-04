package org.sct.itemprefix;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import org.sct.itemprefix.file.Config;
import org.sct.itemprefix.papi.PapiHook;
import org.sct.itemprefix.util.BasicUtil;

/**
 * @author SCT_Alchemy
 * @date 2019/2/2 10:49 PM
 */

public class ItemPrefix extends JavaPlugin {

    private static ItemPrefix instance;

    @Override
    public void onEnable() {
        instance = this;
        Config.reload();
        PapiHook ph = new PapiHook(instance, "prefix");
        ph.hook();
        BasicUtil.regist();
        Bukkit.getConsoleSender().sendMessage(BasicUtil.convert("&f[&d称号&f] &e> &a成功加载"));
        Bukkit.getConsoleSender().sendMessage(BasicUtil.convert("&fplugin from Server CT"));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(BasicUtil.convert("&f[&d称号&f] &e> &a成功鞋卸载"));
        Bukkit.getConsoleSender().sendMessage(BasicUtil.convert("&fplugin from Server CT"));
    }

    public static ItemPrefix getInstance() { return instance; }
}
