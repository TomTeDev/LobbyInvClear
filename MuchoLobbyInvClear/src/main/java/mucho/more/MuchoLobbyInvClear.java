package mucho.more;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MuchoLobbyInvClear extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerEvents(this,new OnJoinEvent());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
}
