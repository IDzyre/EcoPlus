package me.dzyre.Main.Backpacks;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BackpackOther implements CommandExecutor, Listener {
  HashMap < UUID, Backpack > bps = new HashMap < UUID, Backpack > ();

  @EventHandler
  public void createInventory(PlayerJoinEvent event) {
    if (!event.getPlayer().hasPlayedBefore()) {
      Backpack playerBP = new Backpack(event.getPlayer().getUniqueId());
      bps.put(event.getPlayer().getUniqueId(), playerBP);
    } else if (bps.get(event.getPlayer().getUniqueId()) == null) {
      Player p = event.getPlayer();
      Backpack playerBP = new Backpack(p.getUniqueId());
      bps.put(p.getUniqueId(), playerBP);
      playerBP.setBackpackFromYML(playerBP);
    }
  }

  public void saveInventories() {
    for (Backpack x: bps.values()) {
      saveInventory(x);
    }
  }

  public void createInventories() {
    for (Player p: Bukkit.getOnlinePlayers()) {
      if (bps.get(p.getUniqueId()) == null) {
        Backpack playerBP = new Backpack(p.getUniqueId());
        bps.put(p.getUniqueId(), playerBP);
        playerBP.setBackpackFromYML(playerBP);
      }
    }
  }

  public void saveInventory(Backpack bp) {
    for (int i = 0; i < 36; i++) {
      if (!(bp.inventory.getItem(i) == null)) {
        bp.setBackpackYML(bp.person, bp.inventory.getItem(i), "" + i);
      } else {
        bp.removeBackpackYML(bp.person, "" + i);
      }
    }
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (label.equalsIgnoreCase("bp") || label.equalsIgnoreCase("backpack")) {
      Player player = (Player) sender;
      player.openInventory(bps.get(player.getUniqueId()).inventory);
      return true;
    }
    return false;
  }
}