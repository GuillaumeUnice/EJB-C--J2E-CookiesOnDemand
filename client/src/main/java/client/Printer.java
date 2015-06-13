package client;

import stub.*;

/**
 * Created by Tom Veniat on 11/04/15.
 */
public class Printer {

    public static void print(Shop shop){
        System.out.println(show(shop));
    }

    public static void print(String before, Shop shop, String after){
        System.out.println(before+show(shop)+after);
    }

    public static void print(ShopUser shopUser){
        System.out.println(show(shopUser));}

    public static void print(String before, ShopUser user, String after) {
        System.out.println(before+show(user)+after);
    }

    public static void print(UserOrder order){
        System.out.println(show(order));}

    public static void print(String before, UserOrder order, String after) {
        System.out.println(before+show(order)+after);
    }

    public static String show(UserOrder order) {
        String str ="Order n°"+order.getId()+", made by "+order.getUser()+" the "+order.getDate()+" with " + order.getProducts().size() + " recipe(s) :" ;
        for (Product p : order.getProducts())
            if (p.getRecipe()!=null)
                str += "\n\t -" + p.getRecipe().getName() + " en " + p.getQuantity() + " exemplaires.";
        return str;
    }

    public static void print(CustomerUser user){
        System.out.println(show(user));
    }

    public static void print(String before, CustomerUser user, String after){
        System.out.println(before+show(user)+after);
    }



    public static String show(Shop shop){
        if (shop==null) return "No Shop";
        return "Shop n°"+shop.getId()+" located at "+show(shop.getAddress())+".";
    }

    public static String show(Address address) {
        if (address.getCountry().equals("")&&address.getCity().equals("")&&address.getAdress().equals("")&&address.getZipCode()==0)
            return "No address";
        return "Adress : "+address.getCountry()+"-"+address.getCity()+"-"+address.getZipCode()+"-"+address.getAdress() ;
    }

    public static String show(CustomerUser user) {
        if (user==null) return "No user";
        return "User : "+user.getFirstName()+" "+user.getLastName()+" : "+user.getEmail()+"\n" +
                "\t Favorite shop : "+show(user.getFavouriteShop())+"\n" +
                "\t Card Number : "+user.getCreditCard();
    }

    public static String show(ShopUser shopUser) {
        return "ShopUser : "+shopUser.getFirstName()+" "+shopUser.getLastName()+" : "+shopUser.getEmail()+", managed shop : "+show(shopUser.getManagedShop())+".";
    }



}