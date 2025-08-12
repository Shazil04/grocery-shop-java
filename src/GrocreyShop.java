import java.util.*;


class Item {              //class item
    private String name;
    private float price;
    private int quantity;

    public Item(String name, float price, int quantity) {     //constructor
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    
    public String getName() {                              //name getter
        return name; 
    }
    public float getPrice() {                            //price getter
        return price; 
    }
    public int getQuantity() {                          //quantity getter
         return quantity; 
    }
}

class Inventory {                               //class inventory
    private List<Item> itemList;

    public Inventory() {                             //constructor
        itemList = new ArrayList<>();

        itemList.add(new Item("Apple", 150.0f, 50));
        itemList.add(new Item("Banana", 60.0f, 100));
        itemList.add(new Item("Mango", 200.0f, 40));
        itemList.add(new Item("Milk", 180.0f, 30));
        itemList.add(new Item("Bread", 120.0f, 25));
        itemList.add(new Item("Eggs (Dozen)", 250.0f, 20));
        itemList.add(new Item("Rice (1kg)", 300.0f, 15));
        itemList.add(new Item("Sugar (1kg)", 180.0f, 20));
        itemList.add(new Item("Flour (1kg)", 160.0f, 25));
        itemList.add(new Item("Tea Pack", 500.0f, 10));
        itemList.add(new Item("Coffee Jar", 800.0f, 8));
        itemList.add(new Item("Salt (1kg)", 50.0f, 30));
        itemList.add(new Item("Cooking Oil (1L)", 550.0f, 12));
        itemList.add(new Item("Butter", 400.0f, 10));
        itemList.add(new Item("Cheese", 500.0f, 8));
        itemList.add(new Item("Chicken (1kg)", 700.0f, 15));
        itemList.add(new Item("Beef (1kg)", 900.0f, 10));
        itemList.add(new Item("Fish (1kg)", 1200.0f, 6));
        itemList.add(new Item("Onion (1kg)", 100.0f, 20));
        itemList.add(new Item("Potato (1kg)", 80.0f, 25));
        itemList.add(new Item("Tomato (1kg)", 120.0f, 18));
        itemList.add(new Item("Carrot (1kg)", 140.0f, 15));
        itemList.add(new Item("Cucumber (1kg)", 130.0f, 12));
        itemList.add(new Item("Soft Drink", 120.0f, 20));
        itemList.add(new Item("Chips Pack", 60.0f, 30));
    }

    public void addItem(Item item) {               //add item method
        itemList.add(item);
    }

    public List<Item> getItems() {                //get whole items item method
        return itemList;
    }
    public Item getItemByName(String name){      //get ingle item from whole list
        for (Item item : itemList){
            if(item.getName().equalsIgnoreCase(name)){
                return item;
            }
        }
        return null;                          //not found;
    }
}




class CartItem{              //class Cart item
    private String name;
    private float price;
    private int quantity;

    public CartItem(String name, float price, int quantity) {     //constructor
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    
    public String getName() {                              //name getter
        return name; 
    }
    public float getPrice() {                            //price getter
        return price; 
    }
    public int getQuantity() {                          //quantity getter
         return quantity; 
    }


    public void setName(String name) {                              //name setter
        this.name =  name; 
    }
    public void settPrice(float price) {                            //price setter
        this.price = price; 
    }
    public void setQuantity(int quantity) {                          //quantity setter
        this.quantity = quantity;
    }
}

class CartInventory {                               //class inventory
    private List<CartItem> CartItemList;

    public CartInventory() {                             //constructor
        CartItemList = new ArrayList<>();


    }

    public void addItem(CartItem item) {               //add item method
        CartItemList.add(item);
    }

    public List<CartItem> getItems() {                //get item method
        return CartItemList;
    }
}






public class GrocreyShop{                    // main class 

