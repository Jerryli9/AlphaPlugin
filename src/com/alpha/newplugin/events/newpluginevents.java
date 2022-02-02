package com.alpha.newplugin.events;

import com.alpha.newplugin.items.ItemManager;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class newpluginevents implements Listener {

    @EventHandler
    //explosionswordexplosionevent
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) && e.getItem() != null && e.getItem().getItemMeta().equals(ItemManager.EXPLOSIVE_SHOVEL.getItemMeta())) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 7));
            Location l = getBlockBehindPlayer(e.getPlayer());
            Location location = player.getLocation();
            player.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, location.getX(), location.getY(), location.getZ(), 3);
            player.damage(3.53f);
            player.setVelocity(location.getDirection().normalize().multiply(1.5));
            player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, location.getX(), location.getY(), location.getZ(), 60);
            player.getWorld().spawnParticle(Particle.CRIT_MAGIC, location.getX(), location.getY(), location.getZ(), 60);
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 1));

            }
        }




    private static Location getBlockBehindPlayer(Player player) {
        Vector inverseDirectionVec = player.getLocation().getDirection().normalize().multiply(-0.5);
        return player.getLocation().add(inverseDirectionVec);
    }

    @EventHandler
    public static void onHealingWandRightClick(PlayerInteractEvent event) {
        if ((event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) && event.getItem() != null && event.getItem().getItemMeta().equals(ItemManager.HEALING_WAND.getItemMeta())) {
            Player player = event.getPlayer();
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            player.setFoodLevel(20);
            player.sendMessage("Heal!");
        }
    }
    @EventHandler
    public static void onSlimeballHitEntity(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals((ItemManager.KNOCKBACK_BALL.getItemMeta()))) {
                    player.giveExpLevels(10);
                    player.sendMessage("You have been gifted by the kb gods!");


                }
            }
        }
    }

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome :D");
    }

    @EventHandler
    public static void onPlayerWalk(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();

        Material block = player.getWorld().getBlockAt(x, y - 1, z).getType();
        if (block == Material.STONE)
            player.giveExp(5);
    }
}