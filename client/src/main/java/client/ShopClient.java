package client;

import stub.*;

import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tom Veniat on 12/04/15.
 */
public class ShopClient extends AbstractClient {

    private String host;
    private ShopWs shopWs;
    //We need to use the UserWs to create a fake context.
    UsersWs usersWs;
    private ShopUser currentUser;

    public ShopClient(String host) {
        this.host=host;
        shopWs=null;
        usersWs=null;
        //currentUser=null;

        String address = "http://"+host+":8080/COD_V0/webservices/ShopService";
        URL wsdlLocation = null;
        try { wsdlLocation = new URL(address + "?wsdl"); } catch (Exception e) { System.exit(0); }

        System.out.println(wsdlLocation);

        ShopImplService service = new ShopImplService(wsdlLocation);
        shopWs= service.getShopImplPort();

        ((BindingProvider) shopWs).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);

    }

    @Override
    void run() {
        simulate();

    }

    void simulate(){



        //init the useWs & the context
        String address = "http://"+host+":8080/COD_V0/webservices/UsersService";
        URL wsdlLocation = null;
        try { wsdlLocation = new URL(address + "?wsdl"); } catch (Exception e) { System.exit(0); }
        UsersImplService service = new UsersImplService(wsdlLocation);
        usersWs = service.getUsersImplPort();
        ((BindingProvider) usersWs).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);

        System.out.println("###SIMULATION :");
        System.out.println("#Creation of 3 shops :");
        Address ad=new Address();
        ad.setCountry("France");
        ad.setCity("Patong");
        ad.setZipCode(12345);
        ad.setAdress("La maison");
        usersWs.createShop(ad, 12, 12, 2.0,"ADMIN", "ADMpassword");
        ad.setCountry("Rainbow");
        ad.setCity("Dash");
        ad.setZipCode(54321);
        ad.setAdress("Le Fiel");
        usersWs.createShop(ad, 10, 12, 2.0,"ADMIN", "ADMpassword");
        ad.setCountry("FarFar");
        ad.setCity("Away ");
        ad.setZipCode(99999);
        ad.setAdress("Le chat");
        usersWs.createShop(ad, 12, 7, 2.0,"ADMIN", "ADMpassword");

        List<Shop> shops = usersWs.getAllShops();
        for (Shop s : shops)
            Printer.print("\t",s,"");

        System.out.println("#Creation of 3 customers :");
        try {
            usersWs.createCustomerUser("hotmail","jj","Goldman","HOTpassword");
        }catch (Exception e){}
        Printer.print("\t",usersWs.getCustomerUserById("hotmail","HOTpassword"),"");
        try {
            usersWs.createCustomerUser("gmail","loui","Goldman","GMApassword");
        }catch (Exception e){}
        Printer.print("\t",usersWs.getCustomerUserById("gmail","GMApassword"),"");
        try {
            usersWs.createCustomerUser("orange","henry","Goldman","ORApassword");
        }catch (Exception e){}
        Printer.print("\t",usersWs.getCustomerUserById("orange","ORApassword"),"");

        System.out.println("#Creation of a Shop Manager :");
        try {
            usersWs.createShopUser("my@mal.com","pre","nom","MY@password");
        }catch (Exception e){}
        ShopUser user = usersWs.getShopUserById("my@mal.com");
        Printer.print("\t", user, "");

        System.out.println("#Setting the manager's shop to the second shop");
        shopWs.changeShopUser(shops.get(1).getId(), user.getEmail());
        user = usersWs.getShopUserById(user.getEmail());
        Printer.print("\t", user, "");


        System.out.println("Les recette du shop de : " + Printer.show(user) + " :");
        System.out.println(shopWs.getAllOrdersbyShop(user.getManagedShop().getId()));

        System.out.println("#Creation of some UserOrders (2 for the shop manager's Shop and one other) ");

        ShopRecipe r1= new ShopRecipe();
        r1.setIsMenu(true);
        r1.setName("firstRecipe");
        r1.setId(usersWs.createShopRecipe(r1));
        Product p1 = new Product();
        p1.setRecipe(r1);
        p1.setQuantity(7);

        UserOrder order1 = new UserOrder();
        order1.setShop(user.getManagedShop());
        order1.setDate(toXMLGregorianCalendar(new Date()));
        User a =usersWs.getCustomerUserById("gmail","GMApassword");
        order1.setUser((CustomerUser) a);
        order1.getProducts().add(p1);
        usersWs.createOrder(order1, (long) 2);

        UserOrder order2 = new UserOrder();
        order2.setShop(shops.get(0));
        order2.setDate(toXMLGregorianCalendar(new Date()));
        order2.setUser(usersWs.getCustomerUserById("hotmail", "HOTpassword"));
        p1.setQuantity(3);
        order2.getProducts().add(p1);
        usersWs.createOrder(order2, (long) 8);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        UserOrder order3 = new UserOrder();
        order3.setShop(user.getManagedShop());
        order3.setDate(toXMLGregorianCalendar(new Date()));
        order3.setUser(usersWs.getCustomerUserById("hotmail","HOTpassword"));
        p1.setQuantity(18);
        order3.getProducts().add(p1);
        usersWs.createOrder(order3, (long) 1234567890);

        System.out.println("Orders of the shop managed by : " +Printer.show(user) + " :");
        for (UserOrder order :shopWs.getAllOrdersbyShop(user.getManagedShop().getId()))
            Printer.print("\t\t",order,"");

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        clean();
    }


    public void clean(){
        System.out.println("### END OF THE SIMULATION : CLEANING");
        for (Shop s : usersWs.getAllShops())
            usersWs.deleteShop(s.getId());
        for (User u : usersWs.getAllUsers())
            usersWs.removeUser(u);
    }
}
