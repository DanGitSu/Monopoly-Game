import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int ID; 
	private String name; 
	private int balance;
	private List<Game> currentlyRented = new ArrayList<Game>(); 
	private List<Game> rentingHistory = new ArrayList<Game>();

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

		public List<Game> getCurrentlyRented() {
			return currentlyRented;
		}

		public List<Game> getRentingHistory() {
			return rentingHistory;
		}

		public void rentGame(Game g){
			currentlyRented.add(g);
			rentingHistory.add(g);
			this.balance-= g.getPrice();
		}

		public void returnGame(Game g){
			currentlyRented.remove(g);
		}

		public int topUp(int amount) {
			this.balance+=amount;
			return this.balance;
		}

		@Override
		public String toString() {
			return ID + "\t" + name + "\t$ " + balance;
		}
	}