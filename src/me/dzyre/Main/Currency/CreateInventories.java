package me.dzyre.Main.Currency;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreateInventories extends Eco {
  public static void createInventory() {
    ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
    ItemMeta meta = item.getItemMeta();

    // BACK ITEM

    ItemStack back = new ItemStack(Material.BARRIER);
    ItemMeta backMeta = back.getItemMeta();
    backMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "BACK");
    back.setItemMeta(backMeta);
    buyFoodItems.setItem(8, back);
    buyArmor.setItem(8, back);
    mainBuy.setItem(8, back);
    mainSell.setItem(8, back);
    sellOreItems.setItem(8, back);
    sellBlockItems.setItem(8, back);
    buyOreItems.setItem(8, back);
    buyBlockItems.setItem(8, back);
    //

    meta.setDisplayName(ChatColor.GOLD + "Armor/Weapons");
    List < String > lore = new ArrayList < String > ();
    lore.add("Buy Armor or Weapons");
    meta.setLore(lore);
    item.setItemMeta(meta);
    mainBuy.setItem(0, item);

    // Food
    item.setType(Material.COOKED_BEEF);
    meta.setDisplayName(ChatColor.GOLD + "Buy Farm Items");
    lore.clear();
    lore.add("Buy Farm Items");
    meta.setLore(lore);
    item.setItemMeta(meta);
    mainBuy.setItem(1, item);
    meta.setDisplayName(ChatColor.GOLD + "Sell Farm Items");
    lore.clear();
    lore.add("Sell Farm Items");
    meta.setLore(lore);
    item.setItemMeta(meta);
    mainSell.setItem(2, item);

    item.setType(Material.DIAMOND);
    meta.setDisplayName(ChatColor.GOLD + "Sell Ore Items");
    lore.clear();
    lore.add("Sell Ore Items");
    meta.setLore(lore);
    item.setItemMeta(meta);
    mainSell.setItem(0, item);

    item.setType(Material.DIAMOND);
    meta.setDisplayName(ChatColor.GOLD + "Buy Ore Items");
    lore.clear();
    lore.add("Buy Ore Items");
    meta.setLore(lore);
    item.setItemMeta(meta);
    mainBuy.setItem(2, item);

    item.setType(Material.COBBLESTONE);
    meta.setDisplayName(ChatColor.GOLD + "Sell Block");
    lore.clear();
    lore.add("Sell Blocks");
    meta.setLore(lore);
    item.setItemMeta(meta);
    mainSell.setItem(1, item);

    item.setType(Material.COBBLESTONE);
    meta.setDisplayName(ChatColor.GOLD + "Buy Blocks");
    lore.clear();
    lore.add("Buy Blocks");
    meta.setLore(lore);
    item.setItemMeta(meta);
    mainBuy.setItem(3, item);

    item.setType(Material.ROTTEN_FLESH);
    meta.setDisplayName(ChatColor.GOLD + "Sell Mob Drops");
    lore.clear();
    lore.add("Sell Mob Drops");
    meta.setLore(lore);
    item.setItemMeta(meta);
    mainSell.setItem(3, item);

    item.setType(Material.ROTTEN_FLESH);
    meta.setDisplayName(ChatColor.GOLD + "Buy Mob Drops");
    lore.clear();
    lore.add("Buy Mob Drops");
    meta.setLore(lore);
    item.setItemMeta(meta);
    mainBuy.setItem(4, item);

    item.setType(Material.SPAWNER);
    meta.setDisplayName(ChatColor.GOLD + "Buy Spawners");
    lore.clear();
    lore.add("Buy Spawners");
    meta.setLore(lore);
    item.setItemMeta(meta);
    mainBuy.setItem(5, item);

    // ARMOR
    ItemStack menuItem = new ItemStack(Material.DIAMOND);
    ItemMeta temp = menuItem.getItemMeta();
    temp.setDisplayName(ChatColor.GREEN + "Buy");
    menuItem.setItemMeta(temp);
    menu.setItem(0, menuItem);
    temp.setDisplayName(ChatColor.GREEN + "Sell");
    menuItem.setItemMeta(temp);
    menuItem.setType(Material.PAPER);
    menu.setItem(8, menuItem);

  }

  public static void setShops() {

    setShopItem(Material.DIAMOND_HELMET, buyArmor, 0);
    setShopItem(Material.DIAMOND_CHESTPLATE, buyArmor, 1);
    setShopItem(Material.DIAMOND_LEGGINGS, buyArmor, 2);
    setShopItem(Material.DIAMOND_BOOTS, buyArmor, 3);
    setShopItem(Material.DIAMOND_SWORD, buyArmor, 4);
    setShopItem(Material.DIAMOND_PICKAXE, buyArmor, 5);
    setShopItem(Material.DIAMOND_AXE, buyArmor, 6);
    setShopItem(Material.DIAMOND_SHOVEL, buyArmor, 7);

    setShopItem(Material.IRON_HELMET, buyArmor, 9);
    setShopItem(Material.IRON_CHESTPLATE, buyArmor, 10);
    setShopItem(Material.IRON_LEGGINGS, buyArmor, 11);
    setShopItem(Material.IRON_BOOTS, buyArmor, 12);
    setShopItem(Material.IRON_SWORD, buyArmor, 13);
    setShopItem(Material.IRON_PICKAXE, buyArmor, 14);
    setShopItem(Material.IRON_AXE, buyArmor, 15);
    setShopItem(Material.IRON_SHOVEL, buyArmor, 16);

    setShopItem(Material.CHAINMAIL_HELMET, buyArmor, 18);
    setShopItem(Material.CHAINMAIL_CHESTPLATE, buyArmor, 19);
    setShopItem(Material.CHAINMAIL_LEGGINGS, buyArmor, 20);
    setShopItem(Material.CHAINMAIL_BOOTS, buyArmor, 21);
    setShopItem(Material.STONE_SWORD, buyArmor, 22);
    setShopItem(Material.STONE_PICKAXE, buyArmor, 23);
    setShopItem(Material.STONE_AXE, buyArmor, 24);
    setShopItem(Material.STONE_SHOVEL, buyArmor, 25);

    setShopItem(Material.LEATHER_HELMET, buyArmor, 27);
    setShopItem(Material.LEATHER_CHESTPLATE, buyArmor, 28);
    setShopItem(Material.LEATHER_LEGGINGS, buyArmor, 29);
    setShopItem(Material.LEATHER_BOOTS, buyArmor, 30);
    setShopItem(Material.WOODEN_SWORD, buyArmor, 31);
    setShopItem(Material.WOODEN_PICKAXE, buyArmor, 32);
    setShopItem(Material.WOODEN_AXE, buyArmor, 33);
    setShopItem(Material.WOODEN_SHOVEL, buyArmor, 34);
  }

  public static void setShopSpawner() {
    buySpawners.setItem(8, new ItemStack(Material.BARRIER));
    for (String key: shopSpawnerValues.keySet()) {
      ItemStack spawner = new ItemStack(Material.SPAWNER);
      ItemMeta meta = spawner.getItemMeta();
      List < String > lore = new ArrayList < String > ();
      lore.add(ChatColor.LIGHT_PURPLE + "Cost: $" + shopSpawnerValues.get(key));
      meta.setDisplayName(key.toUpperCase() + " Spawner");
      meta.setLore(lore);
      spawner.setItemMeta(meta);
      buySpawners.addItem(spawner);
    }

  }
  public static void setShopItem(Material mat, Inventory shop, Integer location) {
    ItemStack item = new ItemStack(mat);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(ChatColor.GOLD + item.getType().name().replace("_", " "));
    List < String > lore = new ArrayList < String > ();
    if (shop == buyArmor || shop == buyFoodItems || shop == buyOreItems || shop == buyDrops || shop == buyBlockItems) {
      lore.add(ChatColor.LIGHT_PURPLE + "Cost: $" + shopBuyValues.get(item.getType().name().toLowerCase()));

    } else {
      lore.add(ChatColor.LIGHT_PURPLE + "Sells For: $" + shopSellValues.get(item.getType().name().toLowerCase()));
    }
    meta.setLore(lore);
    item.setItemMeta(meta);
    shop.setItem(location, item);
  }

  public static void trySetValue() {
    for (String key: shopSellValues.keySet()) {
      Inventory inv = getInventory(key, true);
      if (getInventory(key, true).firstEmpty() == 8) {
        getInventory(key, true).setItem(8, new ItemStack(Material.BARRIER));
      }
      setShopItem(Material.getMaterial(key.toUpperCase()), inv, inv.firstEmpty());
    }

    for (String key: shopBuyValues.keySet()) {
      Inventory inv = getInventory(key, false);
      if (getInventory(key, false).firstEmpty() == 8) {
        getInventory(key, false).setItem(8, new ItemStack(Material.BARRIER));
      }
      setShopItem(Material.getMaterial(key.toUpperCase()), inv, inv.firstEmpty());
    }
  }

  public static Inventory getInventory(String material, boolean Sell) {

    List < String > mob = List.of("bone", "rotten", "string", "eye", "ball", "arrow", "leather", "feather", "foot",
      "pearl", "powder", "blaze", "hide", "tear", "sac", "star", "cream");
    for (String item: mob) {
      if (material.contains(item)) {
        if (Sell) {
          return sellDrops;
        } else {
          return buyDrops;
        }
      }
    }

    List < String > farmList = List.of("beef", "mutton", "chicken", "pork", "rabbit", "potato", "carrot", "beetroot",
      "cocoa", "melon", "pumpkin", "sugar", "bread", "wheat", "cod", "salmon", "fish", "apple", "wart",
      "bamboo", "egg", "chorus", "kelp", "hay", "cactus", "paper");
    for (String item: farmList) {
      if (material.contains(item)) {
        if (Sell) {
          return sellFoodItems;
        } else {
          return buyFoodItems;
        }
      }
    }
    List < String > oresList = List.of("iron", "gold", "diamond", "emerald", "coal", "redstone", "copper", "lapis", "quartz");
    for (String ore: oresList) {
      if (material.contains(ore)) {
        if (Sell) {
          return sellOreItems;
        } else {
          return buyOreItems;
        }
      }
    }
    List < String > blocks = List.of("flint", "prismarine", "shard", "stone", "sand", "dirt", "ite", "rack", "block",
      "log", "sponge", "wool", "brick", "end", "lantern", "glass", "obsidian", "gravel", "clay", "mycelium");
    for (String item: blocks) {
      if (material.contains(item)) {
        if (Sell) {
          return sellBlockItems;
        } else {
          return buyBlockItems;
        }
      }
    }

    return mainSell;
  }

}