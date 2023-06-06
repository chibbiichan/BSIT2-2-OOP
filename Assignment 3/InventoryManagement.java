import java.util.*;
public class InventoryManagement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Razal, Shane Jean A.\nBSIT 2 - 2");
        System.out.println("Inventory Management\n");

        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("1. Add an item to the inventory");
            System.out.println("2. Remove item from inventory");
            System.out.println("3. Checking the quantity of items in the inventory.");
            System.out.println("4. Exit");
            try {
                int choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter the item name: ");
                        String name = in.nextLine();
                        System.out.print("Enter the quantity: ");
                        int quantity = in.nextInt();

                        System.out.println(inventory.addItem(name, quantity));
                        break;
                    case 2:
                        System.out.println("Enter the item to remove.");
                        String itemName = in.nextLine();

                        System.out.println(inventory.removeItem(itemName));
                        break;
                    case 3:
                        System.out.println("Check the quantity of items in inventory\n");
                        inventory.displayItemsInventory();
                        System.out.println("Item's Quantity: "+inventory.getItemsQuantity()+"\n");
                        break;
                    case 4:
                        System.out.println("Thank you for using the Inventory Management.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.\n");
                }

            }catch (Exception e){
                System.out.println("User input was invalid. Please check you inputs and try again.\n");
                in.nextLine();
            }
        }
    }
}

class Item {
    private String name;
    private int quantity;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Inventory{
    private List<Item> items;
    public Inventory(){
        items = new ArrayList<>();
    }

    public String addItem(String name, int quantity) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.setQuantity(item.getQuantity() + quantity);
                return "Item added to the inventory.";
            }
        }

        Item newItem = new Item();
        newItem.setName(name);
        newItem.setQuantity(quantity);
        items.add(newItem);
        return "Item added to the inventory.";
    }

    public String removeItem(String nameOfItem){
        for(Item item : items){
            if (item.getName().equalsIgnoreCase(nameOfItem)){
                items.remove(item);
                return "Item removed from the inventory.\n";
            }
        }
        return "Item doesn't exist in the inventory. Please check your inputs and try again.\n";
    }

    public int getItemsQuantity(){
        return items.size();
    }

    public void displayItemsInventory(){
        System.out.println("Inventory items:");
        System.out.printf("| %-10s | %-8s |%n", "Name", "Quantity");
        System.out.printf("-------------------------%n");
        for (Item i : items) {
            System.out.printf("| %-10s | %-8s |%n",i.getName(),i.getQuantity());
        }
    }
}
