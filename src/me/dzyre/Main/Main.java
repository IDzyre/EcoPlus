package me.dzyre.Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.bukkit.plugin.java.JavaPlugin;

import me.dzyre.Main.Currency.Eco;
import me.dzyre.Main.Currency.CreateInventories;
import me.dzyre.Main.Currency.SetShopValues;
public class Main extends JavaPlugin {
	Eco eco = new Eco();
	@Override
	public void onEnable() {
	
		File file = new File("CurrencyData");
		if (!(file.exists())) {
			file.mkdirs();
		}
		try {
			SetShopValues.getCost();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			SetShopValues.setSellValue();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			SetShopValues.setBuyValue();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		CreateInventories.createInventory();
		getCommand("Bal").setExecutor(eco);
		getCommand("eco").setExecutor(eco);
		getCommand("pay").setExecutor(eco);
		//getCommand("Buy").setExecutor(eco);
		//getCommand("Sell").setExecutor(eco);
		getCommand("Shop").setExecutor(eco);
		System.out.println("Welcome");
		this.getServer().getPluginManager().registerEvents(eco, this);

		try {
			eco.loadCurrency();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void onDisable() {
		System.out.println("Gudbie");
		
		try {
		eco.saveCurrency();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

	
}


