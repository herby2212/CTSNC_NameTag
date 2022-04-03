package de.Herbystar.CTSNC_Modules.NameTag;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;

import de.Herbystar.CTSNC.Main;
import de.Herbystar.CTSNC.ReplaceString;
import de.Herbystar.CTSNC.Files.Files;
import de.Herbystar.CTSNC_Modules.Scoreboard.Scoreboards;
import de.Herbystar.TTA.Utils.TTA_BukkitVersion;

public class CustomTags {
	
	private Scoreboard board;
	public boolean permission_based = Files.config2.getBoolean("CTSNC.CUSTOM_TAGS.PermissionBased");
	public boolean default_op = Files.config2.getBoolean("CTSNC.CUSTOM_TAGS.DefaultOP");
	public boolean allowCollisions = Files.config2.getBoolean("CTSNC.CUSTOM_TAGS.allowCollisions");
	
	private boolean ScoreboardModule() {
		Plugin scoreboard = Bukkit.getPluginManager().getPlugin("CTSNC_Scoreboard");
		if(scoreboard != null) {
			return true;
		}
		return false;
	}
	
	private String check(String prefix, Player player) {
		String checkPrefix = prefix;
		int over = 0;
		int limit;
		if(TTA_BukkitVersion.getVersionAsInt(2) > 113) {
			limit = 64;
		} else {
			limit = 16;
		}
		if(checkPrefix.length() > limit) {
			over = checkPrefix.length() - limit;
			Bukkit.getConsoleSender().sendMessage("§cYour Prefix: " + prefix + " §cIs §f" + over + " §ccharacters to long!");
			if(Files.config2.getBoolean("CTSNC.CUSTOM_TAGS.PrefixShortener") == true) {
				prefix = prefix.substring(0, limit);
			}
		}
		return prefix;
	}
	
	public void setPrefix(Team team, String teamName, String prefix, Player player) {
		if(team == null) {
			team = board.registerNewTeam(teamName);
			String modifiedPrefix = ReplaceString.replaceString(prefix, player);
			if(TTA_BukkitVersion.getVersionAsInt(2) > 113) {
				ChatColor c = getChatColorFromString(modifiedPrefix);
				if(c != null) {
					team.setColor(c);
				}
			}
			team.setPrefix(check(modifiedPrefix, player));
		}
		
		if(!Main.instance.getServerVersion().equalsIgnoreCase("v1_8_R1.") &&
				!Main.instance.getServerVersion().equalsIgnoreCase("v1_8_R2.") &&
				!Main.instance.getServerVersion().equalsIgnoreCase("v1_8_R3.") &&
				!Main.instance.getServerVersion().equalsIgnoreCase("v1_9_R1.") &&
				!Main.instance.getServerVersion().equalsIgnoreCase("v1_7_R4.")) {
			team.setOption(Option.COLLISION_RULE, allowCollisions ? OptionStatus.ALWAYS : OptionStatus.NEVER);
		}
	}
	
	public void updatePrefix(Team team, String prefix, Player player) {
		if(team == null) {
			return;
		}
		String modifiedPrefix = ReplaceString.replaceString(prefix, player);
		team.setPrefix(check(modifiedPrefix, player));
		if(TTA_BukkitVersion.getVersionAsInt(2) > 113) {
			ChatColor c = getChatColorFromString(modifiedPrefix);
			if(c != null) {
				team.setColor(c);
			}
		}
	}
	
	private ChatColor getChatColorFromString(String input) {
		int index = input.lastIndexOf("§");
//		Bukkit.getConsoleSender().sendMessage("Index: " + index + " - prefix: " + input + " - colorChar: " + input.charAt(index+1));
		return ChatColor.getByChar(input.charAt(index+1));
	}
		
