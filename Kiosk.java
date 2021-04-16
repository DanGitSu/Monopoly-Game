import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

//import org.graalvm.compiler.lir.aarch64.AArch64Move.StoreOp;

public class Kiosk {
	private Catalogue catalogue; 
	private List<Customer> customers = new ArrayList<Customer>();
	
		// write your solution here

	public static void main(String[] args) {
        new Kiosk();
	}

    Kiosk(){
        this.catalogue = new Catalogue(this);
        catalogue.addGenre("Action Queue");
        catalogue.addGenre("Role Playing");
        catalogue.addGenre("Hand Management");
        catalogue.addGenre("Modular Board");
        catalogue.addGame("Robinson Crusoe",2012,3,catalogue.findGenre("Action Queue"));
        catalogue.addGame("Talisman", 2007, 4, catalogue.findGenre("Role Playing"));
        catalogue.addGame("Three Kingdoms Redux", 2014, 3, catalogue.findGenre("Hand Management"));
        catalogue.addGame("Dungeons & Dragons", 2010, 4, catalogue.findGenre("Modular Board"));
        catalogue.addGame("Elder Sign", 2011, 3, catalogue.findGenre("Modular Board"));

        customers.add(new Customer(101, "Jaime", 10));
        customers.add(new Customer(102, "Luke", 10));
        customers.add(new Customer(103, "William", 1));
        use();
        
    }

	public void use(){ // main menu
        boolean loop = true;
        while (loop){
            System.out.println("Welcome to the Game Kiosk! Please make a selection from the menu:\n"
            + "1. Explore the catalogue.\n"
            + "2. View your customer record.\n" //PARTIAL
            + "3. Show you favourite games.\n"
            + "4. Top up account.\n"
            + "5. Enter Admin Mode.\n" //IMPLEMENTED
            + "X. Exit the system.");   //IMPLEMENTED

            System.out.print("Enter a choice: ");
            String choice = In.nextLine();

            if(choice.equals("1")){
                catalogue.use();
            }
            else if(choice.equals("2")) custRecordView(); //PARTIAL
            else if(choice.equals("3"));
            else if(choice.equals("4")) topUp();
            else if(choice.equals("5")) admin(); //IMPLEMENTED
            else if(choice.equals("X")){    //IMPLEMENTED
                System.out.println("Thank you for using the Game Kiosk, do visit us again.");
                loop = false;
            }else{
                System.out.println("Please enter a number between 1 and 5, or press X to exit.");
            }
        }
	}

    private void topUp() {
        System.out.print("\nEnter a customer ID: ");
        int id = In.nextInt();
        Customer c = findCust(id);
        System.out.print("Enter the top-up amount:");
        int amount = In.nextInt();

        int previous = c.getBalance();
        int current = c.topUp(amount);
        System.out.println("\nTransaction complete.");
        System.out.println(c.getName()+"'s balance was: $" + previous);
        System.out.println(c.getName()+"'s current balance is: $" + current);
        System.out.println("");
    }
    
    //ADMIN STUFF

    private void admin(){ // admin menu
        boolean loop = true;
        while (loop){
            System.out.println("Welcome to the administration menu:\n"
            + "1. List all customers.\n" //implemented
            + "2. Add a customer.\n" //implemented
            + "3. Remove a customer.\n"
            + "4. List all games.\n" //implemented
            + "5. Add a game to the catalogue.\n" // IMPLEMENTED
            + "6. Remove a game from the catalogue.\n" //IMPLEMENTED
            + "R. Return to the previous menu."); // IMPLEMENTED

            System.out.print("Enter a choice: ");
            String choice = In.nextLine();

            if(choice.equals("1")){
                listCust();
            }
            else if(choice.equals("2")){
                addCust();
            }
            else if(choice.equals("3")){
                removeCust();
            }
            else if(choice.equals("4")){ //IMPLEMENTED
                cataList();
            }else if(choice.equals("5")){ //IMPLEMENTED
                cataAddGame();
            }
            else if(choice.equals("6")){ //IMPLEMENTED
                cataRemoveGame();
            }
            else if(choice.equals("R")){ //IMPLEMENTED
                loop = false;
            }
        }
    }
    private void listCust(){
        System.out.println("\nThe Kiosk has the following customers:");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
        System.out.println("");
    }

