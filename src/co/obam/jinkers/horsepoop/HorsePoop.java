package co.obam.jinkers.horsepoop;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class HorsePoop extends JavaPlugin {
	public void onEnable() {
		getLogger().info("Plugin Enabled!");
		this.getServer().getPluginManager().registerEvents(new CropGrowEvent(), this);

	}
	
	public ItemStack hP()  {
		ItemStack Poop = new ItemStack(Material.INK_SACK, 1);
		ItemMeta poopMeta = Poop.getItemMeta();
		poopMeta.setDisplayName("Horse Poop");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("It's so stinky");
		lore.add("Java Version 2.0");
		
		poopMeta.setLore(lore);
		
		//poopMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		
		Poop.setItemMeta(poopMeta);
		return Poop;
	}

	public void onDisable() {

	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender; 
		if (cmd.getName().equalsIgnoreCase("poop")) {
			player.getInventory().addItem(hP());
		}
		return true;
	}
	 	
}
