package test;

import fr.kizafox.kmenulib.menu.page.PaginatedMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class TestMenu extends PaginatedMenu {

    protected final List<ItemStack> items = new ArrayList<>();

    public TestMenu(Player player) {
        super(player);

        for(int i = 0; i < 7 * 7; i++){
            items.add(new ItemStack(Material.GRASS_BLOCK, 64));
        }
    }

    @Override
    public void setItems() {
        this.addMenuBorder();

        if(!items.isEmpty()) {
            for(int i = 0; i < getMaxItemsPerPage(); i++) {
                index = getMaxItemsPerPage() * page + i;
                if(index >= items.size()) break;
                if (items.get(index) != null){

                    inventory.addItem(items.get(index));
                }
            }
        }
    }

    @Override
    public void handleClick(InventoryClickEvent event) {
        this.loadInteractions(event, items);
    }

    @Override
    public String getMenuName() {
        return "My GUI | " + this.getPage();
    }

    @Override
    public int getSlots() {
        return Rows.SIX.getSlots();
    }
}
