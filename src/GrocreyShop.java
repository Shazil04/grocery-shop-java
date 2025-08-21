import java.util.*;
import java.io.*;


class User {
    private String username;
    private String password;
    private String role;

    // Constructor
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Convert user to file format
    public String toFileString() {
        return username + "," + password + "," + role;
    }

    // Create user from file line
    public static User fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            return new User(parts[0], parts[1], parts[2]);
        }
        return null;
    }
}


class UserManager {
    private List<User> users;
    private File file;

    // Constructor
    public UserManager(String fileName) {
        this.file = new File(fileName);
        this.users = new ArrayList<>();
        loadUsersFromFile();
    }

// Load users from file
private void loadUsersFromFile() {
    try {
        if (!file.exists()) {
            file.createNewFile();  // auto-create if missing
            System.out.println("📂 User file created: " + file.getName());
            return; // nothing to load since it's new
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                User user = User.fromFileString(line);
                if (user != null) {
                    users.add(user);
                }
            }
        }

    } catch (IOException e) {
        System.out.println("❌ Error loading users: " + e.getMessage());
    }
}

// Save users to file
private void saveUsersToFile() {
    try {
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("📂 User file created: " + file.getName());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (User user : users) {
                bw.write(user.toFileString());
                bw.newLine();
            }
        }

    } catch (IOException e) {
        System.out.println("❌ Error saving users: " + e.getMessage());
    }
}

    // Sign up new user
    public void signUp(Scanner sc) {
        System.out.print("Enter new username: ");
        String username = sc.nextLine();

        // Check if username already exists
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Username already taken. Try another.");
                return;
            }
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.print("Confirm password: ");
        String confirmPassword = sc.nextLine();
        if (!password.equals(confirmPassword)){
            System.out.println("Passwords do not match! Try again.");
            return;
        }

        System.out.print("Enter role (admin/user): ");
        String role = sc.nextLine();

        User newUser = new User(username, password, role);
        users.add(newUser);
        saveUsersToFile();

        System.out.println("Sign-up successful! You can now log in.");
    }

    // Login user
    public User login(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("\n"+"\n"+ "\nLogin successful! Welcome " + user.getUsername());
                return user;
            }
        }

        System.out.println("Invalid username or password.");
        return null;
    }



    public static void getUsersList(String filename){
    File file = new File(filename);

    if (!file.exists()) {
        System.out.println("No users found (file does not exist).");
        return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 1;
        while ((line = br.readLine()) != null) {
           
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String username = parts[0];
                String role = parts[2];
                System.out.println(i + ". Username: " + username + " | Role: " + role);
            }
            i++;
        }
    } catch (IOException e) {
        System.out.println("Error reading users file: " + e.getMessage());
    }
}
}


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

    public void clearList(){
        CartItemList.clear();
    }




}






public class GrocreyShop{                                       // main class 

    static Inventory inventory = new Inventory();
    static CartInventory Cartinventory = new CartInventory();
    static UserManager userManager = new UserManager("users.txt");


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
public static void adminMenu(Scanner sc) {
    while (true) {
        System.out.println("\nEnter:\n" + "\"Add\" to add a new item\n" + "\"Remove\" to remove an item\n"+ "\"View\" to view all items\n" + "\"Logout\" to log out\n");
        System.out.print("Your choice: ");
        String choice = sc.nextLine().trim().toLowerCase();

        switch (choice) {
            case "add":
                System.out.print("Enter item name: ");
                String name = sc.nextLine();
                System.out.print("Enter price: ");
                float price = Float.parseFloat(sc.nextLine());
                System.out.print("Enter quantity: ");
                int qty = Integer.parseInt(sc.nextLine());

                Item item = new Item(name, price, qty);
                inventory.addItem(item);
                System.out.println("Item added successfully!");
                
                break;

            case "remove":
                inventory.getItems();
                System.out.print("Enter the name of the item you want to remove: ");
                String nameToRemove = sc.nextLine().trim();

                boolean found = false;

                for (int i = 0; i < inventory.getItems().size(); i++) {
                if (inventory.getItems().get(i).getName().equalsIgnoreCase(nameToRemove)) {
                    inventory.getItems().remove(i); 
                    System.out.println("Item \"" + nameToRemove + "\" removed successfully!");
                    found = true;
                    break;
                }
                }

                if (!found) {
                    System.out.println("Item \"" + nameToRemove + "\" not found in inventory.");
                }
                break;

            case "view":
                UserManager.getUsersList("users.txt");               
                break;

            case "logout":
                System.out.println("Logging out... ");
                return;
            default:
                System.out.println(" Invalid input! Please try again.");
            }
        }
    }



    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        

        float totalBill = 0f;
        int myQuantity = 0;
        float discount = 0f;
        float grandtotal = 0f;
        Item currentItem = new Item();



