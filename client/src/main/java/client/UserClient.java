package client;

import stub.*;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Tom Veniat on 12/04/15.
 */
public class UserClient extends AbstractClient {

    private boolean admin = false;
    private CustomerUser currentUser=null;
    private UsersWs usersWs = null;
    private String currentPassword="";

    public UserClient(String host){
        String address = "http://"+host+":8080/COD_V0/webservices/UsersService";
        URL wsdlLocation = null;
        try { wsdlLocation = new URL(address + "?wsdl"); } catch (Exception e) { System.exit(0); }

        System.out.println(wsdlLocation);

        UsersImplService service = new UsersImplService(wsdlLocation);
        usersWs = service.getUsersImplPort();

        ((BindingProvider) usersWs).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
        try {
            usersWs.createCustomerUser("ADMIN","admin","admin","ADMpassword");
        }catch (SOAPFaultException e){

        }

        usersWs.createShop(new Address(), 12, 12, 2.0,"ADMIN","ADMpassword");
        usersWs.createShop(new Address(), 10, 12, 2.0,"ADMIN","ADMpassword");
        usersWs.createShop(new Address(), 12, 7, 2.0,"ADMIN","ADMpassword");

        //Creation of some Shop Recipes
        ShopRecipe sR1 = new ShopRecipe(), sR2 = new ShopRecipe(), sR3 = new ShopRecipe();
        sR1.setIsMenu(true);
        sR2.setIsMenu(true);
        sR3.setIsMenu(true);
        sR1.setName("GatôCHeaukeau");
        sR2.setName("Bite Me");
        sR3.setName("ALanssienne");
        sR1.setDutyFreePrice(5.3);
        sR2.setDutyFreePrice(4.7);
        sR3.setDutyFreePrice(125);
        usersWs.createShopRecipe(sR1);
        usersWs.createShopRecipe(sR2);
        usersWs.createShopRecipe(sR3);
        try {
            usersWs.createCustomerUser("ADMIN","admin","admin","ADMpassword");
        }catch (SOAPFaultException e){

        }

//        usersWs.createCustomerUser("hotmail","jj","Goldman");
//        usersWs.createCustomerUser("gmail","loui","Goldman");
//        usersWs.createCustomerUser("orange","henry","Goldman");
//        usersWs.createCustomerUser("yahoo","thierry","Goldman");
//        usersWs.createCustomerUser("@etu.unice.fr","paul","Goldman");

    }

