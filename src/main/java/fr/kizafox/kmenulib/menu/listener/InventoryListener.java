package fr.kizafox.kmenulib.menu.listener;

import fr.kizafox.kmenulib.menu.handler.Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler (priority = EventPriority.MONITOR)
    public void onInventoryClick(final InventoryClickEvent event){
        if(!(event.getInventory().getHolder() instanceof final Menu menu)) return;
        if(event.getCurrentItem() == null) return;

        event.setCancelled(true);

        menu.handleClick(event);
    }
}
