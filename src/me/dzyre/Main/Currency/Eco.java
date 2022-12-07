package me.dzyre.Main.Currency;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
  public static Inventory mainBuy = Bukkit.createInventory(null, 9,
    ChatColor.GOLD + "" + ChatColor.BOLD + "Buy Shop");

  public static Inventory Cancel;

  public static Inventory buyArmor = Bukkit.createInventory(null, 54,
    ChatColor.AQUA + "" + ChatColor.BOLD + "Armor and Weapons");

  public static Inventory buyFoodItems = Bukkit.createInventory(null, 54,
    ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Buy Farn Items");

  public static Inventory sellFoodItems = Bukkit.createInventory(null, 54,
    ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Sell Farm Items");

  public static Inventory mainSell = Bukkit.createInventory(null, 9,
    ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Sell Shop");

  public static Inventory sellOreItems = Bukkit.createInventory(null, 36,
    ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Sell Ore Items");

  public static Inventory buySpawners = Bukkit.createInventory(null, 36,
    ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Buy Spawners");

  public static Inventory buyOreItems = Bukkit.createInventory(null, 36,
    ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Buy Ore Items");

  public static Inventory sellBlockItems = Bukkit.createInventory(null, 54,
    ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Sell Blocks");

  public static Inventory buyBlockItems = Bukkit.createInventory(null, 54,
    ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Buy Blocks");

  public static Inventory sellDrops = Bukkit.createInventory(null, 36,
    ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Sell Mob Drops");

  public static Inventory buyDrops = Bukkit.createInventory(null, 36,
    ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Buy Mob Drops");

  public static Inventory menu = Bukkit.createInventory(null, 9, ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Menu");

  String currInv = "";
  ItemStack itemz = null;
  InventoryView temp = null;
  public HashMap < UUID, Integer > currency = new HashMap < UUID, Integer > ();
  public static HashMap < String, Integer > shopBuyValues = new HashMap < String, Integer > ();
  public static HashMap < String, Integer > shopSpawnerValues = new HashMap < String, Integer > ();
  public static HashMap < String, Integer > shopSellValues = new HashMap < String, Integer > ();

  public void ecoGive(UUID uuid, int amount) {
    if (currency.get(uuid) != null) {
      currency.put(uuid, currency.get(uuid) + amount);
    } else {
      currency.put(uuid, amount);
    }
  }

  public void ecoRemove(UUID uuid, int amount) {
    if (currency.get(uuid) != null) {
      currency.put(uuid, currency.get(uuid) - amount);
    }
  }

  public void ecoSet(OfflinePlayer p, int amount) {
    currency.put(p.getUniqueId(), amount);
  }

  public int checkEco(UUID uuid) {
    if (currency.get(uuid) != null) {
      return currency.get(uuid);
    }
    return 0;
  }

  @SuppressWarnings("deprecation")
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (args.length == 0) {
      if (label.equalsIgnoreCase("shop")) {
        Player player = (Player) sender;
        player.openInventory(menu);
        return true;
      }
      if (label.equalsIgnoreCase("pay")) {
        sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Usage: /pay <player> <amount>");
        return true;
      }
      if ((label.equalsIgnoreCase("bal")) || (label.equalsIgnoreCase("balance"))) {
        UUID uuid = ((Player) sender).getUniqueId();
        sender.sendMessage(ChatColor.AQUA + "" + Bukkit.getPlayer(uuid).getName() + "'s " + ChatColor.GREEN +
          "Balance: $" + checkEco(uuid));
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
        UUID uuid = (Bukkit.getPlayer(args[0])).getUniqueId();
        if (Bukkit.getOfflinePlayer(uuid) == null) {
          sender.sendMessage(ChatColor.RED + "Invalid Player: " + ChatColor.AQUA + "" + args[0]);
        } else {
          sender.sendMessage(ChatColor.AQUA + "" + Bukkit.getOfflinePlayer(uuid).getName() + "'s" +
            ChatColor.GREEN + " Balance: $" + checkEco(uuid));
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
        UUID uuid = (Bukkit.getPlayer(args[1])).getUniqueId();
        if (Bukkit.getOfflinePlayer(uuid) == null || (!(Bukkit.getOfflinePlayer(uuid).hasPlayedBefore()))) {
          sender.sendMessage(ChatColor.RED + "Invalid Player: " + ChatColor.AQUA + "" + args[1]);
        } else {
          Integer amount = Integer.parseInt(args[1]);
          if (currency.get((Bukkit.getPlayer(args[1])).getUniqueId()) - amount >= 0) {
            ecoRemove((Bukkit.getPlayer(args[1])).getUniqueId(), amount);
            ecoGive((Bukkit.getPlayer(args[1])).getUniqueId(), amount);
            sender.sendMessage(ChatColor.GREEN + "$" + amount + ChatColor.AQUA + " Has been sent to " +
              args[1]);
            ((Bukkit.getPlayer(args[1]))).sendMessage(ChatColor.GREEN + "$" + amount + ChatColor.AQUA +
              " Has been recieved from " + sender.getName());
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
          sender.sendMessage(ChatColor.AQUA + "" + player.getName() + "'s" + ChatColor.GREEN + " Balance: $" +
            checkEco(player.getUniqueId()));
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
              sender.sendMessage(ChatColor.GREEN + "Set " + ChatColor.AQUA + "" + player.getName() + "'s" +
                ChatColor.GREEN + " balance to $" + amount);
            }
          }
          if (args[0].equalsIgnoreCase("give")) {
            OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
            if (player == null) {
              sender.sendMessage(ChatColor.RED + "Invalid Player: " + ChatColor.AQUA + "" + args[1]);
            } else {
              Integer amount = Integer.parseInt(args[2]);
              ecoGive(player.getUniqueId(), amount);
              sender.sendMessage(ChatColor.RED + "Successfully Added: $" + ChatColor.GREEN + amount);
            }
          }
          if (args[0].equalsIgnoreCase("remove")) {
            OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
            if (player == null) {
              sender.sendMessage(ChatColor.RED + "Invalid Player: " + ChatColor.AQUA + "" + args[1]);
            } else {
              Integer amount = Integer.parseInt(args[2]);
              ecoRemove(player.getUniqueId(), amount);
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
    if (event.getClickedInventory() == null || event.getCurrentItem() == null ||
      event.getCurrentItem().getItemMeta() == null ||
      event.getCurrentItem().getItemMeta().getDisplayName() == null) {
      return;
    }
    if (!(event.getInventory().equals(mainBuy) || event.getInventory().equals(buySpawners) || event.getInventory().equals(buyArmor) ||
        event.getInventory().equals(menu) || event.getInventory().equals(buyFoodItems) ||
        event.getInventory().equals(sellFoodItems) || event.getInventory().equals(mainSell) ||
        event.getInventory().equals(Cancel) || event.getInventory().equals(buyBlockItems) ||
        event.getInventory().equals(sellBlockItems) || event.getInventory().equals(buyOreItems) ||
        event.getInventory().equals(sellOreItems) || event.getInventory().equals(buyDrops) ||
        event.getInventory().equals(sellDrops))) {
      if ((!(event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Sell") || (event
          .getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Buy") ||
          (event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.RED + "Cancel")))))) {
        return;
      }
      if ((event.getClickedInventory().equals(event.getWhoClicked().getInventory()))) {
        event.setCancelled(true);
        return;
      }
    }
    
    Player player = (Player) event.getWhoClicked();
    event.setCancelled(true);
    if (event.getCurrentItem().getType().equals(Material.BARRIER)) {

      if (event.getClickedInventory().equals(buyFoodItems)) {
        player.openInventory(mainBuy);
        return;
      }
      if (event.getClickedInventory().equals(buyArmor)) {
        player.openInventory(mainBuy);
        return;
      }
      if (event.getClickedInventory().equals(buySpawners)) {
        player.openInventory(mainBuy);
        return;
      }
      if (event.getClickedInventory().equals(sellFoodItems)) {
        player.openInventory(mainSell);
        return;
      }
      if (event.getClickedInventory().equals(sellOreItems)) {
        player.openInventory(mainSell);
        return;
      }
      if (event.getClickedInventory().equals(sellBlockItems)) {
        player.openInventory(mainSell);
        return;
      }
      if (event.getClickedInventory().equals(sellDrops)) {
        player.openInventory(mainSell);
        return;
      }

      if (event.getClickedInventory().equals(buyOreItems)) {
        player.openInventory(mainBuy);
        return;
      }
      if (event.getClickedInventory().equals(buyBlockItems)) {
        player.openInventory(mainBuy);
        return;
      }
      if (event.getClickedInventory().equals(buyDrops)) {
        player.openInventory(mainBuy);
        return;
      }
      if (event.getClickedInventory().equals(mainSell)) {
        player.openInventory(menu);
        return;
      }
      if (event.getClickedInventory().equals(mainBuy)) {
        player.openInventory(menu);
        return;
      }
      return;
    }

    if (event.getCurrentItem().getType().equals(Material.DIAMOND) &&
      event.getCurrentItem().getItemMeta().getDisplayName().contains("Buy Ore")) {
      player.openInventory(buyOreItems);
      return;
    }
    if (event.getCurrentItem().getType().equals(Material.SPAWNER) &&
      event.getCurrentItem().getItemMeta().getDisplayName().contains("Buy")) {
      player.openInventory(buySpawners);
      return;
    }
    if (event.getCurrentItem().getType().equals(Material.DIAMOND) &&
      event.getCurrentItem().getItemMeta().getDisplayName().contains("Buy")) {
      player.openInventory(mainBuy);
      return;
    }
    if (event.getCurrentItem().getType().equals(Material.PAPER) &&
      event.getCurrentItem().getItemMeta().getDisplayName().contains("Sell")) {
      player.openInventory(mainSell);
      return;
    }
    if (event.getCurrentItem().getType().equals(Material.DIAMOND) &&
      event.getCurrentItem().getItemMeta().getDisplayName().contains("Sell")) {
      player.openInventory(sellOreItems);
      return;
    }
    if (event.getCurrentItem().getType().equals(Material.COOKED_BEEF) &&
      event.getCurrentItem().getItemMeta().getDisplayName().contains("Sell")) {
      player.openInventory(sellFoodItems);
      return;
    }
    if (event.getCurrentItem().getType().equals(Material.COBBLESTONE) &&
      event.getCurrentItem().getItemMeta().getDisplayName().contains("Sell")) {
      player.openInventory(sellBlockItems);
      return;
    }
    if (event.getCurrentItem().getType().equals(Material.ROTTEN_FLESH) &&
      event.getCurrentItem().getItemMeta().getDisplayName().contains("Sell")) {
      player.openInventory(sellDrops);
      return;
    }

    if (event.getCurrentItem().getType().equals(Material.COBBLESTONE) &&
      event.getCurrentItem().getItemMeta().getDisplayName().contains("Buy")) {
      player.openInventory(buyBlockItems);
      return;
    }
    if (event.getCurrentItem().getType().equals(Material.ROTTEN_FLESH) &&
      event.getCurrentItem().getItemMeta().getDisplayName().contains("Buy")) {
      player.openInventory(buyDrops);
      return;
    }

    if ((event.getCurrentItem().getType().equals(Material.DIAMOND_CHESTPLATE)) &&
      (event.getCurrentItem().hasItemMeta()) && event.getClickedInventory().equals(mainBuy)) {
      player.openInventory(buyArmor);
      return;
    }
    if ((event.getCurrentItem().getType().equals(Material.COOKED_BEEF)) && (event.getCurrentItem().hasItemMeta()) &&
      event.getClickedInventory().equals(mainBuy)) {
      player.openInventory(buyFoodItems);
      return;
    }

    if ((event.getCurrentItem().getType().equals(Material.RED_WOOL)) &&
      event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.RED + "Cancel")) {
      if (event.getCurrentItem().getItemMeta().getLore().contains(ChatColor.BLACK + "mainSell")) {
        player.openInventory(mainSell);
      } else {
        player.openInventory(mainBuy);
      }
      return;
    }

    if (event.getCurrentItem().getType().equals(Material.GREEN_WOOL)) {
      if (event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Sell")) {
        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("All")) {
          if (!(player.getInventory().contains(event.getClickedInventory().getItem(4).getType()))) {
            player.sendMessage(ChatColor.RED + "You do not have enough items to sell");
            player.openInventory(mainSell);
            return;
          }
          if (player.getInventory().contains(event.getClickedInventory().getItem(4).getType())) {
            sell(event.getClickedInventory().getItem(4), player, true);
            player.openInventory(mainSell);
            return;
          }
        }

        if (player.getInventory().containsAtLeast(
            new ItemStack(event.getClickedInventory().getItem(4).getType()),
            event.getCurrentItem().getAmount())) {
          event.getClickedInventory().getItem(4).setAmount(event.getCurrentItem().getAmount());
          sell(event.getClickedInventory().getItem(4), player, false);
          player.openInventory(mainSell);
          return;

        } else {
          player.sendMessage(ChatColor.RED + "You do not have enough items to sell");
          player.openInventory(mainSell);
          return;
        }
      }

      if (event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Buy")) {
        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("23")) {
          if (player.getInventory().firstEmpty() != 0) {
            player.sendMessage(ChatColor.RED + "You do not have enough space in your inventory");
            player.openInventory(mainBuy);
            return;
          } else {
            buy(event.getClickedInventory().getItem(4), 2304, player);
            return;
          }
        } else {

          if (player.getInventory().firstEmpty() == -1) {
            player.sendMessage(ChatColor.RED + "You do not have enough space in your inventory");
            player.openInventory(mainBuy);
            return;
          } else {
            buy(event.getClickedInventory().getItem(4), event.getCurrentItem().getAmount(), player);
            return;
          }

        }
      }
    }

    if (!(event.getCurrentItem().getType() == null)) {
      itemz = event.getCurrentItem();
      Inventory openInv = event.getClickedInventory();
      confirm(itemz, openInv, player);
      return;
    }

  }

  public void confirm(ItemStack item, Inventory inv, Player player) {
    Inventory Cancel = Bukkit.createInventory(null, 9, ChatColor.GREEN + "" + ChatColor.BOLD + "Confirm");

    Cancel.setItem(4, item);

    ItemStack cancelitem = new ItemStack(Material.GREEN_WOOL);
    ItemMeta meta = cancelitem.getItemMeta();
    List < String > lore = new ArrayList < String > ();
    // Yes

    if (inv == sellOreItems || inv == sellDrops || inv == sellFoodItems || inv == sellBlockItems) {
      lore.add(ChatColor.BLACK + "mainSell");
      meta.setLore(lore);
      meta.setDisplayName(ChatColor.GREEN + "Sell " + cancelitem.getAmount());
      cancelitem.setItemMeta(meta);
      Cancel.setItem(0, cancelitem);
      cancelitem.setAmount(16);
      meta.setDisplayName(ChatColor.GREEN + "Sell " + cancelitem.getAmount());
      cancelitem.setItemMeta(meta);
      Cancel.setItem(1, cancelitem);
      cancelitem.setAmount(64);
      meta.setDisplayName(ChatColor.GREEN + "Sell " + cancelitem.getAmount());
      cancelitem.setItemMeta(meta);
      Cancel.setItem(2, cancelitem);
      meta.setDisplayName(ChatColor.GREEN + "Sell All");
      cancelitem.setItemMeta(meta);
      cancelitem.setAmount(1);
      Cancel.setItem(3, cancelitem);
    } else if (inv == buyOreItems || inv == buyArmor || inv == buyDrops || inv == buyFoodItems ||
      inv == buyBlockItems || inv == buySpawners) {
      lore.add(ChatColor.BLACK + "mainBuy");
      meta.setLore(lore);
      meta.setDisplayName(ChatColor.GREEN + "Buy " + cancelitem.getAmount());
      cancelitem.setItemMeta(meta);
      Cancel.setItem(0, cancelitem);
      cancelitem.setAmount(16);
      meta.setDisplayName(ChatColor.GREEN + "Buy " + cancelitem.getAmount());
      cancelitem.setItemMeta(meta);
      Cancel.setItem(1, cancelitem);
      cancelitem.setAmount(64);
      meta.setDisplayName(ChatColor.GREEN + "Buy " + cancelitem.getAmount());
      cancelitem.setItemMeta(meta);
      Cancel.setItem(2, cancelitem);
      meta.setDisplayName(ChatColor.GREEN + "Buy 2304");
      cancelitem.setItemMeta(meta);
      cancelitem.setAmount(1);
      Cancel.setItem(3, cancelitem);
    }
    // No
    cancelitem.setType(Material.RED_WOOL);
    meta.setDisplayName(ChatColor.RED + "Cancel and Return");
    cancelitem.setItemMeta(meta);
    Cancel.setItem(6, cancelitem);
    player.openInventory(Cancel);
    return;
  }

  public void sell(ItemStack item, Player player, Boolean all) {
    String amount = item.getItemMeta().getLore().get(0);
    int count = item.getAmount();
    amount = amount.substring(14);
    int invSize = player.getInventory().getSize();
    if (item.getAmount() == 1) {
      if (all == true) {
        count = 0;
        for (int i = 0; i < invSize; i++) {
          if (!(player.getInventory().getItem(i) == null) &&
            (player.getInventory().getItem(i).getType() == item.getType())) {
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
    ecoGive(((OfflinePlayer) player).getUniqueId(), Integer.parseInt(amount) * count);
    player.sendMessage("Successfully sold " + count + " " + item.getItemMeta().getDisplayName() + ChatColor.WHITE +
      " for " + ChatColor.GOLD + "$" + Integer.parseInt(amount) * count);
  }

  public void buy(ItemStack item, int number, Player player) {
    UUID uuid = player.getUniqueId();
    String amount = item.getItemMeta().getLore().get(0);
    amount = amount.substring(9).replaceAll("\\s", "");
    if (currency.get(uuid) == null) {
      player.sendMessage(ChatColor.RED + "You don't have enough money");
      player.openInventory(mainBuy);
      return;
    }
    if (currency.get(uuid) - Integer.parseInt(amount) * number >= 0) {
      ecoRemove(((OfflinePlayer) player).getUniqueId(), Integer.parseInt(amount) * number);
      player.sendMessage(
        "Successfully purchased " + ChatColor.GREEN + number + " " + item.getItemMeta().getDisplayName().replace("_", " ") +
        ChatColor.WHITE + " for " + ChatColor.GREEN + "$" + Integer.parseInt(amount) * number);
      if (item.getType().equals(Material.SPAWNER)) {
        item.setAmount(number);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(null);
        item.setItemMeta(meta);
        player.getInventory().addItem(item);
        player.openInventory(mainBuy);
        return;
      } else {
        player.getInventory().addItem(new ItemStack(item.getType(), number));
        player.openInventory(mainBuy);
        return;
      }
    }
    player.sendMessage(ChatColor.RED + "You don't have enough money");
    player.openInventory(mainBuy);
    return;
  }

  public void saveCurrency() throws FileNotFoundException, IOException {
    File file = new File("plugins/CurrencyData/currency.dat");
    for (OfflinePlayer p: Bukkit.getOfflinePlayers()) {

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
    File file = new File("plugins/CurrencyData/currency.dat");
    if (!file.exists())
      file.createNewFile();
    if (file != null) {
      ObjectInputStream input = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file)));
      Object readObject = input.readObject();
      input.close();

      if (!(readObject instanceof HashMap))
        throw new IOException("Data is not Hash Map");
      currency = (HashMap < UUID, Integer > ) readObject;
      for (UUID key: currency.keySet()) {
        currency.put(key, currency.get(key));
      }

    }
  }

}