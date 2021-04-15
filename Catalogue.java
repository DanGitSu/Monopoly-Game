import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	private Kiosk kiosk;
	private List<Game> gamesAvailable = new ArrayList<Game>();
	private List<Game> gamesRented = new ArrayList<Game>(); 
	private List<Genre> genres = new ArrayList<Genre>();

    		// write your solution here

    Catalogue(Kiosk k){
        this.kiosk = k;
    }

    public void use(){
        boolean loop = true;
            while (loop){
            System.out.println("Welcome to the Catalogue! Please make a selection from the menu:\n"
            + "1. Display all games.\n"
            + "2. Display all available games.\n"
            + "3. Display all genres.\n"
            + "4. Display games in a genre.\n"
            + "5. Display all games by year.\n"
            + "6. Rent a game.\n"
            + "7. Return a game.\n"
            + "R. Return to previous menu.");

            System.out.print("Enter a choice: ");
            String choice = In.nextLine();

            if(choice.equals("1"));
            else if(choice.equals("2"));
            else if(choice.equals("3"));
            else if(choice.equals("4"));
            else if(choice.equals("5"));
            else if(choice.equals("6")){
                rentGame();
            }
            else if(choice.equals("7")){
                returnGame();
            }
            else if(choice.equals("R")){
                loop = false;
            }
        }
	}

    private void rentGame() {
        System.out.print("\nEnter a valid customer ID: ");
        int id = In.nextInt();
        while(true){
            if (kiosk.custExists(id))break;
            System.out.print("Enter a valid customer ID: ");
            id = In.nextInt();
        }
        System.out.print("Enter the title of the game you wish to rent: ");
        String title = In.nextLine();
        if (isGameAvailable(findGame(title))){
            Game g = findGame(title);
            gamesRented.add(g);
            kiosk.findCust(id).rentGame(g);
            System.out.println("Game rented.\n");
        }else{
            System.out.println("That game is not available or doesn't exist.\n");
        }
    }

    private void returnGame(){
        System.out.print("\nEnter a valid customer ID: ");
        int id = In.nextInt();
        while(true){
            if (kiosk.custExists(id))break;
            System.out.print("Enter a valid customer ID: ");
            id = In.nextInt();
        }
        Customer c = kiosk.findCust(id);
        System.out.println(c.getName() +" has the following games:");
        System.out.println("Games currently rented by Jaime:");
        for (Game g: c.getCurrentlyRented()) {
            System.out.println(g.toString());
        }
        System.out.print("Enter the title of the game you wish to return: ");
        String title = In.nextLine();
        Game g = findGame(title);
        gamesRented.remove(g);
        c.returnGame(g);
        System.out.println(title + " has been returned.\n");
    }

    private boolean isGameAvailable(Game g){
        for (Game game : gamesRented) {
            if(game.equals(g)) return false;
        }
        return true;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Game> getGamesAvailable() {
        return gamesAvailable;
    }

    public void addGenre(String name) {
        genres.add(new Genre(name));
    }
    
    public Genre findGenre(String sGenre) {
        int index = 0;
        for (Genre g : getGenres()){
            if(g.getName().equals(sGenre)){
                index = getGenres().indexOf(g);
            }
        }
        return getGenres().get(index);
    }

    public void addGame(String title, int year, int price, Genre genre) {
        gamesAvailable.add(new Game(title, year, price, genre));
    }

    public String removeGame(String title, int year) {
        Game toRemove = gamesAvailable.get(findGameIndex(title, year)); 
        Genre g = toRemove.getGenre();
        int p = toRemove.getPrice();
        gamesAvailable.remove(toRemove);
        return year + "\t" + toRemove.getTitle() +"\t"+ g.getName() + "\t$" + p + " removed from catalogue.\n";
    }

    public int findGameIndex(String title, int year) {
        for (Game g : gamesAvailable){
            if(g.getTitle().equals(title) && g.getYear() == year) return gamesAvailable.indexOf(g);
        }
        return 0; // error code
    }

    public boolean exists(String title, int year){
        for (Game g : gamesAvailable){
            if(g.getTitle().equals(title) && g.getYear() == year) return true;
        }
        return false;
    }

    public Game findGame(String title) {
        for (Game game : gamesAvailable) {
            if(game.getTitle().equals(title)) return game;
        }
        return null;
    }
}