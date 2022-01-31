package com.alpha.newplugin;

import com.alpha.newplugin.commands.newplugincommands;
import com.alpha.newplugin.events.newpluginevents;
import com.alpha.newplugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;

public class newplugin extends  JavaPlugin {

    @Override
    public void onEnable() {
        ItemManager.init();
        newplugincommands commands = new newplugincommands();
        getServer().getPluginManager().registerEvents(new newpluginevents(),this);
        getCommand("heal").setExecutor(new newplugincommands());
        getCommand("feed").setExecutor(new newplugincommands());
        getCommand("farmtime").setExecutor(new newplugincommands());
        getCommand("givekbXSlimeball").setExecutor(new newplugincommands());
        getCommand("explosionaxe").setExecutor(new newplugincommands());
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Plugin]: Plugin is now enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Plugin]: Plugin is now disabled!");
    }

}
