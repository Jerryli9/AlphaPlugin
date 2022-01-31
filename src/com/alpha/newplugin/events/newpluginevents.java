package com.alpha.newplugin.events;

import com.alpha.newplugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class newpluginevents implements Listener {

    @EventHandler
    public static void onSlimeballRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals((ItemManager.knockbackball.getItemMeta()))) {
                    player.getWorld().createExplosion(player.getLocation(), 1.0f);
                    player.sendMessage("BOOOOOOOOOM!");
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) && e.getItem() != null && e.getItem().getItemMeta().equals(ItemManager.explosionaxe)){
            Location l = getBlockBehindPlayer(e.getPlayer());
            e.getPlayer().getWorld().createExplosion(l, 4f);
        }
    }

    private static Location getBlockBehindPlayer(Player player) {
        Vector inverseDirectionVec = player.getLocation().getDirection().normalize().multiply(-4);
        return player.getLocation().add(inverseDirectionVec);
    }

    @EventHandler
    public static void onSlimeballHitEntity(PlayerInteractEvent event) {
        if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals((ItemManager.knockbackball.getItemMeta()))) {
                    player.giveExpLevels(10);
                    player.sendMessage("You have been gifted by the kb gods!");


                }
            }
        }
    }

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome :D" );
    }

    @EventHandler
    public static void onPlayerWalk(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();

        Material block = player.getWorld().getBlockAt(x, y-1, z).getType();
        if (block == Material.STONE)
            player.giveExp(5);
    }

}
