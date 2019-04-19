package org.Bread297.minepedia;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MinepediaCore extends JavaPlugin {
	
	public static final String dataFolderPath = "\\plugins\\Minepedia";
	
	@Override
	public void onEnable() {
		//ceeate folder mineopedia ;:)
			Bukkit.getServer().getPluginManager().getPlugin("Minepedia").getDataFolder().mkdir();
		this.getCommand("getinfo").setExecutor(new GetInfo(this));
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
