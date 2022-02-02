package com.alpha.newplugin.commands;

import com.alpha.newplugin.items.ItemManager;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class newplugincommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) { return true; }
            Player player = (Player) sender;
        // /heal
        if (cmd.getName().equalsIgnoreCase("heal")) {
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            return true;
        }
        // /feed
        else if (cmd.getName().equalsIgnoreCase("feed")) {
            player.setFoodLevel(20);
        }

        else if (cmd.getName().equalsIgnoreCase("givekbXSlimeball")) {
            player.getInventory().addItem(ItemManager.KNOCKBACK_BALL);
        }

        else if (cmd.getName().equalsIgnoreCase("ExplosiveShovel")) {
            player.getInventory().addItem(ItemManager.EXPLOSIVE_SHOVEL);
        }

        else if (cmd.getName().equalsIgnoreCase("healingwand")) {
            player.getInventory().addItem(ItemManager.HEALING_WAND);
        }

        else if (cmd.getName().equalsIgnoreCase("farmtime")) {
            if (args.length >= 2) {
                try {
                    EntityType entity = EntityType.valueOf(args[0]);
                    int amount = Integer.parseInt(args[1]);
                    for (int i = 0; i < amount; i++) {
                        player.getWorld().spawnEntity(player.getLocation(), entity);
                    }
                } catch (IllegalArgumentException e) {
                    player.sendMessage("§s§l(!) §cThat is not a valid entry!");
                }
            } else {
                player.sendMessage("§c§l(!) §c/farmtime <mob> <amount>");
            }

        }

        return true;
    }
}
