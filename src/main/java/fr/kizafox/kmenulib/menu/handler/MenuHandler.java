package fr.kizafox.kmenulib.menu.handler;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class MenuHandler implements Menu, InventoryHolder {

    protected final Player player;
    protected final ItemStack FILLER_GLASS = this.createItem(Material.GRAY_STAINED_GLASS_PANE, " ", null);

    protected Inventory inventory;

    public MenuHandler(Player player) {
        this.player = player;
    }

    public abstract String getMenuName();

    public abstract int getSlots();

    public void open() {
        inventory = Bukkit.createInventory(this, this.getSlots(), this.getMenuName());

        this.setItems();

        player.openInventory(this.inventory);
    }

    public void setFillerGlass(){
        for(int i = 0; i < this.getSlots(); i++){
            if(this.inventory.getItem(i) == null) this.inventory.setItem(i, this.FILLER_GLASS);
        }
    }

    public ItemStack createItem(final Material material, final String name, final List<String> lore){
        final ItemStack itemStack = new ItemStack(material);
        final ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    @Override
    public @Nonnull Inventory getInventory() {
        return this.inventory;
    }
}
