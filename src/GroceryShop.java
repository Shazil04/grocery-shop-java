import java.util.*;
public class GrocreyShop{
    public static boolean availabilityCheck(String arr[] , String s){  //checking availability of ite in stock
        for (int i = 0 ; i< arr.length ; i++){
            if (arr[i].equalsIgnoreCase(s)){
                return true;
            }
            
        }
        return false;
    }

    public static int findingIndex(String arr[] , String s){  //finding index of item
        for (int i = 0 ; i< arr.length ; i++){
            if (arr[i].equalsIgnoreCase(s)){
                return  i;
            }
        }
        return -1;
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

public static void showStock(String[] items, float[] price, int[] quantity) {       
    System.out.println("=*=*=*=*=*=*=*=*=~~~~~~~~~~.....HERE'S HOW'S ITEM LIST.....~~~~~~~~~~~~~*=*=*=*=*=*=*=*=*=*=");
    System.out.println("The list of items in our store is given below:\n");

    System.out.printf("%-5s %-15s %-10s %-10s\n", "No.", "Item", "Price", "Stock");

    
    for (int i = 0; i < items.length; i++) {
        System.out.printf("%-5d %-15s %-10.2f %-10d\n", (i + 1), items[i], price[i], quantity[i]);
    }

    System.out.println("=*=*=*=*=*=*=*=*.........Now shop as you wish with HOW'S........=*=*=*=*=*=*=*=*=*=*");
}




   
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String items[] = new String[]{"sugar"    , "tea"    , "rice"        , "flour"    , 
                                      "pulses"   , "salt"   , "masalas"     , "milk"     ,
                                       "yougert" , "juices" ,  "dry fruits" , "biscuits" , 
                                       "snacks"  , "bread"  , "chocolates"  , "sweets" } ;

        float price[] = new float[]{500f , 1500f , 400f  , 100f  ,
                                    500f , 50f   , 500f  , 250f  , 
                                    200f , 300f  , 3000f , 250f  , 
                                    1000f , 200f , 1500f , 1200f};

        int quantity[] = new int[]{100 , 60  , 200 , 500  ,
                                   300 , 10  , 200 , 50   ,
                                    40 , 100 , 200 , 250  , 
                                   300 , 500 , 400 , 100} ;

        float totalBill = 0f;
        int idx  , myQuantity;
        float discount = 0f;
        System.out.println("=*=*=*=*=*=*=*=*=*=*.......WELCOME TO HOW'S GROCERY STORE........*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("=*=*=*=*=*=*=*=*=*=*.............WHERE CHOICE IS YOURS..........*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        while(true){
            System.out.println("Enter\n" + "\"shop\" to start shopping \n"+ "\"List\" for list of items\n" + "\"exit\" to quit shopping: ");
            String choice = sc.nextLine();

            if(choice.equalsIgnoreCase("shop")){
                System.out.println("Enter your items to buy ot type \"complete\" to stop shopping" );
                while(true){
                System.out.print("Enter the item you want to buy: ");
                String myItem = sc.nextLine();
                if (myItem.equalsIgnoreCase("complete")) {
                    break; 
                }
               if(availabilityCheck(items , myItem)){
                    System.out.print("Enter the quantity of " + myItem + ":  " );
                    myQuantity = sc.nextInt();
                    sc.nextLine();
                    idx = findingIndex(items , myItem);
                }
                else{
                    System.out.println("We are very sorry , Item is out of stock");
                    continue;
                }
                if(myQuantity<=quantity[idx]){
                    System.out.println("We have enough quantiy of the "+ myItem + ": ");
                    totalBill+= price[idx]*myQuantity;
                    quantity[idx]-=myQuantity;
                }
                else{
                    System.out.println("Oops!! we have run short of quantiy of the "+ myItem + ": ");
                    continue;
                }
            }
        }
            else if (choice.equalsIgnoreCase("list")){
            showStock(items  , price , quantity);
            }
        
            else if(choice.equalsIgnoreCase("exit")){
                System.out.println("=*=*=*=*=*=*=*=*=*=*.......THANKS FOR visiting HOW'S!!......*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                break;

            }
            else{
                System.out.println("Invalid Choice! please try again with correct choice!");
            }
        }
        if (totalBill>0){
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

Add main application code


        
        
        
    
