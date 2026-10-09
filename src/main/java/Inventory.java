import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> inventory;

    public Inventory(){
        this.inventory = new ArrayList<>();
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item){
        inventory.add(item);
    }

    public void removeItem(Item item){
        inventory.remove(item);
    }

    public boolean containsItem(Item item){
        return inventory.contains(item);
    }

    public void viewInventory(){
        System.out.print("Inventory: ");
        int i = 1;
        for(Item item: this.inventory){
            System.out.print(i++ + "." + item.getName() + ", ");

        }
        System.out.println();
    }

}
