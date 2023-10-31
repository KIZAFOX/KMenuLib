package fr.kizafox.kmenulib;

import fr.kizafox.kmenulib.menu.listener.InventoryListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class KMenuLib {

    public static void initialize(final JavaPlugin plugin){
        plugin.getServer().getPluginManager().registerEvents(new InventoryListener(), plugin);
    }
}
