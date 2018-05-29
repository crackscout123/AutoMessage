/**
 * 
 */
package me.joe_.autoMSG.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoMSG extends JavaPlugin {
	
	public File file = new File("plugins/AutoMessage", "lang.yml");
	public FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	public static int x = 150; 
	
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		System.out.println("§8[§2§lAUtoMSG§r§8] §aACTIV");
		setupLang();
		final String msg1 = cfg.getString("Messages.one").replace("&", "§");
		final String msg2 = cfg.getString("Messages.two").replace("&", "§");
		final String msg3 = cfg.getString("Messages.three").replace("&", "§");
		final String msg4 = cfg.getString("Messages.four").replace("&", "§");
		final String msg5 = cfg.getString("Messages.five").replace("&", "§");
		
		getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				AutoMSG.x -= 1;
				if(AutoMSG.x == 120) {
					Bukkit.broadcastMessage(msg1);
				}
				if(AutoMSG.x == 90) {
					Bukkit.broadcastMessage(msg2);
				}
				if(AutoMSG.x == 60) {
					Bukkit.broadcastMessage(msg3);
				}
				if(AutoMSG.x == 30) {
					Bukkit.broadcastMessage(msg4);
				}
				if(AutoMSG.x == 0) {
					Bukkit.broadcastMessage(msg5);
					AutoMSG.x = 150;
				}
				
			}
		}, 40L, 40L);
	}
	@Override
	public void onDisable() {
		System.out.println("§8[§2§lAUtoMSG§r§8] §cDEACTIV");
	}

	public void setupLang() {
		try {
			cfg.load(file);
		} catch (IOException | InvalidConfigurationException e1) {
			System.err.println(e1.getCause());
		}
		if(!this.file.exists()) {
			cfg.set("Messages.one", "&2&lINFO &9- &6Need help? Execute &c/help");
			cfg.set("Messages.two", "&2&lINFO &9- &6Visit our website at &chttp://your-server.com/");
			cfg.set("Messages.three", "&2&lINFO &9- &6Have fun while playing on &c&lYOUR-SERVER!");
			cfg.set("Messages.four", "&2&lINFO &9- &6Have some questions? Contact the Support &c/stuff");
			cfg.set("Messages.five", "&2&lINFO &9- &6Buy premium at §chttp://vip.your-server.com/");
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}


/**
* @author JOE_
*
* @created 29.05.2018 (17:45:26)
*/