	public void setCustomTags(Player player) {
        Files.config2 = YamlConfiguration.loadConfiguration(Files.f2);
        
		this.board = player.getScoreboard();
		if(board == null) {
			if(ScoreboardModule() == true) {
				new Scoreboards(player);
			} else {
				board = Bukkit.getScoreboardManager().getNewScoreboard();
			}
		}
		
		Team one = board.getTeam("00001one");
		this.setPrefix(one, "00001one", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag1.Name"), player);	

        Team two = board.getTeam("00002two");
        this.setPrefix(two, "00002two", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag2.Name"), player);        

        Team three = board.getTeam("00003three");
        this.setPrefix(three, "00003three", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag3.Name"), player);        

        Team four = board.getTeam("00004four");
        this.setPrefix(four, "00004four", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag4.Name"), player);
        
        Team five = board.getTeam("00005five");
        this.setPrefix(five, "00005five", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag5.Name"), player);
        
        Team six = board.getTeam("00006six");
        this.setPrefix(six, "00006six", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag6.Name"), player);
        
        Team seven = board.getTeam("00007seven");
        this.setPrefix(seven, "00007seven", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag7.Name"), player);
        
        Team eight = board.getTeam("00008eight");
        this.setPrefix(eight, "00008eight", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag8.Name"), player);
        
        Team nine = board.getTeam("00009nine");
        this.setPrefix(nine, "00009nine", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag9.Name"), player);        

        Team ten = board.getTeam("00010ten");
        this.setPrefix(ten, "00010ten", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag10.Name"), player);
        
        Team eleven = board.getTeam("00011eleven");
        this.setPrefix(eleven, "00011eleven", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag11.Name"), player);       

        Team twelve = board.getTeam("00012twelve");
        this.setPrefix(twelve, "00012twelve", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag12.Name"), player);
        
        Team thirteen = board.getTeam("00013thirteen");
        this.setPrefix(thirteen, "00013thirteen", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag13.Name"), player);
        
        Team fourteen = board.getTeam("00014fourteen");
        this.setPrefix(fourteen, "00014fourteen", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag14.Name"), player);
        
        Team fifteen = board.getTeam("00015fifteen");
        this.setPrefix(fifteen, "00015fifteen", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag15.Name"), player);
        
        Team sixteen = board.getTeam("00016sixteen");
        this.setPrefix(sixteen, "00016sixteen", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag16.Name"), player);
     
        Team seventeen = board.getTeam("00017seventeen");
        this.setPrefix(seventeen, "00017seventeen", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag17.Name"), player);       

        Team eighteen = board.getTeam("00018eighteen");
        this.setPrefix(eighteen, "00018eighteen", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag18.Name"), player);
        
        Team nineteen = board.getTeam("00019nineteen");
        this.setPrefix(nineteen, "00019nineteen", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag19.Name"), player);
        
        Team twenty = board.getTeam("00020twenty");
        this.setPrefix(twenty, "00020twenty", Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag20.Name"), player);       

        Team op = board.getTeam("00000op");
        this.setPrefix(op, "00000op", Files.config2.getString("CTSNC.CUSTOM_TAGS.OP.Name"), player);
	}
	
	public void resetTags(String tagname) {
		Team team = Bukkit.getScoreboardManager().getMainScoreboard().getTeam(tagname);
		if(team != null) {
			team.unregister();
		}
	}
	
	public void clearTags() {
		for(Player players : Bukkit.getOnlinePlayers()) {
			board = players.getScoreboard();
			if(board == null) {
				return;
			}
			this.resetTags("00001one");
			this.resetTags("00002two");
			this.resetTags("00003three");
			this.resetTags("00004four");
			this.resetTags("00005five");
			this.resetTags("00006six");
			this.resetTags("00007seven");
			this.resetTags("00008eight");
			this.resetTags("00009nine");
			this.resetTags("00010ten");
			this.resetTags("00011eleven");
			this.resetTags("00012twelve");
			this.resetTags("00013thirteen");
			this.resetTags("00014fourteen");
			this.resetTags("00015fifteen");
			this.resetTags("00016sixteen");
			this.resetTags("00017seventeen");
			this.resetTags("00018eighteen");
			this.resetTags("00019nineteen");
			this.resetTags("00020twenty");
			this.resetTags("00000op");
		}
	}
	
	public void updateCustomTags(Scoreboard board) {
        Files.config2 = YamlConfiguration.loadConfiguration(Files.f2);
        Files.config7 = YamlConfiguration.loadConfiguration(Files.f7);

		Team op = board.getTeam("00000op");
		//updatePrefix(op, Files.config2.getString("CTSNC.CUSTOM_TAGS.OP.Name"), player);
		Team one = board.getTeam("00001one");
		//updatePrefix(one, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag1.Name"), player);
		Team two = board.getTeam("00002two");
		//updatePrefix(two, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag2.Name"), player);
		Team three = board.getTeam("00003three");
		//updatePrefix(three, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag3.Name"), player);
		Team four = board.getTeam("00004four");
		//updatePrefix(four, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag4.Name"), player);
		Team five = board.getTeam("00005five");
		//updatePrefix(five, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag5.Name"), player);
		Team six = board.getTeam("00006six");
		//updatePrefix(six, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag6.Name"), player);
		Team seven = board.getTeam("00007seven");
		//updatePrefix(seven, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag7.Name"), player);
		Team eight = board.getTeam("00008eight");
		//updatePrefix(eight, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag8.Name"), player);
		Team nine = board.getTeam("00009nine");
		//updatePrefix(nine, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag9.Name"), player);
		Team ten = board.getTeam("00010ten");
		//updatePrefix(ten, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag10.Name"), player);
		Team eleven = board.getTeam("00011eleven");
		//updatePrefix(eleven, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag11.Name"), player);
		Team twelve = board.getTeam("00012twelve");
		//updatePrefix(twelve, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag12.Name"), player);
		Team thirteen = board.getTeam("00013thirteen");
		//updatePrefix(thirteen, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag13.Name"), player);
		Team fourteen = board.getTeam("00014fourteen");
		//updatePrefix(fourteen, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag14.Name"), player);
		Team fifteen = board.getTeam("00015fifteen");
		//updatePrefix(fifteen, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag15.Name"), player);
		Team sixteen = board.getTeam("00016sixteen");
		//updatePrefix(sixteen, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag16.Name"), player);
		Team seventeen = board.getTeam("00017seventeen");
		//updatePrefix(seventeen, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag17.Name"), player);
		Team eighteen = board.getTeam("00018eighteen");
		//updatePrefix(eighteen, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag18.Name"), player);
		Team nineteen = board.getTeam("00019nineteen");
		//updatePrefix(nineteen, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag19.Name"), player);
		Team twenty = board.getTeam("00020twenty");
		//updatePrefix(twenty, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag20.Name"), player);
		
		if(op == null | one == null | two == null | three == null | four == null | five == null | six == null | seven == null | eight == null | nine == null | ten == null | 
				eleven == null | twelve == null | thirteen == null | fourteen == null | fifteen == null | sixteen == null | seventeen == null | eighteen == null | nineteen == null | twenty == null) {
//			this.setCustomTags(player);
		}

        
		for(Player players : Bukkit.getOnlinePlayers()) {				
//			Player p1 = (Player) Bukkit.getOfflinePlayer(players.getUniqueId());
			UUID uuid = players.getUniqueId(); //UUID uuid = p1.getUniqueId(); => Gewechselt mit online player um Fehler mit FakePlayers zu vermeiden!
			int tag = Files.config7.getInt("CTSNC.CustomTag." + uuid.toString());
			int tag_name = Files.config7.getInt("CTSNC.CustomTag." + players.getName());

	        if(Files.config2.getBoolean("CTSNC.CUSTOM_TAGS.Enabled") == false) {
	        	return;
	        }
	        
    		if(players.isOp() && op != null && this.default_op == true) {
    			if(!op.getEntries().contains(players.getName())) {
            		op.addEntry(players.getName());
            		continue;
    			}
        	} else {
        		updateTag(one, tag, tag_name, 1, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag1.Permission"), players);
        		updateTag(two, tag, tag_name, 2, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag2.Permission"), players);
        		updateTag(three, tag, tag_name, 3, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag3.Permission"), players);
        		updateTag(four, tag, tag_name, 4, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag4.Permission"), players);
        		updateTag(five, tag, tag_name, 5, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag5.Permission"), players);
        		updateTag(six, tag, tag_name, 6, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag6.Permission"), players);
        		updateTag(seven, tag, tag_name, 7, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag7.Permission"), players);
        		updateTag(eight, tag, tag_name, 8, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag8.Permission"), players);
        		updateTag(nine, tag, tag_name, 9, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag9.Permission"), players);
        		updateTag(ten, tag, tag_name, 10, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag10.Permission"), players);
        		updateTag(eleven, tag, tag_name, 11, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag11.Permission"), players);
        		updateTag(twelve, tag, tag_name, 12, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag12.Permission"), players);
        		updateTag(thirteen, tag, tag_name, 13, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag13.Permission"), players);
        		updateTag(fourteen, tag, tag_name, 14, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag14.Permission"), players);
        		updateTag(fifteen, tag, tag_name, 15, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag15.Permission"), players);
        		updateTag(sixteen, tag, tag_name, 16, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag16.Permission"), players);
        		updateTag(seventeen, tag, tag_name, 17, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag17.Permission"), players);
        		updateTag(eighteen, tag, tag_name, 18, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag18.Permission"), players);
        		updateTag(nineteen, tag, tag_name, 19, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag19.Permission"), players);
        		updateTag(twenty, tag, tag_name, 20, Files.config2.getString("CTSNC.CUSTOM_TAGS.Tag20.Permission"), players);       		
        	}
		}
	}
	
	
	public void updateTag(Team team, int tag, int tag_name, int tagNumber, String permission, Player players) {
		if(team != null) {
			if(this.permission_based == true) {
				if(players.hasPermission(permission)) {
					if(!team.getEntries().contains(players.getName())) {
						team.addEntry(players.getName());
					}
				}
			} else {
				if(tag == tagNumber | tag_name == tagNumber) {
					if(!team.getEntries().contains(players.getName())) {
						team.addEntry(players.getName());
					}
				}
			}
		}
	}
}
