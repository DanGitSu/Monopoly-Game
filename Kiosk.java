import java.util.ArrayList;
import java.util.List;

//import org.graalvm.compiler.lir.aarch64.AArch64Move.StoreOp;

public class Kiosk {
	private Catalogue catalogue; 
	private List<Customer> customers;
	
		// write your solution here

	public static void main(String[] args) {
        new Kiosk();
	}

    Kiosk(){
        this.catalogue = new Catalogue(this);
        use();
        
    }

	public void use(){ // main menu
		System.out.println("Welcome to the Game Kiosk! Please make a selection from the menu:\n"
        + "1. Explore the catalogue.\n"
        + "2. View your customer record.\n"
        + "3. Show you favourite games.\n"
        + "4. Top up account.\n"
        + "5. Enter Admin Mode.\n"
        + "X. Exit the system.");

        System.out.print("Enter a choice: ");
        String choice = In.nextLine();

        if(choice.equals("1")){
            catalogue.use();
        }
        else if(choice.equals("2")) custRecordView();
        else if(choice.equals("3"));
        else if(choice.equals("4"));
        else if(choice.equals("5")) admin();
        else if(choice.equals("X")){
            System.out.println("Thank you for using the Game Kiosk, do visit us again.");
        }
	}

    private void admin(){ // admin menu
        System.out.println("Welcome to the administration menu:\n"
        + "1. List all customers.\n"
        + "2. Add a customer.\n"
        + "3. Remove a customer.\n"
        + "4. List all games.\n"
        + "5. Add a game to the catalogue.\n"
        + "6. Remove a game from the catalogue.\n"
        + "R. Return to the previous menu.");

        System.out.print("Enter a choice: ");
        String choice = In.nextLine();

        if(choice.equals("1")){
        }
        else if(choice.equals("2"));
        else if(choice.equals("3"));
        else if(choice.equals("4"));
        else if(choice.equals("5"));
        else if(choice.equals("6"));
        else if(choice.equals("R")){
            use();
        }
    }

    
    // used to view a particular customers record
    private void custRecordView(){ // 2nd choice main menu 2. View your customer record 
        System.out.print("Enter a customer record: ");
        String in = In.nextLine();
        if (customers.size() > )
        customers.get(Integer.parseInt(in)-1);
    }
}