/**
 * 
 */
package w3;
import java.util.ArrayList;
/**
 * 
 * @author NL
 *
 */
public class Actor {
	
	private String name;
	private ArrayList<Movie> movies;
	
	public Actor(String name) {
		this.name = name;
		movies = new ArrayList<>();
	}

	/*
	 * The grader tests Actor() with no string passing in
	 *  
	 * Another(perhaps neater) solution
	 * ------
	 * public Actor(String name) { 
	 * this.name = ""; 
	 * movies = new ArrayList<>(); 
	 * }
	 * ------
	 * Only use setName method to set name
	 * This requires major revision on my MovieDatabase methods though... 
	 */
	public Actor() {
		this("");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Movie> getMovies(){
		return movies;
	}
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	/**
	 * Helper function to get the actor's average rating for his/her movies
	 * @return average rating in float
	 */
	public double averageR() {
		double sum = 0.0;
		for (Movie m: this.getMovies()) {
			sum += m.getRating();
		}
		return sum / this.getMovies().size();
	}
	
	

}
