package de.Herbystar.CTSNC_Modules.NameTag;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import de.Herbystar.CTSNC.Modules;
import de.Herbystar.CTSNC.Files.Files;
import de.Herbystar.CTSNC_Modules.DisplayName.DisplayName;

public class Main extends JavaPlugin {
		
	public static BukkitTask customtag;
	private int displaynameinterval = Files.config2.getInt("CTSNC.CUSTOM_TAGS.Update");
	public DisplayName d; 
	Modules mod = new Modules();
	
	public void onEnable() {
		startCustomTag();
		if(mod.DisplayNameModule() == true) {
			d = new DisplayName();
		}
	}
	
	public void onDisable() {
		
	}
	
	private void startCustomTag() {
		final CustomTags ct = new CustomTags();
		customtag = new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Player players : Bukkit.getOnlinePlayers()) {
					if(Files.config2.getBoolean("CTSNC.CUSTOM_TAGS.TAG_CLEAR!") == false) {
						if(Files.config2.getBoolean("CTSNC.CUSTOM_TAGS.Enabled") == true) {
							ct.updateCustomTags(players.getScoreboard());
						}
					} else {
						ct.clearTags();
					}
				}
				if(mod.DisplayNameModule() == true) {
					d.setDisplayName();				
				}
			}
		}.runTaskTimer(this, 0, displaynameinterval);
	}

}
