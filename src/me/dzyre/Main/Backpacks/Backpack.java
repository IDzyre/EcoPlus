package me.dzyre.Main.Backpacks;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Backpack {
	UUID person;
	Inventory inventory;
	
	private String customConfigFile = "plugins/MyModd/";
    private FileConfiguration customConfig;

	public Backpack(UUID uuid) {
		person = uuid;
		inventory = Bukkit.createInventory(Bukkit.getPlayer(uuid), 36, Bukkit.getPlayer(uuid).getName());
	}
	
	public void setBackpackYML(UUID playerUUID, ItemStack item, String place) {
		customConfig = new YamlConfiguration();
		File myFile = new File(customConfigFile+playerUUID +".yml");
		if(!myFile.exists()) {
			try {
				myFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			customConfig.load(customConfigFile+playerUUID+".yml");
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		customConfig.set(place, item);
		try {
			customConfig.save(customConfigFile + playerUUID+".yml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void removeBackpackYML(UUID playerUUID, String place) {
		customConfig = new YamlConfiguration();
		File myFile = new File(customConfigFile+playerUUID +".yml");
		if(!myFile.exists()) {
			try {
				myFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			customConfig.load(customConfigFile+playerUUID+".yml");
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		customConfig.set(place, "");
		try {
			customConfig.save(customConfigFile + playerUUID+".yml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setBackpackFromYML(Backpack bp){
		File myFile = new File(customConfigFile+bp.person+".yml");
		if(myFile.exists()) {
			customConfig = new YamlConfiguration();
			try {
				customConfig.load(customConfigFile+bp.person+".yml");
			} catch (IOException | InvalidConfigurationException e) {
				e.printStackTrace();
			}
			Set<String> x = customConfig.getKeys(false);
			for(String name : x) {
				bp.inventory.setItem(Integer.parseInt(name), customConfig.getItemStack(name));
			}
		}
	}
	
	
}
