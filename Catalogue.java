import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	private Kiosk kiosk;
	private List<Game> gamesAvailable;
	private List<Game> gamesRented; 
	private List<Genre> genres = new ArrayList<Genre>();

    		// write your solution here

    Catalogue(Kiosk k){
        this.kiosk = k;
    }

    public void use(){
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
        else if(choice.equals("6"));
        else if(choice.equals("7"));
        else if(choice.equals("R")){
            kiosk.use();
        }
	}

    public List<Genre> getGenres() {
        return genres;
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
}