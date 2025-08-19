import java.util.*;


class Item {                                                   //class item
    private String name;
    private float price;
    private int quantity;

    public Item(String name, float price, int quantity) {      //constructor
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public Item(){

    }

    
    public String getName() {                                 //name getter
        return name; 
    }
    public float getPrice() {                                 //price getter
        return price; 
    }
    public int getQuantity() {                                 //quantity getter
         return quantity; 
    }

    public void setQuantity(int quantity) {                    //quantity setter
         this.quantity = quantity; 
    }
}

class Inventory {                                    //class inventory
    private List<Item> itemList;

    public Inventory() {                             //constructor
        itemList = new ArrayList<>();
 itemList.add(new Item("Apple", 150.0f, 50));
itemList.add(new Item("Banana", 60.0f, 100));
itemList.add(new Item("Mango", 200.0f, 40));
itemList.add(new Item("Milk", 180.0f, 30));
itemList.add(new Item("Bread", 120.0f, 25));
itemList.add(new Item("Eggs", 250.0f, 20));
itemList.add(new Item("Rice", 300.0f, 15));
itemList.add(new Item("Sugar", 180.0f, 20));
itemList.add(new Item("Flour", 160.0f, 25));
itemList.add(new Item("Tea", 500.0f, 10));
itemList.add(new Item("Coffee", 800.0f, 8));
itemList.add(new Item("Salt", 50.0f, 30));
itemList.add(new Item("Cooking Oil", 550.0f, 12));
itemList.add(new Item("Butter", 400.0f, 10));
itemList.add(new Item("Cheese", 500.0f, 8));
itemList.add(new Item("Chicken", 700.0f, 15));
itemList.add(new Item("Beef", 900.0f, 10));
itemList.add(new Item("Fish", 1200.0f, 6));
itemList.add(new Item("Onion", 100.0f, 20));
itemList.add(new Item("Potato", 80.0f, 25));
itemList.add(new Item("Tomato", 120.0f, 18));
itemList.add(new Item("Carrot", 140.0f, 15));
itemList.add(new Item("Cucumber", 130.0f, 12));
itemList.add(new Item("Soft Drink", 120.0f, 20));
itemList.add(new Item("Chips", 60.0f, 30));
itemList.add(new Item("Biscuits", 90.0f, 40));
itemList.add(new Item("Chocolate", 150.0f, 25));
itemList.add(new Item("Jam", 250.0f, 15));
itemList.add(new Item("Honey", 600.0f, 10));
itemList.add(new Item("Pasta", 200.0f, 18));
itemList.add(new Item("Noodles", 70.0f, 35));
itemList.add(new Item("Ketchup", 180.0f, 20));
itemList.add(new Item("Mayonnaise", 250.0f, 15));
itemList.add(new Item("Pickles", 220.0f, 12));
itemList.add(new Item("Dry Fruits", 1500.0f, 5));
itemList.add(new Item("Lentils", 300.0f, 25));
itemList.add(new Item("Spices Mix", 100.0f, 20));
itemList.add(new Item("Shampoo", 350.0f, 10));
itemList.add(new Item("Soap", 80.0f, 40));
itemList.add(new Item("Toothpaste", 200.0f, 20));
itemList.add(new Item("Tissue Box", 150.0f, 18));
itemList.add(new Item("Face Wash", 400.0f, 10));
itemList.add(new Item("Detergent Powder", 600.0f, 8));
itemList.add(new Item("Bleach", 250.0f, 6));
itemList.add(new Item("Hand Sanitizer", 300.0f, 12));
itemList.add(new Item("Mosquito Spray", 500.0f, 5));
itemList.add(new Item("Ice Cream", 350.0f, 15));
itemList.add(new Item("Yogurt", 180.0f, 12));

       

    }

    public void addItem(Item item) {               //add item method
        itemList.add(item);
    }

    public List<Item> getItems() {                //get whole items item method
        return itemList;
    }
    public  Item getItemByName(String name){      //get ingle item from whole list
        for (Item item : itemList){
            if(item.getName().equalsIgnoreCase(name)){
                return item;
            }
        }
        return null;                              //If not found;
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

    
    public String getName() {                            //name getter
        return name; 
    }
    public float getPrice() {                            //price getter
        return price; 
    }
    public int getQuantity() {                          //quantity getter
         return quantity; 
    }


    public void setName(String name) {                  //name setter
        this.name =  name; 
    }
    public void setPrice(float price) {                //price setter
        this.price = price; 
    }
    public void setQuantity(int quantity) {            //quantity setter
        this.quantity = quantity;
    }
}

class CartInventory {                                   //class inventory
    private List<CartItem> CartItemList;

