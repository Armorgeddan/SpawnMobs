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
	public void spawnCow(Player player) {
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

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] a) {
		if (cmd.getName().equalsIgnoreCase("test")) {
			Player player = (Player) sender;
			spawnCow(player);
		}
		return false;
	}
}
