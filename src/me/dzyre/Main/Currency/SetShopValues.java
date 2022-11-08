package me.dzyre.Main.Currency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SetShopValues extends Eco{
	
	public static void setSellValue() throws IOException {	
		File file = new File("CurrencyData/ShopSellValues.yml");
	if(!file.exists()) {
		file.createNewFile();
	
	  try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write("potato:  3\ncarrot:  3\ngoldingot: 10\n"
					+ "ironingot:  7\n"
					+ "diamond:  35\n"
					+ "emerald:  50\n"
					+ "coal:  2\n"
					+ "arrow:  7\n"
					+ "cocoabeans: 3\n"
					+ "feather:  1\n"
					+ "bread: 30\n"
					+ "slimeball: 50\n"
					+ "grilledpork: 7\n"
					+ "seeds: 1\n"
					+ "ironblock: 63\n"
					+ "string: 5\n"
					+ "cactus: 2\n"
					+ "sulphur: 20\n"
					+ "stone: 2\n"
					+ "egg: 2\n"
					+ "obsidian: 30\n"
					+ "leather: 10\n"
					+ "cobblestone: 1\n"
					+ "goldore: 45\n"
					+ "pumpkin: 50\n"
					+ "bed: 68\n"
					+ "watch: 6\n"
					+ "sign: 1\n"
					+ "doublestep: 1\n"
					+ "cookedfish: 7\n"
					+ "saddle: 100\n"
					+ "cobblestonestairs: 1\n"
					+ "glowingredstoneore: 30\n"
					+ "apple: 10\n"
					+ "soil: 1\n"
					+ "clay: 12\n"
					+ "goldblock: 450\n"
					+ "paper: 10\n"
					+ "brick: 21\n"
					+ "chest: 4\n"
					+ "sandstone: 3\n"
					+ "sugarcane: 10\n"
					+ "sponge: 80\n"
					+ "bone: 2\n"
					+ "glass: 30\n"
					+ "wheat: 3\n"
					+ "redstone: 1\n"
					+ "inksack: 10\n"
					+ "glowstonedust: 10\n"
					+ "book: 45\n"
					+ "bow: 15\n"
					+ "sugar: 10\n"
					+ "junglelog: 10\n"
					+ "acacialog: 20\n"
					+ "sprucelog: 16\n"
					+ "oaklog: 16\n"
					+ "darkoaklog: 10\n"
					+ "bakedpotato: 3\n"
					+ "goldencarrot: 25\n"
					+ "cookedbeef: 6\n"
					+ "cookedporkchop: 6\n"
					+ "cookedmutton: 6\n"
					+ "cookedchicken: 6\n"
					+ "melonslice: 1\n"
					+ "pumpkin: 7\n"
					+ "mutton: 3\n"
					+ "chicken: 3\n"
					+ "beef: 3\n"
					+ "porkchop: 3\n");
	  }
	}
}
	
	
	public static void setBuyValue() throws IOException {	
		File file = new File("CurrencyData/ShopBuyValues.yml");
	if(!file.exists()) {
		file.createNewFile();
	
	  try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write( "arrow: 30\n"
					+ " cookedmutton: 8\n"
					+ "  cookedchicken: 8\n"
					+ "  goldencarrot: 30\n"
					+ "  rawfish: 5\n"
					+ "  feather: 3\n"
					+ "  bread: 30\n"
					+ "  stonehoe: 2\n"
					+ "  brownmushroom: 2\n"
					+ "  diamondhoe: 400\n"
					+ "  woodsword: 1\n"
					+ "  torch: 4\n"
					+ "  grass: 1\n"
					+ "  goldenapple: 100\n"
					+ "  leatherleggings: 75\n"
					+ "  diamondaxe: 650\n"
					+ "  slimeball: 50\n"
					+ "  stonespade: 1\n"
					+ "  claybrick: 5\n"
					+ "  noteblock: 36\n"
					+ "  ironaxe: 22\n"
					+ "  fishingrod: 10\n"
					+ "  ironhoe: 22\n"
					+ "  ironpickaxe: 22\n"
					+ "  cookedporkchop: 7\n"
					+ "  chainmailhelmet: 40\n"
					+ "  ironchestplate: 22\n"
					+ "  diamondhelmet: 1000\n"
					+ "  goldhelmet: 6\n"
					+ "  ironspade: 22\n"
					+ "  ironsword: 22\n"
					+ "  dispenser: 58\n"
					+ "  woodaxe: 2\n"
					+ "  seeds: 2\n"
					+ "  diamondspade: 210\n"
					+ "  goldhoe: 6\n"
					+ "  goldsword: 6\n"
					+ "  stoneaxe: 3\n"
					+ "  bookshelf: 140\n"
					+ "  diamondchestplate: 1750\n"
					+ "  redstone: 30\n"
					+ "  redmushroom: 2\n"
					+ "  string: 5\n"
					+ "  cactus: 10\n"
					+ "  leatherhelmet: 52\n"
					+ "  stone: 30\n"
					+ "  woodhoe: 2\n"
					+ "  goldleggings: 6\n"
					+ "  chainmailleggings: 50\n"
					+ "  ironhelmet: 22\n"
					+ "  leather: 10\n"
					+ "  leatherboots: 42\n"
					+ "  cobblestone: 1\n"
					+ "  pumpkin: 50\n"
					+ "  ironleggings: 22\n"
					+ "  woodpickaxe: 2\n"
					+ "  stonepickaxe: 4\n"
					+ "  chainmailboots: 30\n"
					+ "  diamondleggings: 1500\n"
					+ "  cookedfish: 7\n"
					+ "  apple: 10\n"
					+ "  woodspade: 1\n"
					+ "  goldingot: 105\n"
					+ "  chest: 4\n"
					+ "  sandstone: 3\n"
					+ "  goldpickaxe: 6\n"
					+ "  sugarcane: 10\n"
					+ "  diamondsword: 420\n"
					+ "  goldboots: 6\n"
					+ "  stonesword: 2\n"
					+ "  goldaxe: 6\n"
					+ "  glass: 30\n"
					+ "  goldspade: 6\n"
					+ "  wheat: 9\n"
					+ "  chainmailchestplate: 40\n"
					+ "  diamondboots: 850\n"
					+ "  redstone: 32\n"
					+ "  glowstonedust: 10\n"
					+ "  ironboots: 22\n"
					+ "  sugar: 10\n"
					+ "  cookedbeef: 22\n" 
					+ "  bakedpotato: 12\n"
					+ "  carrot: 6\n"
					);
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
			    	 if(value == null) {
			    		 go = false;
			    		 continue;
			    	 }
			    	String[] costValues = value.split(":");
			    	shopSellValues.put(costValues[0], Integer.parseInt(costValues[1].replaceAll("\\s", "").replaceAll("_", "")));
			     }
			     reader.close();
		}
			 finally {
				 
			 }
		}
			  shopCosts = new File("CurrencyData/ShopBuyValues.yml");
				if (shopCosts != null) {
					 try {			
					     BufferedReader reader = new BufferedReader(new FileReader(shopCosts));
					     boolean go = true;
					     String value;
					     while (go) {
					    	 value = reader.readLine();
					    	 if(value == null) {
					    		 go = false;
					    		 continue;
					    	 }
					    	String[] costValues = value.split(":");
					    	shopBuyValues.put(costValues[0].replaceAll("\\s",  ""), Integer.parseInt(costValues[1].replaceAll("\\s", "")));
					     }
					     reader.close();
				}
					 finally {
						 
					 }
			 
				}
		 
		
		return "null";
	}

}