    public CartInventory() {                           //constructor
        CartItemList = new ArrayList<>();


    }

    public void addItem(CartItem item) {               //add item method
        CartItemList.add(item);
    }

    public List<CartItem> getCartItems() {              //get item method
        return CartItemList;
    }
    public boolean isCartEmpty() {
        return CartItemList.isEmpty();
    }

     public void removeItem(int index) {               //remove item method
        CartItemList.remove(index);
    }

    public CartItem getItemByIndex(int index) {           //get item by index
    if (index >= 0 && index < CartItemList.size()) {
        return CartItemList.get(index);
    }
    return null;
}




}






public class GrocreyShop{                                       // main class 

    static Inventory inventory = new Inventory();
    static CartInventory Cartinventory = new CartInventory();


    public static boolean availabilityCheck(String s){               //checking availability of item selected
        return inventory.getItemByName(s) != null;
    }


public static float totalDiscount(float totalBill){          //calculating discouunt on grandtotal
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

public static void DisplayListofCartItem() {
    System.out.println("\n============= YOUR CART SUMMARY =============");
     if (Cartinventory.isCartEmpty()) {
        System.out.println("Your cart is empty."+ "\n"+ "\n"+ "\n");
        return;                                                           // stop here
    }
    else{
    System.out.printf("%-5s %-15s %-10s %-10s %-10s\n", "No.", "Item", "Qty", "Price", "Total");

    int i = 1;
    for (CartItem item : Cartinventory.getCartItems()) { 
        System.out.printf("%-5d %-15s %-10d %-10.2f %-10.2f\n",i++, item.getName(),  item.getQuantity(), item.getPrice(), item.getPrice() * item.getQuantity()
        );
    }
    System.out.println("=============================================");
}
}





   
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        float totalBill = 0f;
        int myQuantity;
        float discount = 0f;
        Item currentItem = new Item();



        System.out.println("=*=*=*=*=*=*=*=*=*=*.......WELCOME TO HOW'S GROCERY STORE........*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("=*=*=*=*=*=*=*=*=*=*.............WHERE CHOICE IS YOURS..........*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        while(true){
            System.out.println("Enter:\n" + "\"shop\" to start shopping \n"+ "\"List\" for list of items\n" + "\"Cart\" to show your cart\n" +  "\"exit\" to quit shopping: ");
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
                    System.out.print("Enter the quantity of " + myItem + " in numbers:  " );
                    myQuantity = sc.nextInt();
                    sc.nextLine();
                        if(myQuantity >= 0){                    //checking quantity avaialble
                            Cartinventory.addItem(new CartItem(myItem ,currentItem.getPrice(), myQuantity));
                            totalBill += currentItem.getPrice() * myQuantity;
                            currentItem.setQuantity(currentItem.getQuantity()-myQuantity);
                        }
                        else{
                    System.out.println("Oops!! we have run short of quantiy of the "+ myItem + ": ");
                    continue;
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
            else if(choice.equalsIgnoreCase("Cart")){
                if (Cartinventory.isCartEmpty()) {
                    System.out.println("Your cart is empty."+ "\n"+ "\n"+ "\n");
                }
                else{
                    DisplayListofCartItem();
                    while(true){
                    System.out.println("\n"+ "\n"+ "\n" + "Enter:\n" + "\"Remove\" to remove item from cart \n"+ "\"Back\" to start shopping again \n");
                    String secondChoice = sc.nextLine();
                    if(secondChoice.equalsIgnoreCase("remove")){
                        System.out.print("Enter the serial number of the item to remove: ");
                        int removeIndex = sc.nextInt()-1;
                        sc.nextLine();
                        if(removeIndex >= 0 && removeIndex < Cartinventory.getCartItems().size()){
                            CartItem selectedItem = Cartinventory.getItemByIndex(removeIndex);
                            if(selectedItem != null){
                            totalBill -= selectedItem.getPrice() *  selectedItem.getQuantity();
                            Cartinventory.removeItem(removeIndex);
                            System.out.println( selectedItem.getName() + " is removed successfully!");
                            }
                            else{
                                System.out.println("Invalid index selected , try again!");
                            }
                        }
                        else{
                        System.out.println("Invalid serial number!");
                        }
                    }
                    else if(secondChoice.equalsIgnoreCase("back")){
                        break;
                    }
                    else{
                        System.out.println("Invalid choice. Try again.");
                    }
                }
                
            }
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




        
        
        
    
