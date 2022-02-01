package com.alpha.newplugin.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack knockbackball;
    public static  ItemStack explosionaxe;

    public static void init() {
        createKnockbackball();
        createExplosionAxe();

    }

    private static void createKnockbackball() {
        ItemStack item = new ItemStack(Material.SLIME_BALL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Knockback × Slimeball");
        List<String> lore = new ArrayList<>();
        lore.add("§7BOOOOOING");
        lore.add("§7Made In China");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.KNOCKBACK, 10, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 8, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        knockbackball = item;

    }
    private static void createExplosionAxe() {
        ItemStack item = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cExplosive §cAxe");
        List<String> lore = new ArrayList<>();
        lore.add("§7What could this possibly do?");
        lore.add("§7Made in China");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        explosionaxe = item;

    }
}

