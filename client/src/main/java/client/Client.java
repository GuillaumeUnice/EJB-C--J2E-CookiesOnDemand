package client;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Tom Veniat on 10/04/15.
 *
 */
public class Client {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String host = "";
        try {
            System.out.print("Please enter the host address (default localhost) : ");
            host=sc.nextLine();
        }catch (InputMismatchException e){
            System.err.println("Bad input, running with "+host);
        }
        host=(host.equals(""))?"localhost":host;

        AbstractClient client= null;

        System.out.println("User(1) or ShopManager(2) ?");

        int answer =0;
        try {
            answer = sc.nextInt();
        }catch (InputMismatchException e){
            System.err.println("Bad Input, exit.");
        }
        if (answer==1){
            client = new UserClient(host);
            client.run();
        }else if (answer==2){
            client = new ShopClient(host);
            client.run();
        }

    }



}