        System.out.println("=*=*=*=*=*=*=*=*=*=*.......WELCOME TO HOW'S GROCERY STORE........*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("=*=*=*=*=*=*=*=*=*=*.............WHERE CHOICE IS YOURS..........*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        while(true){
            System.out.println("Enter:\n" + "\"shop\" to start shopping \n"+ "\"List\" for list of items\n" + "\"Cart\" to show your cart\n" + "\"Register\" to register yourself: " + "\"exit\" to quit shopping: ");
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
                    System.out.println("\n"+ "\n"+ "\n" + "Enter:\n" + "\"Checkout\" for checkout \n" + "\"Remove\" to remove item from cart \n"+ "\"Back\" to start shopping again \n");
                    String secondChoice = sc.nextLine();
                    if(secondChoice.equalsIgnoreCase("checkout")){
                         DisplayListofCartItem();
                        grandtotal = totalBill;
                        discount = totalDiscount(totalBill);
                        totalBill-=discount;
                        System.out.println("your Grand total is: " + grandtotal);
                        System.out.println("your discount is: " + discount);
                        System.out.println("your final total bill is: " + totalBill + "\n.....=*=*=*=*=*=*=*=Happy Shopping with HOW'S......=*=*=*=*=*=*");
                        System.out.println( "\n" + "\n "+ "\n"+ "Do you want to confirm checkout? (yes/no)");
                        String confirmation = sc.nextLine();
                        if(confirmation.equalsIgnoreCase("yes")){
                            System.out.println( "Thank you for shopping!");
                            Cartinventory.clearList();
                            totalBill = 0;
                            break;

                        } 
                        else{
                            System.out.println( "Checkout cancelled. You can continue shopping.");
                            continue;
                        }
                        
       

                    }
                    else if(secondChoice.equalsIgnoreCase("remove")){
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
                break;
                
            }
        }
             else if (choice.equalsIgnoreCase("Register")){
                System.out.println("Are you "+ "\n" + "An ADMIN" + " \n"+ "A USER" + "\n");
                String userSelection = sc.nextLine();
                String role;
                if(userSelection.equalsIgnoreCase("user")){
                while (true){
                    System.out.println("\nEnter:\n" + "\"Log in \" if account already exists\n"+ "\"Sign up\" to create new account\n"+ "\"Exit\" to to exit \n");
                    role = sc.nextLine();
                    if(role.equalsIgnoreCase("log in")){
                        User loggedInUser = userManager.login(sc);
                        if (loggedInUser != null) {
                            System.out.println("Logged in as: " + loggedInUser.getRole()+ "\n"+ "\n" + "\n");
                            break;
                        }

                     }
              
                    else if(role.equalsIgnoreCase("sign up")){
                        userManager.signUp(sc);

                    }
                    else if(role.equalsIgnoreCase("Exit")){
                        System.out.println("Exiting...");
                        break;

                    }
                    else{
                        System.out.println("Invalid Choice, try again");
                    }
                }
            }
            else if(userSelection.equalsIgnoreCase("admin")){
                System.out.println("Enter secret code for an ADMIN'S POWERS:");
                String secretCode = sc.nextLine();
                if(secretCode.equals("SCARFACE")){
                while (true){
                    System.out.println("\nEnter:\n" + "\"Log in \" if account already exists\n"+ "\"Sign up\" to create new account\n"+ "\"Exit\" to to exit \n");
                    role = sc.nextLine();
                    if(role.equalsIgnoreCase("log in")){
                        User loggedInUser = userManager.login(sc);
                        if (loggedInUser != null) {
                            System.out.println("Logged in as: " + loggedInUser.getRole()+ "\n"+ "\n" + "\n");
                            break;
                        }

                     }
              
                    else if(role.equalsIgnoreCase("sign up")){
                        userManager.signUp(sc);

                    }
                    else if(role.equalsIgnoreCase("Exit")){
                        System.out.println("Exiting...");
                        break;

                    }
                    else{
                        System.out.println("Invalid Choice, try again");
                     }
                }

                adminMenu(sc);       //if log in as an admin then showing his roles

                }
                else{
                    System.out.println("**************************************************");
                    System.out.println("*                                                *");
                    System.out.println("*   Sorry my dear!                               *");
                    System.out.println("*   You can't become Admin                       *");
                    System.out.println("*   Until you have permission from HOW's owner   *");
                    System.out.println("*                  SHAZIL                        *");
                    System.out.println("*                                                *");
                    System.out.println("**************************************************");
                    break;
                }
            }
 
        else{
            System.out.println("Invalid choice, please select a valid choice");
            userSelection = sc.nextLine();
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
            grandtotal = totalBill;
            discount = totalDiscount(totalBill);
            totalBill-=discount;
            System.out.println("your Grand total is: " + grandtotal);
            System.out.println("your discount is: " + discount);
            System.out.println("your final total bill is: " + totalBill + "\n.....=*=*=*=*=*=*=*=Happy Shopping with HOW'S......=*=*=*=*=*=*");
        }

    sc.close();
    }
}




        
        
        
    
