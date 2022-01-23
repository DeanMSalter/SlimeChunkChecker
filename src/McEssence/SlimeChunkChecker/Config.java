package McEssence.SlimeChunkChecker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class Config{
    private final Main main;
    public Config(Main mainTemp){
        main = mainTemp;
    }

    public Boolean getEnabled(){
        return main.getConfig().getBoolean("general.enabled");
    }

    public Material GetSlimeCheckItem(){
        try{
            String slimeCheckItemString = main.getConfig().getString("SlimeCheckItem");
            return Material.getMaterial(slimeCheckItemString);
        }catch(Exception e) {
            Bukkit.getLogger().info(ChatColor.RED + "Error when retrieving slime checker item");
            Bukkit.getLogger().info(ChatColor.RED + e.getMessage());
            return Material.BEDROCK;
        }
    }
    public String GetSlimeChunkTrueMessage(){
        return main.getConfig().getString("messages.SlimeChunkTrueMessage");
    }
    public String GetSlimeChunkFalseMessage(){
        return main.getConfig().getString("messages.SlimeChunkFalseMessage");
    }
}
