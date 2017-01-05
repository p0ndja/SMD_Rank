package me.palapon2545.rank;

import java.io.File;
import java.io.IOException;
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
		String f0 = event.getMessage().toLowerCase();
		String f1 = f0.replaceAll("ควย", "§4§mΘΘΘ§r");
		String f2 = f1.replaceAll("หี", "§4§mΘΘ§r");
		String f3 = f2.replaceAll("สัส", "§4§mΘΘΘ§r");
		String f4 = f3.replaceAll("พ่อง", "§4§mΘΘΘΘ§r");
		String f5 = f4.replaceAll("แม่ง", "§4§mΘΘΘΘ§r");
		String f6 = f5.replaceAll("กาก", "§4§mΘΘΘ§r");
		String f7 = f6.replaceAll("กาก", "§4§mΘΘΘ§r");
		String f8 = f7.replaceAll("สาส", "§4§mΘΘΘ§r");
		String f9 = f8.replaceAll("สาส", "§4§mΘΘΘ§r");
		String f10 = f9.replaceAll("เหี้ย", "§4§mΘΘΘΘ§r");
		String f11 = f10.replaceAll("มึง", "§4§mΘΘΘ§r");
		String f12 = f11.replaceAll("กู", "§4§mΘΘ§r");
		String f13 = f12.replaceAll("เชี่ย", "§4§mΘΘΘΘΘ§r");
		String f14 = f13.replaceAll("เย็ด", "§4§mΘΘΘΘ§r");
		String f15 = f14.replaceAll("ไอ่", "§4§mΘΘΘ§r");
		String f16 = f15.replaceAll("หำ", "§4§mΘΘΘ§r");
		String f17 = f16.replaceAll("จิ๋ม", "§4§mΘΘΘΘ§r");
		String f18 = f17.replaceAll("อีดอกทอง", "§4§mΘΘΘΘΘΘΘΘ§r");
		String f19 = f18.replaceAll("หมอย", "§4§mΘΘΘΘ§r");
		String f20 = f19.replaceAll("อี", "§4§mΘΘ§r");
		String f21 = f20.replaceAll("Fuck", "§4§mΘΘΘΘ§r");
		String f22 = f21.replaceAll("Kuy", "§4§mΘΘΘ§r");
		String f23 = f22.replaceAll("Bitch", "§4§mΘΘΘΘ§r");
		String f24 = f23.replaceAll("Dick", "§4§mΘΘΘΘ§r");
		String f25 = f24.replaceAll("WTF", "§4§mΘΘΘ§r");
		String f26 = f25.replaceAll("Pussy", "§4§mΘΘΘΘΘ§r");
		String f27 = f26.replaceAll("มิง", "§4§mΘΘΘ§r");
		String f28 = f27.replaceAll("Stupid", "§4§mΘΘΘΘΘΘ§r");
		String f29 = f28.replaceAll("สัด", "§4§mΘΘΘ§r");
		String f30 = f29.replaceAll("ฆวย", "§4§mΘΘΘ§r");
		String f31 = f30.replaceAll("ฅวย", "§4§mΘΘΘ§r");
		String f32 = f31.replaceAll("8;p", "§4§mΘΘΘ§r");
			String message1 = ChatColor.GRAY+": "+ChatColor.WHITE+f32; 
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
