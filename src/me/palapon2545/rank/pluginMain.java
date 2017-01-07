package me.palapon2545.rank;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class pluginMain extends JavaPlugin implements Listener{
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public pluginMain plugin;
	
	LinkedList <String> badWord = new LinkedList<String>();
	
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName()+ " Has Been Disable! ");
		saveConfig();
		Bukkit.broadcastMessage(ChatColor.BLUE + "Rank System is" + ChatColor.RED + ChatColor.BOLD + " disabled.");
		for(Player player1 : Bukkit.getOnlinePlayers()){
			player1.playSound(player1.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 0);
			
		}
	}
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName()+" Version"+ pdfFile.getVersion()+" Has Been Enable! ");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		getConfig().options().copyDefaults(true);
		saveConfig();
		Bukkit.broadcastMessage(ChatColor.BLUE + "Rank System is" + ChatColor.GREEN + ChatColor.BOLD + " enabled.");
		for(Player player1 : Bukkit.getOnlinePlayers()){
			player1.playSound(player1.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
		}

	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args){
		Player player = (Player) sender;
		String playerName = player.getName();
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Rank").getDataFolder(), File.separator + "PlayerDatabase");
        File f = new File(userdata, File.separator + playerName + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
        String rank = playerData.getString("group.group");
		if(CommandLabel.equalsIgnoreCase("rank") || CommandLabel.equalsIgnoreCase("Main:rank")) {
			if (args.length==0 || args.length==1 || args.length>2 || args[0].isEmpty() || args[1].isEmpty()){
				player.sendMessage(ChatColor.BLUE+"Rank> "+ChatColor.GRAY+"Type: /rank [player] [default/staff]");
			}
			if (args.length==2){
				Player player2 = Bukkit.getPlayer(args[0]);
				String playerName2 = player2.getName();
		        File userdata2 = new File(Bukkit.getServer().getPluginManager().getPlugin("Rank").getDataFolder(), File.separator + "PlayerDatabase");
		        File f2 = new File(userdata2, File.separator + playerName + ".yml");
		        FileConfiguration playerData2 = YamlConfiguration.loadConfiguration(f2);
				if (player2.isOnline()) {
					if (args[1].equalsIgnoreCase("default")){
						player2.setPlayerListName(ChatColor.DARK_AQUA+""+ChatColor.BOLD+"Member"+ChatColor.AQUA+playerName2);
						player2.sendMessage(ChatColor.BLUE+"Rank> "+ChatColor.GRAY+"You have been moved to "+ChatColor.YELLOW+args[1]);
						player.sendMessage(ChatColor.BLUE+"Rank> "+ChatColor.GRAY+"You set "+ChatColor.YELLOW+playerName2+ChatColor.GRAY+"'s rank to "+ChatColor.AQUA+args[1]);
						try {
							playerData2.set("group.group", "default");
							playerData2.save(f2);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else if (args[1].equalsIgnoreCase("staff")){
						player2.setPlayerListName(ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"Staff"+ChatColor.LIGHT_PURPLE+playerName2);
						player2.sendMessage(ChatColor.BLUE+"Rank> "+ChatColor.GRAY+"You have been moved to "+ChatColor.YELLOW+args[1]);
						player.sendMessage(ChatColor.BLUE+"Rank> "+ChatColor.GRAY+"You set "+ChatColor.YELLOW+playerName2+ChatColor.GRAY+"'s rank to "+ChatColor.AQUA+args[1]);
						try {
							playerData2.set("group.group", "staff");
							playerData2.save(f2);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else {
						player.sendMessage(ChatColor.BLUE+"Rank> "+ChatColor.GRAY+"Type: /rank [player] [default/staff]");
					}
				}
				else { 
					player.sendMessage(ChatColor.BLUE+"Rank> "+ChatColor.YELLOW+playerName2+ChatColor.GRAY+" player is not online!");
				}
			}
		}
		return true;
	}
	@EventHandler
	public void playerChat(AsyncPlayerChatEvent event) {
		badWord.add("xxx");
		badWord.add("ควย");
		badWord.add("หี");
		badWord.add("สัส");
		badWord.add("พ่อง");
		badWord.add("แม่ง");
		badWord.add("กาก");
		badWord.add("กาก");
		badWord.add("สาส");
		badWord.add("สาส");
		badWord.add("เหี้ย");
		badWord.add("มึง");
		badWord.add("กู");
		badWord.add("เชี่ย");
		badWord.add("เย็ด");
		badWord.add("ไอ่");
		badWord.add("หำ");
		badWord.add("จิ๋ม");
		badWord.add("อีดอกทอง");
		badWord.add("หมอย");
		badWord.add("อี");
		badWord.add("Fuck");
		badWord.add("Kuy");
		badWord.add("Bitch");
		badWord.add("Dick");
		badWord.add("WTF");
		badWord.add("Pussy");
		badWord.add("มิง");
		badWord.add("Stupid");
		badWord.add("สัด");
		badWord.add("ฆวย");
		badWord.add("ฅวย");
		badWord.add("8;p");
		String f0 = event.getMessage().toLowerCase();
		for (int i = 0 ; i < badWord.size() ; i++ ) {
		    f0.replaceAll(badWord.get(i), "ΘΘΘ");
		}
		String message1 = ChatColor.GRAY+": "+ChatColor.WHITE+f0;
	Player player = event.getPlayer(); 
	String playerName = player.getName();
	//UserData
    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Rank").getDataFolder(), File.separator + "PlayerDatabase");
    File f = new File(userdata, File.separator + playerName + ".yml");
    FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
    String rank = playerData.getString("group.group");
		if (rank.equalsIgnoreCase("default")) {
			event.setFormat(ChatColor.DARK_AQUA+""+ChatColor.BOLD+"Member"+ChatColor.BLUE+player.getName()+ChatColor.GRAY+message1);
		} else if(rank.equalsIgnoreCase("staff")) {
			event.setFormat(ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"Staff"+ChatColor.LIGHT_PURPLE+player.getName()+ChatColor.WHITE+message1);
		} else {
			event.setFormat(ChatColor.BLUE+player.getName()+ChatColor.GRAY+message1);
		}
	}
	@EventHandler
	public void JoinServer(PlayerJoinEvent event){
		Player player = event.getPlayer();
		String playerName = player.getName();
		//UserData
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Rank").getDataFolder(), File.separator + "PlayerDatabase");
        File f = new File(userdata, File.separator + playerName + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
        String rank = playerData.getString("group.group");
        if (!f.exists()) {
            try {
            	playerData.createSection("group");
                playerData.set("group.group", "default");
            	playerData.save(f);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        if (rank.equalsIgnoreCase("default")) {
        	player.setPlayerListName(ChatColor.DARK_AQUA+""+ChatColor.BOLD+"Member"+ChatColor.BLUE+player.getName());			
        }
        if (rank.equalsIgnoreCase("staff")) {
        	player.setPlayerListName(ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"Staff"+ChatColor.LIGHT_PURPLE+player.getName());	
        }
        else {
        	player.setPlayerListName(ChatColor.DARK_GRAY+""+ChatColor.BOLD+"???"+ChatColor.GRAY+player.getName());	
        }
        event.setJoinMessage(playerName+ChatColor.YELLOW+" joined the game!");
        }
	@EventHandler
	public void QuitServer(PlayerQuitEvent event){
		Player player = event.getPlayer();
		event.setQuitMessage(player.getName()+ChatColor.YELLOW+" left the game!");
	}
	public void playCircularEffect(Location location, Effect effect, boolean v){
		for(int i = 0; i <= 8; i += ((!v && (i==3)) ? 2 : 1))location.getWorld().playEffect(location, effect, i);
	}
}
