import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int ID; 
	private String name; 
	private int balance;
	private List<Game> currentlyRented; 
	private List<Game> rentingHistory;

		// write your solution here

		Customer(int ID, String name, int balance){
			this.ID = ID;
			this.name = name;
			this.balance = balance;
		}

		public int getID() {
			return ID;
		}
		public int getBalance() {
			return balance;
		}
		public String getName() {
			return name;
		}
}