package me.YourName.tutorial;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial extends JavaPlugin implements Listener {

	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
	}

	// Spawn a Cow
	public void spawnCOW(Player player) {
		Cow cow = (Cow) player.getLocation().getWorld()
				.spawn(player.getLocation(), Cow.class);
		// Set them as a baby
		cow.setBaby();
		// Lock their age
		cow.setAgeLock(true);
		// Set their nameplate (above head)
		cow.setCustomName(ChatColor.GREEN + "Baby Cow");
		// Make the custom name visible
		cow.setCustomNameVisible(true);
	}
	
	public void spawnVILLAGER(Player player)
	{
		Villager v = (Villager) player.getLocation().getWorld().spawn(player.getLocation(), Villager.class);
		
		v.setCustomName(ChatColor.GREEN + "Tom");
		v.setCustomNameVisible(true);
		
		// Set as a baby
		v.setBaby();
		// Lock their age
		v.setAgeLock(true);
		// Set their profession
		v.setProfession(Profession.LIBRARIAN);
	}
	
	// Spawn a Wither Skeleton
	public void spawnSKELETON(Player player)
	{
		Skeleton s = (Skeleton) player.getLocation().getWorld().spawn(player.getLocation(), Skeleton.class);
		
		s.setCustomName(ChatColor.AQUA + "9001");
		s.setCustomNameVisible(true);
		// Here we can set what type of skeleton
		s.setSkeletonType(SkeletonType.WITHER);
		// Here we can alter the skeleton's inventory
		s.getEquipment().setItemInHand(new ItemStack(Material.BOAT));
		s.getEquipment().setHelmet(new ItemStack(Material.CACTUS));
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] a) {
		if (cmd.getName().equalsIgnoreCase("test")) {
			Player player = (Player) sender;
			// Your Method
		}
		return false;
	}
}
