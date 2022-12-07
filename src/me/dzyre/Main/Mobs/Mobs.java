package me.dzyre.Main.Mobs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Mobs implements Listener{

	@EventHandler
	public void pickupMob(PlayerInteractEntityEvent event){
		Player player = event.getPlayer();
			if(player.getInventory().getItemInMainHand().getType().equals(Material.BUCKET)) {
				if(event.getRightClicked().getType() == null){
					return;
				}
				if(player.isSneaking()) {
			ItemStack bucket = player.getInventory().getItemInMainHand();
			
			
			ItemMeta bucketMeta = bucket.getItemMeta();
			if(bucketMeta.getDisplayName() != "") {
				//player.sendMessage(bucketMeta.getDisplayName());
				event.setCancelled(true);
				return;
			}
			
				event.setCancelled(true);
				bucket.setAmount(bucket.getAmount()-1);
				bucket = new ItemStack(Material.BUCKET);
			bucketMeta.setDisplayName(event.getRightClicked().getType().toString().toLowerCase() + " bucket");
			bucket.setItemMeta(bucketMeta);
			
			player.getInventory().addItem(bucket);
			event.getRightClicked().remove();
			
			}
			}
			
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void setDownMob(PlayerInteractEvent event) {
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(event.getHand() != EquipmentSlot.HAND) return;
		Player player = event.getPlayer();
	
		if(player.getInventory().getItemInMainHand().getType().equals(Material.BUCKET)) {
			ItemStack bucket = player.getInventory().getItemInMainHand();
			ItemMeta bucketMeta = bucket.getItemMeta();
			if(bucketMeta.getDisplayName() == "") {
				//player.sendMessage(bucketMeta.getDisplayName());
				return;
			}
			
			Bukkit.getWorld(player.getWorld().getUID()).spawnEntity(event.getClickedBlock().getLocation().add(0,1,0), EntityType.fromName(bucketMeta.getDisplayName().split(" ")[0].toUpperCase()));
			bucket.setAmount(bucket.getAmount()-1);
			player.getInventory().addItem(new ItemStack(Material.BUCKET));
	}
		
	}
}}

