package client;

import stub.CustomerUser;
import stub.Recipe;
import stub.ShopUser;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tom Veniat on 11/04/15.
 */
public class Menus {
    private static final String USER_MAIN_UNLOGGED =
            "\nWhat do you want to do ?\n" +
                    "\t1-Create an order\n" +
                    "\t2-Create a new account\n" +
                    "\t3-Log in\n" +
                    "\t4-Administrate\n" +
                    "\t0-Exit\n";

    private static final String USER_MAIN_LOGGED =
            "What do you want to do ?\n"
                    +"\t1-Create an order\n"
                    +"\t2-Change your favourite shop\n"
                    +"\t3-Change your credit card number\n"
                    +"\t4-Log out\n"
                    +"\t5-See your orders\n"
                    +"\t0-Exit\n";

    private static final String ADMIN_MAIN_MENU =
            "You're logged as an admin, what do you want to do ?\n" +
                    "\t1-Create a Shop\n" +
                    "\t2-Delete a Shop\n" +
                    "\t3-See all Shops\n" +
                    "\t4-See all customers\n" +
                    "\t5-Consult statisitcs (all orders)\n" +
                    "\t6-Log out\n" +
                    "\t0-Exit";

    public static void printUserMainMenu(CustomerUser user){
        printUserStatus(user);
        if (user==null)
            System.out.println(USER_MAIN_UNLOGGED);
        else
            System.out.println(USER_MAIN_LOGGED);
    }

    public static void printAdminMainMenu() {
        System.out.println(ADMIN_MAIN_MENU);
    }

    private static void printUserStatus(CustomerUser user) {
        System.out.print("\n");
        if (user==null) System.out.println("You are not logged in.");
        else System.out.println("You are logged as "+Printer.show(user));
    }

    public static int getChoice() {
        Scanner sc= new Scanner(System.in);
        int result = 0;
        try {
            result=sc.nextInt();
        }catch (InputMismatchException e){
            result=-1;
            System.err.println("Bad Input.");
        }
        return result;
    }

    public static void sayGoodBye() {
        System.out.println("Byebye !");
    }

    public static void printShopMainMenu(ShopUser currentUser) {
    }

    public static void printAvaibleCookies(List<? extends Recipe> recipes) {
        for (int i = 0; i < recipes.size(); i++)
            System.out.println("\t" + (i+1) + "-" + recipes.get(i).getName() );
    }


    public static Long getLong() {
        Scanner sc = new Scanner(System.in);
        Long num;
        try{
            num = sc.nextLong();
        }catch (InputMismatchException e){
            System.err.println("Bad Input");
            num=new Long(-1);
        }
        return num;
    }
}
