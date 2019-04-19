package org.Bread297.minepedia;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetInfo implements CommandExecutor {
	
	MinepediaCore directPlugin;
	public GetInfo(MinepediaCore passedPlugin) {
		this.directPlugin = passedPlugin;
	}
	
	private final String wikiurl = "https://minecraft.gamepedia.com/index.php?search="; 
	
	@Override
	public boolean onCommand(CommandSender theSender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("getinfo")) {
			if(theSender instanceof Player) {
				Player player = ((Player) theSender).getPlayer();
				if(args.length != 1) {
					player.sendMessage(ChatColor.RED + "Usage: /getinfo <searchterm>");
					return false;
				}
				getInfo(player, args[0]);
			} else {
				return false;
			}
		}
		return true;
	}
	
	private void getInfo(Player player, String searchterm) {
		player.sendMessage(ChatColor.GREEN + "Getting info for " + ChatColor.BOLD + searchterm + ChatColor.RESET + ChatColor.GREEN +  "...");
		String URL = wikiurl + searchterm;
		int status = HttpRequester.makeRequest(URL);
		if(status == 1) {
			player.sendMessage(ChatColor.RED + "Https Request failed! MalformedUrlException!!");
			return;
		}
		if(status == 2) {
			player.sendMessage(ChatColor.RED + "Https Request failed! InputOutputException!!");
			return;
		}
		HTMLParser.getSearchResults();
		return;
	}

}
