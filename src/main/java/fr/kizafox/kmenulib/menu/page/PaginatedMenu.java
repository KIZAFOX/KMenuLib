package fr.kizafox.kmenulib.menu.page;

import fr.kizafox.kmenulib.menu.handler.MenuHandler;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public abstract class PaginatedMenu extends MenuHandler {

    protected int
            page = 0,
            maxItemsPerPage = 28,
            index = 0;

    protected final String
            PREVIOUS_PAGE = ChatColor.GREEN + "" +  ChatColor.BOLD + "Previous page",
            CLOSE = ChatColor.DARK_RED + "" +  ChatColor.BOLD + "Close",
            NEXT_PAGE = ChatColor.GREEN + "" +  ChatColor.BOLD + "Next page";

    public PaginatedMenu(Player player) {
        super(player);
    }

    public void addMenuBorder(){
        inventory.setItem(48, this.createItem(Material.MAGMA_CREAM, this.PREVIOUS_PAGE, null));
        inventory.setItem(49, this.createItem(Material.BARRIER, this.CLOSE, null));
        inventory.setItem(50, this.createItem(Material.SLIME_BALL, this.NEXT_PAGE, null));

        for (int i = 0; i < 10; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.FILLER_GLASS);
            }
        }

        inventory.setItem(17, super.FILLER_GLASS);
        inventory.setItem(18, super.FILLER_GLASS);
        inventory.setItem(26, super.FILLER_GLASS);
        inventory.setItem(27, super.FILLER_GLASS);
        inventory.setItem(35, super.FILLER_GLASS);
        inventory.setItem(36, super.FILLER_GLASS);

        for (int i = 44; i < 54; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.FILLER_GLASS);
            }
        }
    }

    public void loadInteractions(final InventoryClickEvent event, List<?> list){
        final ItemStack itemStack = event.getCurrentItem();
        final Material material = itemStack.getType();
        final ItemMeta itemMeta = itemStack.getItemMeta();

        final Player player = (Player) event.getWhoClicked();

        if(material.equals(Material.MAGMA_CREAM) && itemMeta.getDisplayName().equals(this.PREVIOUS_PAGE)){
            if(this.page == 0){
                player.sendMessage(ChatColor.RED + "You are already on the first page.");
            }else{
                this.page = page - 1;
                super.open();
            }
        }else if(material.equals(Material.BARRIER) && itemMeta.getDisplayName().equals(this.CLOSE)){
            player.closeInventory();
        }else if(material.equals(Material.SLIME_BALL) && itemMeta.getDisplayName().equals(this.NEXT_PAGE)){
            if(!((this.index + 1) >= list.size())){
                this.page = page + 1;
                super.open();
            }else{
                player.sendMessage(ChatColor.RED + "You are already on the last page.");
            }
        }
    }

    public int getPage() {
        return page;
    }

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }

    public int getIndex() {
        return index;
    }
}
