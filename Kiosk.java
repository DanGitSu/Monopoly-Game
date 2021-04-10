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
        catalogue.addGenre("Modular Board");
        catalogue.addGame("Dungeons & Dragons", 2017, 4, catalogue.findGenre("Modular Board"));
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
            else if(choice.equals("4"));
            else if(choice.equals("5")) admin(); //IMPLEMENTED
            else if(choice.equals("X")){    //IMPLEMENTED
                System.out.println("Thank you for using the Game Kiosk, do visit us again.");
                loop = false;
            }
        }
	}
    
    //ADMIN STUFF

    private void admin(){ // admin menu
        boolean loop = true;
        while (loop){
            System.out.println("Welcome to the administration menu:\n"
            + "1. List all customers.\n"
            + "2. Add a customer.\n"
            + "3. Remove a customer.\n"
            + "4. List all games.\n"
            + "5. Add a game to the catalogue.\n" // IMPLEMENTED
            + "6. Remove a game from the catalogue.\n"
            + "R. Return to the previous menu."); // IMPLEMENTED

            System.out.print("Enter a choice: ");
            String choice = In.nextLine();

            if(choice.equals("1")){
            }
            else if(choice.equals("2"));
            else if(choice.equals("3"));
            else if(choice.equals("4"));
            else if(choice.equals("5")){ //IMPLEMENTED
                cataAddGame();
            }
            else if(choice.equals("6")){
                cataRemoveGame();
            }
            else if(choice.equals("R")){ //IMPLEMENTED
                loop = false;
            }
        }
    }

    // Add a game to the catalogue, also adds finds the genre (needs to add genre)
    private void cataAddGame() {
        System.out.println("\nAdding a new game.");
        System.out.print("Enter the title of the game: ");
        String title = In.nextLine();

        System.out.print("Enter the year: ");
        int year = In.nextInt();

        System.out.println("Enter the genre: ");
        String sGenre = In.nextLine(); 
        Genre genre = catalogue.findGenre(sGenre); // only finds genre

        System.out.println("Enter price: ");
        int price = In.nextInt();

        catalogue.addGame(title, year, price, genre);
    }

    private void cataRemoveGame(){ // CURRENTLY WORKING ON THIS
        System.out.println("\nRemoving a game.");
        System.out.print("Enter the title of the game: ");
        String title = In.nextLine();
        System.out.print("Enter the year: ");
        int year = In.nextInt();
        System.out.println(catalogue.removeGame(title, year)); 
    }

    //END ADMIN STUFF

    //CUSTOMER STUFF
    
    // used to view a particular customers record
    private void custRecordView(){ // 2nd choice main menu 2. View your customer record 
        System.out.print("\nEnter a customer ID: ");
        int in = In.nextInt();
        
        for (Customer c : customers){
            if(c.getID() == in){ 
                // TODO ENTER CODE FOR WHEN ID MATCHING!!
            }
        }
        // when no match found
        System.out.println("That customer does not exist.\n");
    }

    //END CUSTOMER STUFF
}