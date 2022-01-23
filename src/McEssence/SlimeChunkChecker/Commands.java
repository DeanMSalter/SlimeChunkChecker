package McEssence.SlimeChunkChecker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;


public class Commands implements CommandExecutor {
    private final Config config;
    private final Main main;
    Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("SlimeChunkChecker");
    public Commands(Config configTemp, Main mainTemp){
        config = configTemp;
        main = mainTemp;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (args == null || args[0] == null) {
            return false;
        }
        switch(args[0].toUpperCase()) {
            case "RELOAD":
                reload(commandSender, command, label, args);
                break;
            default:
                break;
        }
        return true;
    }

    private Boolean reload(CommandSender commandSender, Command command, String s, String[] args){
        plugin.reloadConfig();
        commandSender.sendMessage("Reload Complete");
        return true;
    }
}

