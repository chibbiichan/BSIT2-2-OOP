import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class InventoryManagement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Inventory Management\n");

        // Empty inventory to store and manage items
        Inventory inventory = new Inventory();

        // Keep asking the user for input until they choose the exit.
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add an item to the inventory");
            System.out.println("2. Remove item from inventory");
            System.out.println("3. Checking the quantity of items in the inventory.");
            System.out.println("4. Exit");

            try {
                int choice = in.nextInt();
                in.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the item name: ");
                        String name = in.nextLine();
                        System.out.print("Enter the quantity: ");
                        int quantity = in.nextInt();
                        in.nextLine(); // Consume the newline character

                        // Create a new item and add it to the inventory
                        Item item = new Item(name, quantity);
                        inventory.addItem(item);

                        System.out.println("Item added to the inventory.\n");
                        break;
                    case 2:
                        //Remove item from inventory.
                        System.out.println("Enter the item to remove.");
                        String itemName = in.nextLine();

                        //Check if the item exist in the inventory.
                        if(inventory.removeItem(itemName)){
                            System.out.println("Item was removed successfully.\n");
                        }else{
                            System.out.println("Item doesn't exist in the inventory. Please check your inputs and try again.\n");
                        }

                        break;

                    case 3:
                        // Display items and items quantity
                        System.out.println("Check the quantity of items in inventory\n");
                        inventory.displayItemsInventory();
                        int itemQuantity = inventory.getItemsQuantity();
                        System.out.println("Item's Quantity: "+itemQuantity+"\n");
                        break;
                    case 4:
                        // The program stop.
                        exit = true;
                        break;
                    default:
                        //Default statement if the user input doesn't exist in the choices.
                        System.out.println("Invalid choice. Please try again.\n");
                }
             // The program throw an exception if the user input was invalid and continue asking.
            }catch (Exception e){
                System.out.println("User input was invalid. Please check you inputs and try again.\n");
                in.nextLine();
            }
        }
        System.out.println("Thank you for using the Inventory Management.");
    }
}

// Each item input by the user is represented by the Item class.
class Item {
    private String name;
    private int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
}
//Inventory class is where the items are manage.
class Inventory{
    private List<Item> items;
    public Inventory(){
        items = new ArrayList<>();
    }
    // Insert new item to the inventory.
    public void addItem(Item item) {
        items.add(item);
    }

    /* Remove item from inventory. If the removedItem() return true the item will removed and print success message,
     else the method will return false and print error message.
    */
    public boolean removeItem(String nameOfItem){
        for(Item item : items){
            if (item.getName().equalsIgnoreCase(nameOfItem)){
               items.remove(item);
               return true;
            }
        }
        return false;
    }
    //Get the quantity of the items in inventory.
    public int getItemsQuantity(){
        return items.size();
    }

    // Display the items in the inventory and its quantity.
    public void displayItemsInventory(){
        System.out.println("Inventory items:");
        System.out.printf("| %-10s | %-8s |%n", "Name", "Quantity");
        System.out.printf("-------------------------%n");
        for (Item i : items) {
            System.out.printf("| %-10s | %-8s |%n",i.getName(),i.getQuantity());
        }
    }
}
