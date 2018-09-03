package net.mcdecimation.decimationstaff;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
    static File getDataFolder = new File("/plugins/");
    static File config_yml = new File(getDataFolder, "config.yml");
    static YamlConfiguration config = YamlConfiguration.loadConfiguration(config_yml);
	
    @Override
    public void onEnable() {
    	
    	
      
        reload();

          
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
      

        System.out.println("Plugin Enabled");
      
    }
      
     public static void reload() {
        
         if(!getDataFolder.exists()) {
             getDataFolder.mkdir();
         }
        
         if(!config_yml.exists()) {
              try {
             config_yml.createNewFile();
             config.addDefault("subCommand1", true);
             config.addDefault("subCommand2", true);
             config.addDefault("subCommand1info", true);
             config.addDefault("subCommand2info", true);
             config.addDefault("subCommand1title", true);
             config.addDefault("subCommand1line1", true);
             config.addDefault("subCommand1line2", true);
             config.addDefault("subCommand2title", true);
             config.addDefault("subCommand2line1", true);
             config.addDefault("subCommand2line2", true);
             config.addDefault("reloadsubCommand", true);
             config.addDefault("reloadPermission", true);
             config.addDefault("reloadOutputSuccess", true);

              }
              catch (IOException e) {
                  e.printStackTrace();
            
              }
        
    
         }
     }
    
     public static void save() {
         try {
         config.save(config_yml);
         } catch (IOException e) {
             e.printStackTrace();
         }
         }
    

        


    @Override
    public void onDisable() {
      
        System.out.println("Plugin Disabled");
      

            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
  
}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("help")) {
				if(args.length == 0) {
					p.sendMessage(" ");
					p.sendMessage(" ");
					p.sendMessage(" ");
					p.sendMessage("§7§m----§r §cHelp §7§m----§r");
					p.sendMessage(" ");
					p.sendMessage("§7- /help §c§l§o" + getConfig().get("subCommand1") + " " + getConfig().get("subCommand1info"));
					p.sendMessage("§7- /help §c§l§o" + getConfig().get("subCommand2") + " " + getConfig().get("subCommand2info"));
					p.sendMessage(" ");
					p.sendMessage("§7§m-------------------------");
					p.sendMessage(" ");
					p.sendMessage(" ");
					p.sendMessage(" ");
				}else if(args.length == 1) {
					if(args[0].equalsIgnoreCase((String) getConfig().get("subCommand1"))){
						p.sendMessage(" ");
						p.sendMessage(" ");
						p.sendMessage(" ");
						p.sendMessage("§7§m----§r " + getConfig().get("subCommand1title") + " §7§m----§r");
						p.sendMessage(" ");
						p.sendMessage("§7- " + getConfig().get("subCommand1line1" + ""));
						p.sendMessage("§7- " + getConfig().get("subCommand1line2" + ""));
                        p.sendMessage(" ");
						p.sendMessage("§7§m-------------------------");
						p.sendMessage(" ");
						p.sendMessage(" ");
						p.sendMessage(" ");
					}else if(args[0].equalsIgnoreCase((String) getConfig().get("subCommand2"))){
						p.sendMessage(" ");
						p.sendMessage(" ");
						p.sendMessage(" ");
						p.sendMessage("§7§m----§r " + getConfig().get("subCommand2title") + " §7§m----§r");
						p.sendMessage(" ");
						p.sendMessage("§7- " + getConfig().get("subCommand2line1" + ""));
						p.sendMessage("§7- " + getConfig().get("subCommand2line2" + ""));
						p.sendMessage(" ");
						p.sendMessage("§7§m-------------------------");
						p.sendMessage(" ");
						p.sendMessage(" ");
						p.sendMessage(" ");
					}else if(args[0].equalsIgnoreCase((String) getConfig().get("reloadsubCommand"))){
						if(sender.hasPermission((String) getConfig().get("reloadPermission"))) {
							reloadConfig();
							p.sendMessage(" ");
							p.sendMessage(" ");
							p.sendMessage(" ");
							p.sendMessage((String) getConfig().get("reloadOutputSuccess"));
							p.sendMessage(" ");
							p.sendMessage(" ");
							p.sendMessage(" ");
						}
						
					}
				}
			}
		}else Bukkit.getConsoleSender().sendMessage("§4You can only use this command as a player.");
		return true;
	}
}
