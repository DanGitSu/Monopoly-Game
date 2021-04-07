import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Game {
	private String title; 
	private int year; 
	private int price; 
	private Genre genre;
		// write your solution here

	public Game(String title, int year, int price, Genre genre) {
		this.title = title;
		this.year = year;
		this.price = price;
		this.genre = genre;
	}
	
	public Genre getGenre() {
		return genre;
	}
	public int getPrice() {
		return price;
	}
	public String getTitle() {
		return title;
	}
	public int getYear() {
		return year;
	}
}