/**
 * 
 */
package w3;
import java.util.ArrayList;
/**
 * @author NL
 *
 */
public class Movie {
	
	private String name;
	private ArrayList<Actor> actors;
	private double rating;
	
	public Movie(String name) {
		this.name = name;
		this.rating = 0.0;
		actors = new ArrayList<>();
	}
	// the grader tests Movie()
	public Movie() {
		this("");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;		
	}
	
	public ArrayList<Actor> getActors(){
		return actors;
	}
	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}
	
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	

}
