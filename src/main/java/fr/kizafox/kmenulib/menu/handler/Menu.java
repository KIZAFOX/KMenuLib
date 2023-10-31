package fr.kizafox.kmenulib.menu.handler;

import org.bukkit.event.inventory.InventoryClickEvent;

public interface Menu{

    void setItems();

    void handleClick(final InventoryClickEvent event);

    enum Rows{

        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6);

        private final int rows;

        Rows(int rows) {
            this.rows = rows;
        }

        public int getSlots(){
            return rows * 9;
        }
    }
}
