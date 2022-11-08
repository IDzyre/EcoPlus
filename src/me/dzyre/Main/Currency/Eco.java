package me.dzyre.Main.Currency;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Eco implements Listener, CommandExecutor {
	public static Inventory mainShop = Bukkit.createInventory(null, 9,
			ChatColor.GOLD + "" + ChatColor.BOLD + "Buy Shop");
	public static Inventory Cancel;
	public static Inventory buy = Bukkit.createInventory(null, 54,
			ChatColor.AQUA + "" + ChatColor.BOLD + "Armor and Weapons");
	public static Inventory foodItems = Bukkit.createInventory(null, 9,
			ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Food Items");
	public static Inventory mainSell = Bukkit.createInventory(null, 9,
			ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Sell Shop");
	public static Inventory sell = Bukkit.createInventory(null, 54,
			ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Sell Items");
	public static Inventory menu = Bukkit.createInventory(null, 9, ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Menu");
	String currInv = "";
	ItemStack itemz = null;
	InventoryView temp = null;
	public HashMap<UUID, Integer> currency = new HashMap<UUID, Integer>();
	public static HashMap<String, Integer> shopBuyValues = new HashMap<String, Integer>();
	public static HashMap<String, Integer> shopSellValues = new HashMap<String, Integer>();

	public void ecoGive(OfflinePlayer p, int amount) {
		if (currency.get(p.getUniqueId()) != null) {
			currency.put(p.getUniqueId(), currency.get(p.getUniqueId()) + amount);
		} else {
			currency.put(p.getUniqueId(), amount);
		}
	}

	public void ecoRemove(OfflinePlayer p, int amount) {
		if (currency.get(p.getUniqueId()) != null) {
			currency.put(p.getUniqueId(), currency.get(p.getUniqueId()) - amount);
		}
	}

	public void ecoSet(OfflinePlayer p, int amount) {
		currency.put(p.getUniqueId(), amount);
	}

	public int checkEco(OfflinePlayer p) {
		if (currency.get(p.getUniqueId()) != null) {
			return currency.get(p.getUniqueId());

		}
		return 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			/*
			 * if (label.equalsIgnoreCase("buy")) { Player player = (Player) sender;
			 * player.openInventory(mainShop); temp = player.getOpenInventory(); return
			 * true; } if (label.equalsIgnoreCase("sell")) { Player player = (Player)
			 * sender; player.openInventory(mainSell); temp = player.getOpenInventory();
			 * return true; }
			 */
			if (label.equalsIgnoreCase("shop")) {
				Player player = (Player) sender;
				player.openInventory(menu);
				temp = player.getOpenInventory();
				return true;
			}
			if (label.equalsIgnoreCase("pay")) {
				sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Usage: /pay <player> <amount>");
				return true;
			}
			if ((label.equalsIgnoreCase("bal")) || (label.equalsIgnoreCase("balance"))) {
				OfflinePlayer currentPlayer = (OfflinePlayer) sender;
				sender.sendMessage(ChatColor.AQUA + "" + currentPlayer.getName() + "'s " + ChatColor.GREEN
						+ "Balance: $" + checkEco(currentPlayer));
			}

			if (label.equalsIgnoreCase("eco")) {
				if (sender.hasPermission("eco")) {

					sender.sendMessage(
							ChatColor.RED + "" + ChatColor.BOLD + "Usage: /eco <give:remove:set> <player> <amount>");
					return true;
				} else {
					sender.sendMessage(ChatColor.RED + "Invalid Permissions");
				}
			}
			return true;
		} else if (args.length == 1) {
			if ((label.equalsIgnoreCase("bal")) || (label.equalsIgnoreCase("balance"))) {
				OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
				if (player == null) {
					sender.sendMessage(ChatColor.RED + "Invalid Player: " + ChatColor.AQUA + "" + args[0]);
				} else {
					sender.sendMessage(ChatColor.AQUA + "" + player.getName() + "'s" + ChatColor.GREEN + " Balance: $"
							+ checkEco(player));
					return true;
				}
			}
			if (label.equalsIgnoreCase("pay")) {
				sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Usage: /pay <player> <amount>");
				return true;
			}

			if (label.equalsIgnoreCase("eco")) {
				if (sender.hasPermission("eco")) {

					sender.sendMessage(
							ChatColor.RED + "" + ChatColor.BOLD + "Usage: /eco <give:remove:set> <player> <amount>");
					return true;
				} else {
					sender.sendMessage(ChatColor.RED + "Invalid Permissions");
				}
			}
		} else if (args.length == 2) {
			if (label.equalsIgnoreCase("eco")) {
				sender.sendMessage(
						ChatColor.RED + "" + ChatColor.BOLD + "Usage: /eco <give:remove:set> <player> <amount>");
			} else if (label.equalsIgnoreCase("pay")) {
				OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
				if (player == null || (!(player.hasPlayedBefore()))) {
					sender.sendMessage(ChatColor.RED + "Invalid Player: " + ChatColor.AQUA + "" + args[1]);
				} else {

					Integer amount = Integer.parseInt(args[1]);
					if (currency.get(((OfflinePlayer) sender).getUniqueId()) - amount >= 0) {
						ecoRemove((OfflinePlayer) sender, amount);
						ecoGive(player, amount);
						sender.sendMessage(ChatColor.GREEN + "$" + amount + ChatColor.AQUA + " Has been sent to "
								+ player.getName());
						((Player) player).sendMessage(ChatColor.GREEN + "$" + amount + ChatColor.AQUA
								+ " Has been recieved from " + sender.getName());
					} else {
						sender.sendMessage(ChatColor.RED + "You do not have enough money");
					}
				}

			}

			if ((label.equalsIgnoreCase("bal")) || (label.equalsIgnoreCase("balance"))) {
				OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
				if (player == null) {
					sender.sendMessage(ChatColor.RED + "Invalid Player: " + ChatColor.AQUA + "" + args[0]);
				} else {
					sender.sendMessage(ChatColor.AQUA + "" + player.getName() + "'s" + ChatColor.GREEN + " Balance: $"
							+ checkEco(player));
					return true;
				}
			}

		} else if (args.length == 3) {
			if (label.equalsIgnoreCase("eco")) {
				if (sender.hasPermission("eco")) {
					if (args[0].equalsIgnoreCase("set")) {

						OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
						if (player == null) {
							sender.sendMessage(ChatColor.RED + "Invalid Player: " + ChatColor.AQUA + "" + args[1]);
						} else {
							Integer amount = Integer.parseInt(args[2]);
							ecoSet(player, amount);
							sender.sendMessage(ChatColor.GREEN + "Set " + ChatColor.AQUA + "" + player.getName() + "'s"
									+ ChatColor.GREEN + " balance to $" + amount);
						}
					}
					if (args[0].equalsIgnoreCase("give")) {
						OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
						if (player == null) {
							sender.sendMessage(ChatColor.RED + "Invalid Player: " + ChatColor.AQUA + "" + args[1]);
						} else {
							Integer amount = Integer.parseInt(args[2]);
							ecoGive(player, amount);
							sender.sendMessage(ChatColor.RED + "Successfully Added: $" + ChatColor.GREEN + amount);
						}
					}
					if (args[0].equalsIgnoreCase("remove")) {
						OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
						if (player == null) {
							sender.sendMessage(ChatColor.RED + "Invalid Player: " + ChatColor.AQUA + "" + args[1]);
						} else {
							Integer amount = Integer.parseInt(args[2]);
							ecoRemove(player, amount);
							sender.sendMessage(ChatColor.RED + "Successfully removed: $" + ChatColor.GREEN + amount);
						}
					}
				} else {
					sender.sendMessage(ChatColor.RED + "Invalid Permissions");
				}
			}

		}
		return true;
	}

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if (!((event.getInventory().equals(mainShop) || event.getInventory().equals(buy)
				|| event.getInventory().equals(menu) || event.getInventory().equals(foodItems)
				|| event.getInventory().equals(mainSell) || event.getInventory().equals(sell)
				|| event.getInventory().equals(Cancel)))
				|| ((event.getCurrentItem() == null) || (event.getCurrentItem().getItemMeta() == null)
						|| (event.getInventory().equals(event.getWhoClicked().getInventory()))
						|| (event.getCurrentItem().getItemMeta().getDisplayName() == null))) {
			return;
		}
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		if (event.getCurrentItem().getType().equals(Material.BARRIER)) {

			if (event.getClickedInventory().equals(mainShop)) {
				player.openInventory(menu);
				return;
			}
			if (currInv == "food" || currInv == "buy") {
				player.openInventory(mainShop);
				return;
			}
			if (currInv == "sell") {
				player.openInventory(menu);
				return;
			}
			return;
		}
		if (event.getCurrentItem().getType().equals(Material.DIAMOND)
				&& event.getCurrentItem().getItemMeta().getDisplayName().contains("Buy")) {
			currInv = "buyMenu";
			player.openInventory(mainShop);
			return;
		}
		if (event.getCurrentItem().getType().equals(Material.PAPER)
				&& event.getCurrentItem().getItemMeta().getDisplayName().contains("Sell")) {
			currInv = "sell";
			player.openInventory(sell);
			return;
		}
		if ((event.getCurrentItem().getType().equals(Material.DIAMOND_CHESTPLATE))
				&& (event.getCurrentItem().hasItemMeta()) && event.getClickedInventory().equals(mainShop)) {
			currInv = "buy";
			player.openInventory(buy);
			return;
		}
		/*
		 * if ((event.getCurrentItem().getType().equals(Material.DIAMOND)) &&
		 * (event.getCurrentItem().hasItemMeta()) &&
		 * event.getClickedInventory().equals(mainSell)) { player.openInventory(sell);
		 * temp = player.getOpenInventory(); return; }
		 */
		if ((event.getCurrentItem().getType().equals(Material.COOKED_BEEF)) && (event.getCurrentItem().hasItemMeta())
				&& event.getClickedInventory().equals(mainShop)) {
			currInv = "food";
			player.openInventory(foodItems);
			return;
		}
		if ((event.getClickedInventory().equals(foodItems)) && !(event.getCurrentItem().getType() == null)) {
			itemz = event.getCurrentItem();
			temp = player.getOpenInventory();
			currInv = "food";
			confirm(itemz, foodItems, itemz.getItemMeta().getLore());
			player.openInventory(Cancel);
			return;
		}
		if ((event.getClickedInventory().equals(buy)) && !(event.getCurrentItem().getType() == null)) {
			itemz = event.getCurrentItem();
			temp = player.getOpenInventory();
			currInv = "buy";
			confirm(itemz, buy, itemz.getItemMeta().getLore());
			player.openInventory(Cancel);
			return;
		}
		if ((event.getClickedInventory().equals(sell)) && !(event.getCurrentItem().getType() == null)) {
			itemz = event.getCurrentItem();
			temp = player.getOpenInventory();
			currInv = "sell";
			confirm(itemz, sell, itemz.getItemMeta().getLore());
			player.openInventory(Cancel);
			return;
		}
		if ((event.getCurrentItem().getType().equals(Material.RED_WOOL))
				&& event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.RED + "Cancel")) {
			player.openInventory(temp);
			return;
		}
		if ((event.getCurrentItem().getType().equals(Material.GREEN_WOOL))
				&& event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Confirm")) {
			if (currInv == "food" || (currInv == "buy")) {
				buy(itemz, event.getWhoClicked().getUniqueId(), player);
				return;
			}
		}
		if (event.getCurrentItem().getType().equals(Material.GREEN_WOOL)) {
			if (currInv == "sell") {
				if (event.getCurrentItem().getItemMeta().getDisplayName().contains("All")) {

					if (!(player.getInventory().contains(itemz.getType()))) {
						player.sendMessage(ChatColor.RED + "You do not have enough items to sell");
						player.openInventory(temp);
						return;
					}
					if (player.getInventory().contains(itemz.getType())) {
						sell(itemz, player, true);
						player.openInventory(sell);
						return;
					}
				}

				if (player.getInventory().containsAtLeast(new ItemStack(itemz.getType()),
						event.getCurrentItem().getAmount())) {
					int tempAmt = itemz.getAmount();
					itemz.setAmount(event.getCurrentItem().getAmount());
					sell(itemz, player, false);
					itemz.setAmount(tempAmt);
					player.openInventory(sell);
					return;

				} else {
					player.sendMessage(ChatColor.RED + "You do not have enough items to sell");
					player.openInventory(temp);
					return;
				}
			}
		}
	}

	public void confirm(ItemStack item, Inventory inv, List<String> lore) {
		if (item.getType().equals(Material.BARRIER)) {
			return;
		}
		Cancel = Bukkit.createInventory(null, 9, ChatColor.GREEN + "" + ChatColor.BOLD + "Confirm");

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(item.getItemMeta().getDisplayName());
		item.setItemMeta(meta);
		Cancel.setItem(4, item);

		ItemStack cancelitem = new ItemStack(Material.GREEN_WOOL);
		// Yes
		lore.clear();
		meta.setLore(lore);
		if (inv == sell) {
			meta.setDisplayName(ChatColor.GREEN + "Confirm Sale");
			cancelitem.setItemMeta(meta);
			Cancel.setItem(0, cancelitem);
			cancelitem.setAmount(16);
			Cancel.setItem(1, cancelitem);
			cancelitem.setAmount(64);
			Cancel.setItem(2, cancelitem);
			meta.setDisplayName(ChatColor.GREEN + "All");
			cancelitem.setItemMeta(meta);
			cancelitem.setAmount(1);
			Cancel.setItem(3, cancelitem);
		}
		if (inv == buy || inv == foodItems) {
			meta.setDisplayName(ChatColor.GREEN + "Confirm Purchase");
			cancelitem.setItemMeta(meta);
			Cancel.setItem(2, cancelitem);
		}

		// No
		cancelitem.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.RED + "Cancel and Return");
		cancelitem.setItemMeta(meta);
		Cancel.setItem(6, cancelitem);

		return;
	}

	public void sell(ItemStack item, Player player, Boolean all) {
		String amount = item.getItemMeta().getLore().get(1);
		int count = item.getAmount();
		amount = amount.substring(2);
		int invSize = player.getInventory().getSize();
		if (item.getAmount() == 1) {
			if (all == true) {
				count = 0;
				for (int i = 0; i < invSize; i++) {
					if (!(player.getInventory().getItem(i) == null)
							&& (player.getInventory().getItem(i).getType() == item.getType())) {
						count += player.getInventory().getItem(i).getAmount();
						player.getInventory().clear(i);
					}
				}
			} else {
				player.getInventory().removeItem(new ItemStack(item.getType(), item.getAmount()));
			}
		} else {
			player.getInventory().removeItem(new ItemStack(item.getType(), item.getAmount()));
		}
		ecoGive((OfflinePlayer) player, Integer.parseInt(amount) * count);
		player.sendMessage("Successfully sold " + count + " " + item.getItemMeta().getDisplayName() + ChatColor.WHITE
				+ " for " + ChatColor.GOLD + "$" + Integer.parseInt(amount) * count);
	}

	public void buy(ItemStack item, UUID uuid, Player player) {
		String amount = item.getItemMeta().getLore().get(1);
		amount = amount.substring(1).replaceAll("\\s", "");
		if (currency.get(uuid) == 0) {
			player.sendMessage(ChatColor.RED + "You don't have enough money");
			player.openInventory(mainShop);
			return;
		}
		if (currency.get(uuid) - Integer.parseInt(amount) >= 0) {
			ecoRemove((OfflinePlayer) player, Integer.parseInt(amount));
			player.sendMessage("Successfully purchased " + ChatColor.GREEN + item.getType().name().replace("_", " ")
					+ ChatColor.WHITE + " for " + ChatColor.GREEN + "$" + amount);
			player.getInventory().addItem(new ItemStack(item.getType(), item.getAmount()));
			player.openInventory(mainShop);
			return;
		}
		player.sendMessage(ChatColor.RED + "You don't have enough money");
		player.openInventory(mainShop);
		return;
	}

	public void saveCurrency() throws FileNotFoundException, IOException {
		File file = new File("CurrencyData/currency.dat");
		for (OfflinePlayer p : Bukkit.getOfflinePlayers()) {

			ObjectOutputStream output = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file)));

			if (currency.get(p.getUniqueId()) != null) {
				currency.put(p.getUniqueId(), currency.get(p.getUniqueId()));
			}
			try {
				output.writeObject(currency);
				output.flush();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@SuppressWarnings("unchecked")
	public void loadCurrency() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("CurrencyData/currency.dat");
		if (!file.exists())
			file.createNewFile();
		if (file != null) {
			ObjectInputStream input = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file)));
			Object readObject = input.readObject();
			input.close();

			if (!(readObject instanceof HashMap))
				throw new IOException("Data is not Hash Map");
			currency = (HashMap<UUID, Integer>) readObject;
			for (UUID key : currency.keySet()) {
				currency.put(key, currency.get(key));
			}

		}
	}

}
