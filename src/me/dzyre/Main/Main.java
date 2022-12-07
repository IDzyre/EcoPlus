package me.dzyre.Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import me.dzyre.Main.Backpacks.BackpackOther;
import me.dzyre.Main.Currency.CreateInventories;
import me.dzyre.Main.Currency.Eco;
import me.dzyre.Main.Currency.SetShopValues;
import me.dzyre.Main.Mobs.Mobs;
public class Main extends JavaPlugin {
  Eco eco = new Eco();
  Mobs mobs = new Mobs();
  BackpackOther bpo = new BackpackOther();	
 // Backpack bp = new Backpack(36, this);
  
  @Override
  public void onEnable() {
    File file = new File("plugins/CurrencyData");
    if (!(file.exists())) {
      file.mkdirs();
    }
    try {
    	 SetShopValues.setSellValue();
      SetShopValues.setBuyValue();
      SetShopValues.setSpawnerValue();
      SetShopValues.getCost();
      SetShopValues.getSpawnerCosts();
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    CreateInventories.createInventory();
    CreateInventories.trySetValue();
    CreateInventories.setShopSpawner();
    try {
      SetShopValues.getBuyCost();
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    CreateInventories.setShops();
    getCommand("Bal").setExecutor(eco);
    getCommand("eco").setExecutor(eco);
    getCommand("pay").setExecutor(eco);
    getCommand("Shop").setExecutor(eco);
    getCommand("backpack").setExecutor(bpo);
    this.getServer().getPluginManager().registerEvents(bpo, this);
    this.getServer().getPluginManager().registerEvents(eco, this);
    this.getServer().getPluginManager().registerEvents(mobs, this);

    try {
      eco.loadCurrency();
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
   bpo.createInventories();
  }
  @Override
  public void onDisable() {
	  bpo.saveInventories();
	  
    try {
      eco.saveCurrency();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}