    @Override
    void run() {

        int choice;
        do {
            if(admin)
                Menus.printAdminMainMenu();
            else
                Menus.printUserMainMenu(currentUser);
            choice = Menus.getChoice();
            handleChoice(choice);
        } while (choice != 0);
        Menus.sayGoodBye();
        clean();
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                if (admin)
                    createShop();
                else
                    createCommand();
                break;
            case 2:
                if (currentUser==null)
                    createUser();
                else if (admin)
                    deleteShop();
                else
                    changeShop();
                break;
            case 3:
                if(currentUser==null)
                    login();
                else if (admin){
                    List<Shop> shops = usersWs.getAllShops();
                    System.out.println("### ALL SHOPS : ");
                    for (Shop s : shops)
                        Printer.print("\t",s,"");
                    System.out.println("### END");
                }else{
                    changeCreditCard();
                }
                break;
            case 4:
                if (admin){
                    List<CustomerUser> customers = usersWs.getAllCustomerUsers();
                    System.out.println("### ALL CUSTOMERS : ");
                    for (CustomerUser u : customers)
                        Printer.print("\t",u,"");
                    System.out.println("### END");
                }else if (currentUser==null){
                    goAdmin();
                }else{
                    currentUser=null;
                    System.out.println("Disconnected");
                }
            break;
            case 5:
                if (admin) {
                    List<UserOrder> orders = usersWs.getAllOrders();
                    System.out.println("### ALL ORDERS : ");
                    for (UserOrder uo : orders)
                        Printer.print("\t", uo, "");
                    System.out.println("### END");
                }else if (currentUser!=null){
                    List<UserOrder> orders = usersWs.getUserOrders(currentUser.getEmail());
                    System.out.println("### ALL YOUR ORDERS : ");
                    for (UserOrder uo : orders)
                        Printer.print("\t", uo, "");
                    System.out.println("### END");
                }
                else
                    System.err.println("Bad input");
                break;
            case 6:
                if (admin){
                    admin=!admin;
                } else
                    System.err.println("Bad input");
                break;
            case 0:
                break;
            default:
                System.err.println("Bad input");
        }
    }

    private void goAdmin() {
        Scanner sc= new Scanner(System.in);
        String eMail = "",psswrd="";
        System.out.print("Admin password : ");
        try {
            psswrd = sc.nextLine();
        }catch (InputMismatchException e){
            System.err.println("Bad input.");
        }
        currentUser = usersWs.getCustomerUserById("ADMIN",psswrd);
        if (currentUser != null) {
            currentPassword = psswrd;
            admin=true;
            currentUser=null;
        }
    }

    private void deleteShop() {
        System.out.println(" which shop ? ");
        Shop selectedShop = chooseShop();
        usersWs.deleteShop(selectedShop.getId());
        if (currentUser != null && currentUser.getFavouriteShop().equals(selectedShop))
            currentUser=usersWs.getCustomerUserById(currentUser.getEmail(),currentPassword);
    }

    private void createShop() {
        Scanner sc = new Scanner(System.in);
        Address ad = new Address();
        int nbCusto, nbCookies;
        double taxe;
        try {
            System.out.print("Country : ");
            ad.setCountry(sc.nextLine());
            System.out.print("Town : ");
            ad.setCity(sc.nextLine());
            System.out.print("ZipCode : ");
            ad.setZipCode(sc.nextInt());
            sc.nextLine();
            System.out.print("Address : ");
            ad.setAdress(sc.nextLine());
            System.out.print("Max number of customers (per hour) : ");
            nbCusto=sc.nextInt();
            System.out.print("Max number of cookies (per hour) : ");
            nbCookies=sc.nextInt();
            System.out.print("Taxe : ");
            taxe=sc.nextDouble();
        }catch (InputMismatchException e){
            System.err.println("Bad input, aborting");
            return;
        }


        usersWs.createShop(ad,nbCusto,nbCookies,taxe,"ADMIN", currentPassword);

    }

    private void changeShop() {
        System.out.println("Please type the number of your wanted new favorite shop : ");
        Shop selectedShop = chooseShop();
        usersWs.changeFavoriteShop(selectedShop.getId(),currentUser.getEmail(),currentPassword);
        currentUser=usersWs.getCustomerUserById(currentUser.getEmail(),currentPassword);
        System.out.println("Favorite Shop changed to : "+Printer.show(selectedShop));
    }

    private void changeCreditCard() {
        System.out.println("Your current card is n°" + usersWs.getCustomerUserById(currentUser.getEmail(),currentPassword).getCreditCard());
        System.out.print("Enter your new credit card number : ");
        Scanner sc = new Scanner(System.in);
        Long newNumber;
        try{
            newNumber = sc.nextLong();
        }catch (InputMismatchException e){
            System.err.println("Bad input.");
            return;
        }
        usersWs.changCreditCard(newNumber,currentUser.getEmail(),currentPassword);
        currentUser=usersWs.getCustomerUserById(currentUser.getEmail(), currentPassword);
        System.out.println("Credit card number changed to : " + newNumber);
    }

    private void createUser() {
        Scanner sc= new Scanner(System.in);
        String email="", firstName="", lastName="", password="";
        try {
            System.out.print("Firstname : ");
            firstName=sc.nextLine();
            System.out.print("Lastname : ");
            lastName=sc.nextLine();
            System.out.print("Email (required) : ");
            email=sc.nextLine();
            System.out.print("Password (required) : ");
            password=sc.nextLine();
        }catch (InputMismatchException e) {
            System.err.println("Bad Input");
            return;
        }
        try {
            usersWs.createCustomerUser(email,firstName,lastName,password);
        }catch (SOAPFaultException e){
            System.err.println("Account cration failed");
            return;
        }
        System.out.println("User created : " + Printer.show(usersWs.getCustomerUserById(email,password)));
    }

    private void login() {
        Scanner sc= new Scanner(System.in);
        String eMail = "",psswrd="";
        System.out.print("E-mail address : ");
        try {
            eMail=sc.nextLine();
            System.out.print("password : ");
            psswrd = sc.nextLine();
        }catch (InputMismatchException e){
            System.err.println("Bad input.");
        }
        currentUser = usersWs.getCustomerUserById(eMail,psswrd);
        if (currentUser != null)
            currentPassword=psswrd;
    }

    private void createCommand() {
        UserOrder order = new UserOrder();

        for (Product p : cookiesSelection())
            order.getProducts().add(p);

        Shop selectedShop;
        if (currentUser==null ||currentUser.getFavouriteShop()==null){
            System.out.println("Where do you want to take this order ?");
            selectedShop=chooseShop();
        }else
            selectedShop=currentUser.getFavouriteShop();
        order.setShop(selectedShop);

        Calendar cal = getDate();
        order.setDate(toXMLGregorianCalendar(cal.getTime()));

        order.setUser(currentUser);
        Long creditCard;
        if (currentUser!=null && currentUser.getCreditCard()!=null)
            creditCard=currentUser.getCreditCard();
        else{
            System.out.print("Please entre your credit card number : ");
            creditCard = Menus.getLong();
        }

        try{
            order.setId(usersWs.createOrder(order, creditCard));
        }catch (SOAPFaultException e){
            System.err.println("error : incomplete order");
            return;
        }
        if (order.getId()!=null/*!order.getId().equals(new Long(-1))*/)
            System.out.print("Order Created, your order ID is : "+order.getId()+ " (DO NOT loose it, this reference will be needed to take away your cookies).");
        else
            System.err.println("error: invalid credit card.");
    }

    private List<Product> cookiesSelection() {
        List<Product> userSelection= new ArrayList<>();
        while (true) {
            System.out.println("Do you want to select:\n" +
                    "\t1-One of our cookies\n" +
                    "\t2-One of your cookies\n" +
                    "\t3-Make a new recipe\n" +
                    "\t0-End of the selection");
            int answer;
            Product p;
            do {
                answer = Menus.getChoice();
            } while (answer < 0 || answer > 3);

            p = new Product();

            switch (answer) {
                case 1:
                    p.setRecipe(selectRecipe(usersWs.getAllShopRecipes()));
                    break;
                case 2:
                    p.setRecipe(selectRecipe(currentUser));
                    break;
                case 3:
                    p.setRecipe(createRecipe());
                    break;
                case 0:
                    return userSelection;
                default:
                    break;
            }
            if (p.getRecipe()==null) continue;
            p.setQuantity(getQuantity());
            if (p.getQuantity()==0) continue;
            userSelection.add(p);
        }
    }

    private Recipe createRecipe() {
        PersonalRecipe newRecipe = new PersonalRecipe();
        newRecipe.setDough(getDough());

        newRecipe.setFlavour(getFlavour());
        newRecipe.setMix(getMix());
        newRecipe.setCooking(getCooking());
        for (Topping t : getToppings())
            newRecipe.getTopping().add(t);
        Scanner sc = new Scanner(System.in);
        System.out.println("How do you want to name your recipe ?");
        newRecipe.setName(sc.nextLine());
        newRecipe.setId(usersWs.createPersonalRecipe(newRecipe));
        newRecipe.setUser(currentUser);
        usersWs.updatePersonalRecipe(newRecipe);
        return newRecipe;
    }

    private ShopRecipe selectRecipe(List<ShopRecipe> recipes) {
        Menus.printAvaibleCookies(recipes);
        int cookie=Menus.getChoice() - 1;
        while (cookie<0 || cookie>=recipes.size()){
            System.err.println("Choose a recipe from the list please.");
            cookie = Menus.getChoice() - 1;;
        }
        return recipes.get(cookie);
    }

    private PersonalRecipe selectRecipe(CustomerUser user){
        List<PersonalRecipe> recipes;
        if (user==null) {
            System.err.println("You need to be connected to use this feature.");
            return null;
        }
        recipes =  usersWs.getAllRecipesByUser(user);
        if (recipes.size()==0){
            System.err.println("You don't have any personnal recipe yet.");
            return null;
        }
        Menus.printAvaibleCookies(recipes);
        int cookie=Menus.getChoice() - 1;
        while (cookie<0 || cookie>=recipes.size()){
            System.err.println("Choose a recipe from the list please.");
            cookie = Menus.getChoice() - 1;;
        }
        return recipes.get(cookie);
    }

    private Shop chooseShop(){
        List<Shop> shops = usersWs.getAllShops();
        int i=1;
        for (Shop s : shops)
            Printer.print("\t"+(i++)+" - ",s,"");

        int selectedShop = Menus.getChoice();
        while (selectedShop<1 || selectedShop>shops.size()) {
            System.err.println("Bad input.");
            selectedShop = Menus.getChoice();
        }
        return shops.get(selectedShop - 1);
    }

    public Calendar getDate() {
        System.out.println("When do you want to take it ? (dd.mm.yyyy)");
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Scanner sc = new Scanner(System.in);
        String strDate;
        try {
            strDate=sc.nextLine();
            cal.setTime(sdf.parse(strDate));
        }catch (InputMismatchException e){
            System.err.println("Bad Input, exit.");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal;
    }


    public int getQuantity() {
        System.out.println("How many ?");
        int quantity = Menus.getChoice();
        while (quantity<0){
            System.err.println("Quantity must be positive");
            quantity=Menus.getChoice();
        }
        return quantity;
    }

    @Override
    public void clean() {
        System.out.println("### END OF THE SIMULATION : CLEANING");
        for (Shop s : usersWs.getAllShops())
            usersWs.deleteShop(s.getId());
        for (User u : usersWs.getAllUsers())
            usersWs.removeUser(u);
        for (Recipe r: usersWs.getAllRecipes())
            usersWs.removeRecipe(r);
    }

    public Dough getDough() {
        System.out.println("Choose your dough :");
        List<Dough> doughs = usersWs.getAllDoughs();
        for (int i = 0; i<doughs.size();++i)
            System.out.println("\t"+(i+1)+"-"+doughs.get(i));
        int answer = Menus.getChoice();
        while (answer<1 || answer>doughs.size()){
            System.err.println("Bad input.");
            answer = Menus.getChoice();
        }
        System.out.println(doughs.get(answer-1));
        return doughs.get(answer-1);
    }

    public Flavour getFlavour() {
        System.out.println("Choose your flavour :");
        List<Flavour> flavours = usersWs.getAllFlavours();
        for (int i = 0; i<flavours.size();++i)
            System.out.println("\t"+(i+1)+"-"+flavours.get(i));
        System.out.println("\t0-It's okay, thx.");
        int answer = Menus.getChoice();
        while (answer<0 || answer>flavours.size()){
            System.err.println("Bad input.");
            answer = Menus.getChoice();
        }
        if (answer==0)return null;
        System.out.println(flavours.get(answer-1));
        return flavours.get(answer-1);
    }

    public Mix getMix() {
        System.out.println("Choose your mix :");
        List<Mix> mixs = usersWs.getAllMixs();
        for (int i = 0; i<mixs.size();++i)
            System.out.println("\t"+(i+1)+"-"+mixs.get(i));
        int answer = Menus.getChoice();
        while (answer<1 || answer>mixs.size()){
            System.err.println("Bad input.");
            answer = Menus.getChoice();
        }
        System.out.println(mixs.get(answer-1));
        return mixs.get(answer-1);
    }

    public Cooking getCooking() {
        System.out.println("Choose your cooking :");
        List<Cooking> cookings = usersWs.getAllCookings();
        for (int i = 0; i<cookings.size();++i)
            System.out.println("\t"+(i+1)+"-"+cookings.get(i));
        int answer = Menus.getChoice();
        while (answer<1 || answer>cookings.size()){
            System.err.println("Bad input.");
            answer = Menus.getChoice();
        }
        System.out.println(cookings.get(answer-1));
        return cookings.get(answer-1);
    }

    public List<Topping> getToppings() {
        System.out.println("Choose your toppings (3 Max) :");
        List<Topping> toppings = usersWs.getAllToppings();
        for (int i = 0; i<toppings.size();++i)
            System.out.println("\t"+(i+1) +"-"+toppings.get(i));
        System.out.println("\t0-It's okay, thx.");

        List<Topping> choices = new ArrayList<>();
        int answer;
        for (int i = 0 ; i<3 ; ++i){
            answer = Menus.getChoice();
            while (answer<0 || answer>toppings.size()){
                System.err.println("Bad input.");
                answer = Menus.getChoice();
            }
            if (answer==0)return choices;
            choices.add(toppings.get(answer - 1));
            System.out.print(toppings.get(answer - 1));
            System.out.println((i==2)?"":" added, another one ?");
        }
        return choices;
    }
}
