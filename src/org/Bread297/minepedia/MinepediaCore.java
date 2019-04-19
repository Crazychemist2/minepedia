package org.Bread297.minepedia;

import org.bukkit.plugin.java.JavaPlugin;

public class MinepediaCore extends JavaPlugin {
	
	public void onEnable() {
		this.getCommand("getinfo").setExecutor(new GetInfo(this));
	}
	
	public void onDisable() {
		
	}
	
}