    static Inventory inventory = new Inventory();
    static CartInventory Cartinventory = new CartInventory();
    public static boolean availabilityCheck(String s){  //checking availability of ite in stock
        for (Item item : inventory.getItems()){
            if (item.getName().equalsIgnoreCase(s)){
                return true;
            }
            
        }
        return false;
    }

public static float totalDiscount(float totalBill) {          //calculating discouunt on grandtotal
    float discount = 0f;

    if (totalBill <= 1000) {
        discount = 0f; // No discount
    } else if (totalBill <= 2000) {
        discount = (10 * totalBill) / 100;
    } else if (totalBill <= 3000) {
        discount = (15 * totalBill) / 100;
    } else if (totalBill <= 5000) {
        discount = (20 * totalBill) / 100;
    } else {
        discount = (25 * totalBill) / 100;
    }

    return discount;
}

public static void DisplayListofItem(){
    System.out.println("=*=*=*=*=*=*=*=*=~~~~~~~~~~.....HERE'S HOW'S ITEM LIST.....~~~~~~~~~~~~~*=*=*=*=*=*=*=*=*=*=");
    System.out.println("The list of items in our store is given below:\n");
    System.out.printf("%-5s %-15s %-10s %-10s\n", "No.", "Item", "Price", "Stock");

    int i = 1;
    for (Item item : inventory.getItems()) {
        System.out.printf("%-5d %-15s %-10.2f %-10d\n", (i++), item.getName(), item.getPrice(), item.getQuantity());
    }

    System.out.println("=*=*=*=*=*=*=*=*.........Now shop as you wish with HOW'S........=*=*=*=*=*=*=*=*=*=*");
}

public static void DisplayListofCartItem(){
    System.out.println("\n============= YOUR CART SUMMARY =============");
    System.out.printf("%-15s %-10s %-10s %-10s\n", "Item", "Qty", "Price", "Total");

        int i = 1;
        for (CartItem item : Cartinventory.getItems()) {
            System.out.printf("%-15s %-10d %-10.2f %-10.2f\n",(i++), item.getName(), item.getPrice(), item.getQuantity());
    }
    System.out.println("=============================================");
}




   
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        float totalBill = 0f;
        int myQuantity;
        float discount = 0f;
        Item currentItem;



        System.out.println("=*=*=*=*=*=*=*=*=*=*.......WELCOME TO HOW'S GROCERY STORE........*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("=*=*=*=*=*=*=*=*=*=*.............WHERE CHOICE IS YOURS..........*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        while(true){
            System.out.println("Enter\n" + "\"shop\" to start shopping \n"+ "\"List\" for list of items\n" + "\"exit\" to quit shopping: ");
            String choice = sc.nextLine();



            if(choice.equalsIgnoreCase("shop")){                        //if select shop then 
                while(true){
                System.out.println("Enter item you want to buy OR type \"complete\" to stop shopping" );
                String myItem = sc.nextLine();
                if (myItem.equalsIgnoreCase("complete")) {
                    break; 
                }
               if(availabilityCheck(myItem)){                                          //checking availability
                    currentItem = inventory.getItemByName(myItem);
                    if(currentItem != null){                                           //double check
                    System.out.print("Enter the quantity of " + myItem + " in numbers:  " );
                    myQuantity = sc.nextInt();
                    sc.nextLine();
                        if(myQuantity <= currentItem.getQuantity()){                    //checking quantity avaialble
                            Cartinventory.addItem(new CartItem(myItem ,currentItem.getPrice(), myQuantity));
                        }
                        else{
                    System.out.println("Oops!! we have run short of quantiy of the "+ myItem + ": ");
                    continue;
                        }
                

                    }
            
                }
                else{                                                                       //if item is not available
                    System.out.println("We are very sorry , Item is out of stock");
                    continue;
                }
            }
        }                                                                                   //if select list of items then
            else if (choice.equalsIgnoreCase("list")){ 
                DisplayListofItem();
            }   
                
        
            else if(choice.equalsIgnoreCase("exit")){                          //if select exit then
                System.out.println("=*=*=*=*=*=*=*=*=*=*.......THANKS FOR visiting HOW'S!!......*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                break;

            }
            else{                                                                             //invalid choice selected 
                System.out.println("Invalid Choice! please try again with correct choice!");
            }
        }
        if (totalBill>0){
            DisplayListofCartItem();
            float grandtotal = totalBill;
            discount = totalDiscount(totalBill);
            totalBill-=discount;
            System.out.println("your Grand total is: " + grandtotal);
            System.out.println("your discount is: " + discount);
            System.out.println("your final total bill is: " + totalBill + "\n.....=*=*=*=*=*=*=*=Happy Shopping with HOW'S......=*=*=*=*=*=*");
        }
  




    sc.close();
        }
}




        
        
        
    
