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
			writer.write("Potato:  15\nCarrot:  10\nGold: 15\n"
					+ "Iron:  10\n"
					+ "Diamond:  45\n"
					+ "Emerald:  50\n"
					+ "Coal:  3\n"
					+ "stonebutton:  6\n"
					+ "arrow:  30\n"
					+ "rawfish:  5\n"
					+ "minecart:  23\n"
					+ "feather:  3\n"
					+ "mushroomsoup: 4\n"
					+ "bread: 30\n"
					+ "brownmushroom: 2\n"
					+ "snowball: 1\n"
					+ "goldenapple: 100\n"
					+ "slimeball: 50\n"
					+ "coalore: 15\n"
					+ "clayball: 3\n"
					+ "redrose: 2\n"
					+ "grilledpork: 7\n"
					+ "gravel: 1\n"
					+ "seeds: 2\n"
					+ "woodplate: 1\n"
					+ "redstoneore: 30\n"
					+ "sand: 1\n"
					+ "ironblock: 190\n"
					+ "boat: 3\n"
					+ "redstonewire: 30\n"
					+ "redmushroom: 2\n"
					+ "string: 5\n"
					+ "cactus: 10\n"
					+ "sulphur: 20\n"
					+ "rails: 22\n"
					+ "ironore: 18\n"
					+ "stone: 30\n"
					+ "egg: 1\n"
					+ "diamondore: 200\n"
					+ "woodhoe: 2\n"
					+ "yellowflower: 2\n"
					+ "obsidian: 130\n"
					+ "dirt: 1\n"
					+ "leather: 10\n"
					+ "cobblestone: 1\n"
					+ "woodstairs: 1\n"
					+ "ironingot: 22\n"
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
					+ "goldingot: 105\n"
					+ "soil: 1\n"
					+ "clay: 12\n"
					+ "goldblock: 450\n"
					+ "paper: 10\n"
					+ "brick: 21\n"
					+ "chest: 4\n"
					+ "sandstone: 3\n"
					+ "sugarcane: 10\n"
					+ "sponge: 80\n"
					+ "coal: 15\n"
					+ "bone: 2\n"
					+ "diamond: 200\n"
					+ "glass: 30\n"
					+ "lapisblock: 950\n"
					+ "wheat: 9\n"
					+ "lapisore: 100\n"
					+ "lava: 25\n"
					+ "redstone: 32\n"
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
					+ "bakedpotato: 3\n");
	  }
	}
}
	
	
	public static void setBuyValue() throws IOException {	
		File file = new File("CurrencyData/ShopBuyValues.yml");
	if(!file.exists()) {
		file.createNewFile();
	
	  try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write( "  stonebutton: 6\n"
					+ "  wood: 1\n"
					+ "  arrow: 30\n"
					+ "  diamondpickaxe: 650\n"
					+ "  rawfish: 5\n"
					+ "  minecart: 23\n"
					+ "  leatherchestplate: 85\n"
					+ "  storageminecart: 30\n"
					+ "  feather: 3\n"
					+ "  goldchestplate: 6\n"
					+ "  mushroomsoup: 4\n"
					+ "  bread: 30\n"
					+ "  stationarywater: 1\n"
					+ "  workbench: 2\n"
					+ "  stonehoe: 2\n"
					+ "  brownmushroom: 2\n"
					+ "  mossycobblestone: 90\n"
					+ "  diamondhoe: 400\n"
					+ "  woodsword: 1\n"
					+ "  torch: 4\n"
					+ "  grass: 1\n"
					+ "  poweredminecart: 32\n"
					+ "  snowball: 1\n"
					+ "  goldenapple: 100\n"
					+ "  leatherleggings: 75\n"
					+ "  diamondaxe: 650\n"
					+ "  slimeball: 50\n"
					+ "  fence: 1\n"
					+ "  stonespade: 1\n"
					+ "  claybrick: 5\n"
					+ "  noteblock: 36\n"
					+ "  ironaxe: 22\n"
					+ "  coalore: 15\n"
					+ "  clayball: 3\n"
					+ "  fishingrod: 10\n"
					+ "  ironhoe: 22\n"
					+ "  goldrecord: 100\n"
					+ "  ironpickaxe: 22\n"
					+ "  irondoor: 22\n"
					+ "  bucket: 22\n"
					+ "  redrose: 2\n"
					+ "  grilledpork: 7\n"
					+ "  gravel: 1\n"
					+ "  wooddoor: 3\n"
					+ "  chainmailhelmet: 40\n"
					+ "  ironchestplate: 22\n"
					+ "  diamondblock: 2000\n"
					+ "  diamondhelmet: 1000\n"
					+ "  goldhelmet: 6\n"
					+ "  redstonetorchon: 32\n"
					+ "  ironspade: 22\n"
					+ "  furnace: 8\n"
					+ "  ironsword: 22\n"
					+ "  dispenser: 58\n"
					+ "  woodaxe: 2\n"
					+ "  seeds: 2\n"
					+ "  painting: 25\n"
					+ "  woodplate: 1\n"
					+ "  redstoneore: 30\n"
					+ "  diamondspade: 210\n"
					+ "  waterbucket: 40\n"
					+ "  water: 1\n"
					+ "  bedrock: 100\n"
					+ "  irondoorblock: 15\n"
					+ "  goldhoe: 6\n"
					+ "  sand: 1\n"
					+ "  goldsword: 6\n"
					+ "  stoneaxe: 3\n"
					+ "  bookshelf: 140\n"
					+ "  ironblock: 190\n"
					+ "  jackolantern: 56\n"
					+ "  boat: 3\n"
					+ "  diamondchestplate: 1750\n"
					+ "  redstonewire: 30\n"
					+ "  redmushroom: 2\n"
					+ "  string: 5\n"
					+ "  stoneplate: 6\n"
					+ "  wallsign: 1\n"
					+ "  cactus: 10\n"
					+ "  sulphur: 20\n"
					+ "  rails: 22\n"
					+ "  ironore: 18\n"
					+ "  leatherhelmet: 52\n"
					+ "  stone: 30\n"
					+ "  egg: 1\n"
					+ "  diamondore: 200\n"
					+ "  woodhoe: 2\n"
					+ "  goldleggings: 6\n"
					+ "  chainmailleggings: 50\n"
					+ "  yellowflower: 2\n"
					+ "  ironhelmet: 22\n"
					+ "  obsidian: 130\n"
					+ "  dirt: 1\n"
					+ "  leather: 10\n"
					+ "  leatherboots: 42\n"
					+ "  lever: 1\n"
					+ "  cobblestone: 1\n"
					+ "  cake: 180\n"
					+ "  woodstairs: 1\n"
					+ "  ironingot: 22\n"
					+ "  goldore: 45\n"
					+ "  pumpkin: 50\n"
					+ "  bed: 68\n"
					+ "  watch: 6\n"
					+ "  ironleggings: 22\n"
					+ "  sign: 1\n"
					+ "  doublestep: 1\n"
					+ "  woodpickaxe: 2\n"
					+ "  stonepickaxe: 4\n"
					+ "  chainmailboots: 30\n"
					+ "  diamondleggings: 1500\n"
					+ "  cookedfish: 7\n"
					+ "  saddle: 100\n"
					+ "  cobblestonestairs: 1\n"
					+ "  tnt: 100\n"
					+ "  glowingredstoneore: 30\n"
					+ "  apple: 10\n"
					+ "  woodspade: 1\n"
					+ "  goldingot: 105\n"
					+ "  diode: 110\n"
					+ "  soil: 1\n"
					+ "  clay: 12\n"
					+ "  goldblock: 450\n"
					+ "  stick: 1\n"
					+ "  paper: 10\n"
					+ "  brick: 21\n"
					+ "  stationarylava: 1\n"
					+ "  chest: 4\n"
					+ "  sandstone: 3\n"
					+ "  goldpickaxe: 6\n"
					+ "  compass: 22\n"
					+ "  sugarcane: 10\n"
					+ "  diamondsword: 420\n"
					+ "  goldboots: 6\n"
					+ "  sponge: 80\n"
					+ "  stonesword: 2\n"
					+ "  coal: 15\n"
					+ "  goldaxe: 6\n"
					+ "  bone: 2\n"
					+ "  diamond: 200\n"
					+ "  glass: 30\n"
					+ "  goldspade: 6\n"
					+ "  lapisblock: 950\n"
					+ "  lavabucket: 40\n"
					+ "  wheat: 9\n"
					+ "  ladder: 1\n"
					+ "  sugarcaneblock: 15\n"
					+ "  bowl: 1\n"
					+ "  chainmailchestplate: 40\n"
					+ "  diamondboots: 850\n"
					+ "  lapisore: 100\n"
					+ "  lava: 25\n"
					+ "  milkbucket: 40\n"
					+ "  redstone: 32\n"
					+ "  greenrecord: 100\n"
					+ "  inksack: 10\n"
					+ "  glowstonedust: 10\n"
					+ "  book: 45\n"
					+ "  bow: 15\n"
					+ "  ironboots: 22\n"
					+ "  step: 1\n"
					+ "  sugar: 10\n"
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
			    	// System.out.println(value);
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
					    	//System.out.println(value);
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
