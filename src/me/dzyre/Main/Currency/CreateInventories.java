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
		foodItems.setItem(8, back);
		buy.setItem(8, back);
		sell.setItem(8, back);
		//

		meta.setDisplayName(ChatColor.GOLD + "Armor/Weapons");
		List<String> lore = new ArrayList<String>();
		lore.add("Buy Armor or Weapons");
		meta.setLore(lore);
		item.setItemMeta(meta);
		mainShop.setItem(0, item);

		// Food
		item.setType(Material.COOKED_BEEF);
		meta.setDisplayName(ChatColor.GOLD + "Food");
		lore.clear();
		lore.add("Buy Food Items");
		meta.setLore(lore);
		item.setItemMeta(meta);
		mainShop.setItem(1, item);

		// Food
		item.setType(Material.DIAMOND);
		meta.setDisplayName(ChatColor.GOLD + "Sell Items");
		lore.clear();
		meta.setLore(lore);
		item.setItemMeta(meta);
		mainSell.setItem(4, item);

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
		setShopItem(Material.DIAMOND_HELMET, buy, 0, true);
		setShopItem(Material.DIAMOND_CHESTPLATE, buy, 9, true);
		setShopItem(Material.DIAMOND_LEGGINGS, buy, 18, true);
		setShopItem(Material.DIAMOND_BOOTS, buy, 27, true);
		setShopItem(Material.DIAMOND_SWORD, buy, 36, true);
		setShopItem(Material.IRON_HELMET, buy, 1, true);
		setShopItem(Material.IRON_CHESTPLATE, buy, 10, true);
		setShopItem(Material.IRON_LEGGINGS, buy, 19, true);
		setShopItem(Material.IRON_BOOTS, buy, 28, true);
		setShopItem(Material.IRON_SWORD, buy, 37, true);
		setShopItem(Material.CHAINMAIL_HELMET, buy, 2, true);
		setShopItem(Material.CHAINMAIL_CHESTPLATE, buy, 11, true);
		setShopItem(Material.CHAINMAIL_LEGGINGS, buy, 20, true);
		setShopItem(Material.CHAINMAIL_BOOTS, buy, 29, true);
		setShopItem(Material.STONE_SWORD, buy, 38, true);
		setShopItem(Material.APPLE, foodItems, 0, true);
		setShopItem(Material.BAKED_POTATO, foodItems, 1, true);
		setShopItem(Material.COOKED_BEEF, foodItems, 2, true);
		setShopItem(Material.COOKED_PORKCHOP, foodItems, 3, true);
		setShopItem(Material.COOKED_CHICKEN, foodItems, 4, true);
		setShopItem(Material.COOKED_MUTTON, foodItems, 5, true);
		setShopItem(Material.GOLDEN_CARROT, foodItems, 6, true);
		setShopItem(Material.APPLE, foodItems, 0, true);
		setShopItem(Material.APPLE, sell, 0, false);
		setShopItem(Material.BAKED_POTATO, sell, 1, false);
		setShopItem(Material.COOKED_BEEF, sell, 2, false);
		setShopItem(Material.COOKED_PORKCHOP, sell, 3, false);
		setShopItem(Material.COOKED_CHICKEN, sell, 4, false);
		setShopItem(Material.COOKED_MUTTON, sell, 5, false);
		setShopItem(Material.GOLDEN_CARROT, sell, 6, false);
		setShopItem(Material.COBBLESTONE, sell, 9, false);
		setShopItem(Material.OAK_LOG, sell, 10, false); 
		setShopItem(Material.SPRUCE_LOG, sell, 11, false);
		setShopItem(Material.DARK_OAK_LOG, sell, 12, false);
		setShopItem(Material.ACACIA_LOG, sell, 13, false);
		setShopItem(Material.JUNGLE_LOG, sell, 14, false);
		
	}
	
	public static void setShopItem(Material mat, Inventory shop, Integer location, Boolean isBuy) {
		ItemStack item = new ItemStack(mat);
		ItemMeta meta = item.getItemMeta();
		if((!(shop == sell) && (item.getType().name().contains("LOG") || item.getType().isEdible()))) {
			item.setAmount(16);
		}
		meta.setDisplayName(ChatColor.GOLD + item.getType().name().replace("_", " "));
	//	System.out.println(item.getType().name());
		List<String> lore =  new ArrayList<String>();
		lore.add(ChatColor.LIGHT_PURPLE + "Cost: ");
		if(isBuy) {
		lore.add("$ " + shopBuyValues.get(item.getType().name().replace("_", "").toLowerCase()));
		
		} else {
		lore.add("$ " + shopSellValues.get(item.getType().name().replace("_", "").toLowerCase()));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		shop.setItem(location, item);
	}
	
	
	
	
}
