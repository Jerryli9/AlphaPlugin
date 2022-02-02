package com.alpha.newplugin.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack KNOCKBACK_BALL;
    public static  ItemStack EXPLOSIVE_SHOVEL;
    public static ItemStack HEALING_WAND;

    public static void init() {
        createKnockbackball();
        createExplosionShovel();
        createHealingWand();

    }

    private static void createKnockbackball() {
        ItemStack item = new ItemStack(Material.SLIME_BALL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Knockback X Slimeball");
        List<String> lore = new ArrayList<>();
        lore.add("§7BOOOOOING");
        lore.add("§7made in china");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.KNOCKBACK, 10, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 8, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        KNOCKBACK_BALL = item;

    }
    private static void createExplosionShovel() {
        ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cAspect §cOf §cThe §cJerry");
        List<String> lore = new ArrayList<>();
        lore.add("§7What Could This Possibly do?");
        lore.add("§7made in china");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE, 4, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        EXPLOSIVE_SHOVEL = item;

    }

    private static void createHealingWand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cHealing §cWand");
        List<String> lore = new ArrayList<>();
        lore.add("§7What Could This Possibly do?");
        lore.add("§7made in china");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        item.setItemMeta(meta);
        HEALING_WAND= item;

    }
}

