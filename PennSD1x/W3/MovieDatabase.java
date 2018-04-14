/**
 * 
 */
package w3;
import java.util.*;
import java.io.*;
/**
 * @author NL
 *
 */
public class MovieDatabase {
	
	private ArrayList<Movie> movieList;
	private ArrayList<Actor> actorList;
	
	public MovieDatabase() {
		movieList = new ArrayList<>();
		actorList = new ArrayList<>();
	}
	
	public ArrayList<Movie> getMovieList(){
		return this.movieList;
	}
	
	public ArrayList<Actor> getActorList(){
		return this.actorList;
	}
	/**
	 * This method takes in the name of a movie that is not currently in the
	 * database along with a list of actors for that movie.
	 * 
	 *@param name - name of the movie to be added
	 *@param actors - list of actors in the movie
	 * 
	 * If the movie is already in the database, your code ignores this request (this
	 * specification is an oversimplification).
	 * 
	 * If the movie is a new movie, a movie object is created and added to the
	 * movieList.
	 * 
	 * If any of the actors happen to be new, they will be added to the actorList.
	 */
	public void addMovie(String name, String[] actors) {
		if (notInM(name, this.getMovieList())) {
			Movie newMovie = new Movie(name);
			this.movieList.add(newMovie);
			for (String actorName: actors) {
				if (notInA(actorName, this.getActorList())) {
					Actor newActor = new Actor(actorName);
					this.actorList.add(newActor);					
				}
				
			
			}
			// Convert String Array to List
	        List<String> list = Arrays.asList(actors);
			for (Actor a: this.getActorList()) {
				if(list.contains(a.getName())) {
					a.getMovies().add(newMovie);
					newMovie.getActors().add(a);
				}
			}
		}
		
		
	}
	/**
	 * Helper function to check whether a movie to be added is already in the database
	 * @param name - of movie to be added
	 * @param movieList - this movieDatabase's movieList
	 * @return true if not in, false if in
	 */
	private boolean notInM(String name, ArrayList<Movie> mList) {
		boolean notFound = true;
		for (Movie m: mList) {
			String mName = m.getName();
			if (mName == name) {
				notFound = false;				
			}
		}
		return notFound;
	}
	/**
	 * Helper function to check whether an actor in the current to-be-added movie is already in the database
	 * @param name - of the actor 
	 * @param actorList - this movieDatabase's actorlist
	 * @return true if not in, false if in
	 */
	private boolean notInA(String name, ArrayList<Actor> aList) {
		boolean notFound = true;
		for (Actor a: aList) {
			String aName = a.getName();
			if (aName == name) {
				notFound = false;
			}
		}
		return notFound;
	}
	 /*	 
	 * void addRating(String name, double rating)
	 * 
	 * Add a rating for this movie. Assume that the name argument will definitely be
	 * a name that is currently in the database.
	 */
	public void addRating(String name, double rating) {
		for (int i = 0; i < this.getMovieList().size(); i++) {
			Movie m = this.getMovieList().get(i);
            if (m.getName() == name) {
                m.setRating(rating);
                return;
            }
        }
		
	}

	 /* void updateRating(String name, double newRating)
	 * 
	 * Overwrite the current rating of a movie with this new rating. Again, assume
	 * that the name argument will definitely be a name that is currently in the
	 * database.
	 */
	public void updateRating(String name, double newRating) {
		for (int i = 0; i < this.getMovieList().size(); i++) {
			Movie m = this.getMovieList().get(i);
            if (m.getName() == name) {
                m.setRating(newRating);
                return;
            }
        }
		
		
	}
	 /* String getBestActor()
	 * 
	 * Returns the name of the actor that has the best average rating for their
	 * movies.
	 * In the case of a tie, return any one of the best actors.
	 * 
	 */
	public String getBestActor() {		
		Actor best = null;
		double max = 0.0;
		for (Actor a: this.getActorList()) {
			double thisAvr = a.averageR();
			if(thisAvr > max) {
				best = a;
				max = thisAvr;
			}
		}
		return best.getName();
		
	}
	 /* 
	 * 
	 * String getBestMovie() Returns the name of the movie with the highest rating.
	 * 
	 * In the case of a tie, return any one of the best movies.
	 */
	public String getBestMovie() {
		Movie best = null;
		double max = 0.0;
		for (Movie m: movieList) {
			double thisR = m.getRating();
			if (thisR > max) {
				best = m;
				max = thisR;
			}
		}
		return best.getName();
		
	}
	
	 /* Main method Finally, write a main method where:
	 * 
	 * You create a new instance of a movieDatabase.
	 * 
	 * Add all the movies in the file movies.txt.
	 * 
	 * Go through the ratings of the movies in the file ratings.txt and add the
	 * ratings for the movies.
	 * 
	 * Now call the methods that you created and print out the name of the best
	 * actor and the name of the highest rated movie.
	 * 
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		MovieDatabase mDB = new MovieDatabase();
		Map<String, List<String>> movies = new HashMap<>();
		Scanner sc = new Scanner(new File("movies.txt"));
		while (sc.hasNextLine()){
			String[] values = sc.nextLine().split(", ");
			for (int i = 1; i < values.length; i++) {
        		if (!movies.containsKey(values[i])) {
        			movies.put(values[i], new ArrayList<String>());
        		}
        		movies.get(values[i]).add(values[0]);
        	}
			
		}
		 for (String movie : movies.keySet()) {
	        	List<String> actors = movies.get(movie);
	        	mDB.addMovie(movie, actors.toArray(new String[actors.size()]));
	        }
		 sc = new Scanner(new File("ratings.txt"));
	        sc.nextLine(); // skip header
	        while(sc.hasNextLine()){
	        	String[] ratings = sc.nextLine().split("\t");
	        	mDB.addRating(ratings[0], Double.parseDouble(ratings[1]));
	        }


			System.out.println("Best movie: " + mDB.getBestMovie());
			System.out.println("Best actor: " + mDB.getBestActor());
		}

	
	

}
