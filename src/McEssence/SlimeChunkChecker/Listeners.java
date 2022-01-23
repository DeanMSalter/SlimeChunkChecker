package McEssence.SlimeChunkChecker;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Listeners implements Listener {
    private final Config config;

    public Listeners(Config configTemp){
        config = configTemp;
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = false)
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR)){
            Player player = event.getPlayer();
            if (player.hasPermission("SlimeChunkChecker.check")) {
                if (config.GetSlimeCheckItem() == player.getInventory().getItemInMainHand().getType()) {
                    Boolean isSlimeChunk = player.getLocation().getChunk().isSlimeChunk();
                    if (isSlimeChunk) {
                        player.sendMessage(config.GetSlimeChunkTrueMessage());
                    } else {
                        player.sendMessage(config.GetSlimeChunkFalseMessage());
                    }
                }
            }
        }
    }
}
