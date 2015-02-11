package co.obam.jinkers.horsepoop;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
//import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CropGrowEvent implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			//p.sendMessage("Right Clicked");
			String itemName = event.getItem().getItemMeta().getDisplayName().toString();
			//p.sendMessage(itemName);
			//String itemName2 = "Horse Poop";
			if(itemName != ChatColor.WHITE + "Horse Poop") {
				//p.sendMessage("Got the name");
				Block block = event.getClickedBlock();
				//p.sendMessage("Got the Block");
				if (block.getType() ==  Material.CROPS || block.getType() == Material.POTATO || block.getType() == Material.CARROT || block.getType() == Material.PUMPKIN_STEM || block.getType() == Material.MELON_STEM) {
					//p.sendMessage("Got the crops");
					if (block.getData() != (byte) 7) {
						block.setData((byte) 7);
					
					//Why the hell didn't this work?
					/*Crops crops = (Crops) block.getData();
					p.sendMessage("Converted block to crops");
					if(crops.getState() != CropState.RIPE){
						p.sendMessage("Crop is not ready");
						crops.setState(CropState.RIPE);
						p.sendMessage("Crop is ready now");
						p.sendMessage(" ");*/
					}
				} else if (block.getType() == Material.GRASS) {
					 p.sendMessage("Grass detected");
					 Block bTest = block.getRelative(BlockFace.UP, 1);
					 p.sendMessage("Block above set");
					 if (bTest.isEmpty()) {
					 	p.sendMessage("Block is empty");
					 	bTest.setTypeIdAndData(31, (byte) 1, true);					 	
					}
				}
			}
		}
	}
	
}
