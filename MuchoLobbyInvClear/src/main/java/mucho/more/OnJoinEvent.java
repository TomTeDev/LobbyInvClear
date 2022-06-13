package mucho.more;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class OnJoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        ItemStack[] is = p.getInventory().getStorageContents();

        for(int x = 0;x<is.length;x++){
            if(is[x]!=null){
                is[x] = null;
            }
        }
        final ItemStack[]fis = is;
        Bukkit.getScheduler().scheduleSyncDelayedTask(MuchoLobbyInvClear.getPlugin(MuchoLobbyInvClear.class), new Runnable() {
            @Override
            public void run() {
                if(!p.isOnline())return;
                p.getInventory().setStorageContents(fis);
            }
        },5);

    }
}
