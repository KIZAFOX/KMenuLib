# KMenuLib

> A simple-to-use library to manage your project menus

<!-- TOC -->

* [KMenuLib](#kmenulib)
    * [**Example for paginated menu**](#example-for-paginated-menu)
<!-- TOC -->

---

## **Example for paginated menu**

Here is an example to create a **menu with pages**:

```java 
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

```

To open the menu just do:

```java
new TestMenu(player).open();
```

---

**_Status projet:_**

_END!_

By _[@KIZAFOX](https://twitter.com/KIZAFOX)_.