    private void addCust() {
        System.out.println("\nAdding a new customer.");
        System.out.print("Enter a new ID: ");
        int id = In.nextInt();
        while(true){
            if (!custExists(id))break;
            System.out.print("That customer already exists, please enter a new ID: ");
            id = In.nextInt();
        }
        System.out.print("Enter the customer's name: ");
        String name = In.nextLine();
        System.out.print("Enter the customer's initial balance: ");
        int balance = In.nextInt();
        customers.add(new Customer(id, name, balance));
        System.out.println("Customer added.\n");
    }

    
    public boolean custExists(int id) {
        for (Customer customer : customers) {
            if (customer.getID()==id) return true;
        }
        return false;
    }

    private void removeCust(){
        System.out.println("\nRemoving a customer.");
        System.out.print("Enter a customer ID: ");
        int id = In.nextInt();
        if(custExists(id)){
            customers.remove(findCust(id));
            System.out.println("Customer removed.\n");
        }else{
            System.out.println("That customer does not exist.\n");
        }
    }

    private void cataList() {
        System.out.println("\nThe Kiosk has the following games:");
        List<Game> gameAvailable = catalogue.getGamesAvailable();
        for (Game game : gameAvailable) {
            System.out.println(game.toString());
        }
        System.out.println("");
    }

    public Customer findCust(int id){
        for (Customer customer : customers) {
            if(customer.getID()==id) return customer;
        }
        return null;
    }

    // Add a game to the catalogue, also adds finds the genre (needs to add genre)
    private void cataAddGame() {
        System.out.println("\nAdding a new game.");
        System.out.print("Enter the title of the game: ");
        String title = In.nextLine();

        System.out.print("Enter the year: ");
        int year = In.nextInt();

        System.out.print("Enter the genre: ");
        String sGenre = In.nextLine(); 
        Genre genre = catalogue.findGenre(sGenre); // only finds genre

        System.out.print("Enter price: ");
        int price = In.nextInt();
        if (!catalogue.exists(title, year)){ //prevents double add
            catalogue.addGame(title, year, price, genre);
            System.out.println("Added " + title + " to catalogue.\n");
        }else {
            System.out.println("The game is already in the catalogue.");
        }
        
    }

    private void cataRemoveGame(){ // CURRENTLY WORKING ON THIS
        System.out.println("\nRemoving a game.");
        System.out.print("Enter the title of the game: ");
        String title = In.nextLine();
        System.out.print("Enter the year: ");
        int year = In.nextInt();
        if (catalogue.exists(title, year)){
            System.out.println(catalogue.removeGame(title, year)); 
        }else{
            System.out.println("No such game found.\n");
        }
        
    }

    //END ADMIN STUFF

    //CUSTOMER STUFF
    
    // used to view a particular customers record
    private void custRecordView(){ // 2nd choice main menu 2. View your customer record 
        System.out.print("\nEnter a customer ID: ");
        int id = In.nextInt();
        boolean match = false;
        
        for (Customer c : customers){
            if(c.getID() == id){ 
                match = true;
                System.out.println("ID: " + c.getID());
                System.out.println("Name: " + c.getName());
                System.out.println("Balance: $"+ c.getBalance());
                System.out.println("Games currently rented by " + c.getName() +":");
                for (Game game : c.getCurrentlyRented()) {
                    System.out.println(game.toString());
                }
                System.out.println(c.getName()+ "'s renting history:");
                for (Game game : c.getRentingHistory()){
                    System.out.println(game.toString());
                }
            }
        }if (match == false) System.out.println("That customer does not exist.\n");else{
            System.out.println("");
        }
    }

    //END CUSTOMER STUFF
}