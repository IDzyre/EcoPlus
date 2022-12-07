package me.dzyre.Main.Currency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SetShopValues extends Eco {

	public static void setSellValue() throws IOException {
		File file = new File("CurrencyData/ShopSellValues.yml");
		if (!file.exists()) {
			file.createNewFile();

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				writer.write("iron_ingot: 10\n" + "iron_block: 90\n" + "gold_ingot: 15\n" + "gold_block: 135\n"
						+ "golden_apple: 30\n" + "enchanted_golden_apple: 500\n" + "gold_nugget: 1\n"
						+ "golden_carrot: 20\n" + "redstone: 1\n" + "diamond_block: 1800\n" + "diamond: 200\n"
						+ "emerald_block: 1350\n" + "emerald: 150\n" + "coal_block: 45\n" + "coal: 5\n"
						+ "lapis_lazuli: 1\n" + "lapis_block: 9\n" + "arrow: 3\n" + "oak_log: 2\n" + "spruce_log: 2\n"
						+ "birch_log: 2\n" + "jungle_log: 1\n" + "acacia_log: 2\n" + "dark_oak_log: 2\n" + "dirt: 1\n"
						+ "gravel: 1\n" + "bricks: 3\n" + "clay_ball: 1\n" + "flint: 1\n" + "clay: 4\n"
						+ "sandstone: 3\n" + "sand: 1\n" + "red_sand: 1\n" + "glass: 1\n" + "sponge: 30\n"
						+ "prismarine: 15\n" + "dark_prismarine: 15\n" + "sea_lantern: 60\n" + "prismarine_shard: 3\n"
						+ "prismarine_crystals: 3\n" + "stone: 2\n" + "cobblestone: 1\n" + "mossy_cobblestone: 7\n"
						+ "granite: 1 \n" + "diorite: 1\n" + "andesite: 1\n" + "obsidian: 30\n" + "pumpkin: 6\n"
						+ "apple: 6\n" + "carrot: 3\n" + "mutton: 3\n" + "cooked_mutton: 5\n" + "beetroot: 1\n"
						+ "hay_block: 27\n" + "chorus_flower: 27\n" + "cactus: 2\n" + "melon: 9\n"
						+ "glistering_melon_slice:  10\n" + "potato: 3\n" + "baked_potato: 5\n" + "rabbit: 4\n"
						+ "rabbit_foot: 22\n" + "cooked_rabbit:  6\n" + "melon_slice: 1\n" + "beef: 3\n"
						+ "cooked_beef: 5\n" + "chicken:  3\n" + "cooked_chicken:  5\n" + "cocoa_beans: 2\n"
						+ "cod: 3\n" + "salmon: 3\n" + "tropical_fish: 4\n" + "pufferfish: 6\n" + "cooked_cod: 5\n"
						+ "cooked_salmon: 5\n" + "sugar_cane: 1\n" + "paper: 2\n" + "egg: 1\n" + "wheat: 3\n"
						+ "bread: 10\n" + "kelp: 1\n" + "bamboo: 1\n" + "gunpowder: 11\n" + "feather: 1\n"
						+ "string: 3\n" + "bone_block: 10\n" + "bone: 3\n" + "slime_ball: 15\n" + "slime_block: 135\n"
						+ "spider_eye: 3\n" + "fermented_spider_eye: 6\n" + "leather: 3\n" + "rotten_flesh: 3\n"
						+ "white_wool: 2\n" + "ink_sac: 3\n" + "quartz: 2\n" + "quartz_block: 18\n"
						+ "glowstone_dust: 2\n" + "glowstone: 8\n" + "magma_block: 3\n" + "nether_wart: 5\n"
						+ "nether_wart_block: 45\n" + "nether_bricks: 4\n" + "blaze_powder: 15\n" + "magma_cream: 24\n"
						+ "nether_star: 10000\n" + "blaze_rod: 30\n" + "ghast_tear: 100\n" + "end_stone: 15\n"
						+ "chorus_fruit:  10\n" + "end_rod: 50\n" + "ender_pearl: 11\n" + "mycelium: 40\n");
			}
		}
	}

	public static void setBuyValue() throws IOException {
		File file = new File("CurrencyData/ShopBuyValues.yml");
		if (!file.exists()) {
			file.createNewFile();

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				writer.write("stone_hoe: 2\n" + "diamond_hoe: 400\n" + "wooden_sword: 1\n" + "leather_leggings: 75\n"
						+ "diamond_axe: 650\n" + "stone_shovel: 1\n" + "iron_axe: 22\n" + "fishing_rod: 10\n"
						+ "iron_hoe: 22\n" + "iron_pickaxe: 22\n" + "chainmail_helmet: 40\n" + "iron_chestplate: 22\n"
						+ "diamond_helmet: 1000\n" + "golden_helmet: 6\n" + "iron_shovel: 22\n" + "iron_sword: 22\n"
						+ "wooden_axe: 2\n" + "diamond_shovel: 210\n" + "golden_hoe: 6\n" + "gold_sword: 6\n"
						+ "stone_axe: 3\n" + "diamond_chestplate: 1750\n" + "leather_helmet: 52\n" + "wooden_hoe: 2\n"
						+ "golden_leggings: 6\n" + "chainmail_leggings: 50\n" + "iron_helmet: 22\n"
						+ "leather_boots: 42\n" + "iron_leggings: 22\n" + "wooden_pickaxe: 2\n" + "stone_pickaxe: 4\n"
						+ "chainmail_boots: 30\n" + "diamond_leggings: 1500\n" + "wooden_shovel: 1\n"
						+ "golden_pickaxe: 6\n" + "diamond_sword: 420\n" + "golden_boots: 6\n" + "stone_sword: 2\n"
						+ "golden_axe: 6\n" + "golden_shovel: 6\n" + "chainmail_chestplate: 40\n"
						+ "diamond_boots: 850\n" + "iron_boots: 22\n" + "diamond_pickaxe: 650\n"
						+ "leather_chestplate: 40\n");
			}
		}
	}

	public static void setSpawnerValue() throws IOException {
		File file = new File("CurrencyData/ShopSpawnerValues.yml");
		if (!file.exists()) {
			file.createNewFile();

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				writer.write("cat: 1000\n" + "chicken: 3000\n" + "cow: 5000\n" + "fox: 1000\n" + "horse: 3000\n"
						+ "mushroom_cow: 7500\n" + "parrot: 1000\n" + "pig: 3000\n" + "rabbit: 4000\n" + "sheep: 5000\n"
						+ "snow_golem: 7500\n" + "squid: 2000\n" + "villager: 7000\n" + "spider: 5000\n"
						+ "cave_spider: 5000\n" + "enderman: 15000\n" + "goat: 3000\n" + "iron_golem: 30000\n"
						+ "llama: 3000\n" + "zombified_piglin: 7000\n" + "polar_bear: 2000\n" + "wolf: 1000\n"
						+ "blaze: 7500\n" + "zombie: 5000\n" + "creeper: 7000\n" + "skeleton: 6000\n" + "witch: 4000\n"
						+ "slime: 7000\n" + "magma_cube: 5000\n" + "hoglin: 4000\n");
			}
		}
	}

	public static String getCost() throws FileNotFoundException, IOException, ClassNotFoundException {
		File shopCosts = new File("CurrencyData/ShopSellValues.yml");
		if (shopCosts != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(shopCosts));
				boolean go = true;
				String value;
				while (go) {
					value = reader.readLine();
					if (value == null) {
						go = false;
						continue;
					}
					String[] costValues = value.split(":");
					shopSellValues.put(costValues[0], Integer.parseInt(costValues[1].replaceAll("\\s", "")));
				}
				reader.close();
			} finally {

			}
		}
		if (shopCosts != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(shopCosts));
				boolean go = true;
				String value;
				while (go) {
					value = reader.readLine();
					if (value == null) {
						go = false;
						continue;
					}
					String[] costValues = value.split(":");
					shopBuyValues.put(costValues[0], Integer.parseInt(costValues[1].replaceAll("\\s", ""))
							+ (int) (Math.ceil(Integer.parseInt(costValues[1].replaceAll("\\s", "")) * 0.3)));
				}
				reader.close();
			} finally {

			}
		}
		return "null";
	}

	public static String getBuyCost() throws FileNotFoundException, IOException, ClassNotFoundException {
		File shopCosts = new File("CurrencyData/ShopBuyValues.yml");
		if (shopCosts != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(shopCosts));
				boolean go = true;
				String value;
				while (go) {
					value = reader.readLine();
					if (value == null) {
						go = false;
						continue;
					}
					String[] costValues = value.split(":");
					shopBuyValues.put(costValues[0], Integer.parseInt(costValues[1].replaceAll("\\s", "")));
				}
				reader.close();
			} finally {

			}
		}

		return "null";
	}
	
	public static String getSpawnerCosts() throws FileNotFoundException, IOException, ClassNotFoundException {
		File shopCosts = new File("CurrencyData/ShopSpawnerValues.yml");
		if (shopCosts != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(shopCosts));
				boolean go = true;
				String value;
				while (go) {
					value = reader.readLine();
					if (value == null) {
						go = false;
						continue;
					}
					String[] costValues = value.split(":");
					// System.out.println(value);
					shopSpawnerValues.put(costValues[0], Integer.parseInt(costValues[1].replaceAll("\\s", "")));
				}
				reader.close();
			} finally {

			}
		}

		return "null";
	}

}
