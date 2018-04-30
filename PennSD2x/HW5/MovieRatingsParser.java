/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	/**
	 * 
	 * @param allUsersRatings
	 * @return a TreeMap mapping from the movie's title to a PriorityQueue of all its associated ratings
	 */
	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
		TreeMap<String, PriorityQueue<Integer>> ratings = new TreeMap();
		if (allUsersRatings != null && !allUsersRatings.isEmpty()) {
			for (UserMovieRating r: allUsersRatings) {
				if (r == null || r.movie == null || r.movie.isEmpty() || r.userRating < 0) {
					continue;
				}
				String name = r.movie.toLowerCase();
				Integer rating = r.userRating;
				if (ratings.containsKey(name)){
					PriorityQueue<Integer> q = ratings.get(name);
					q.add(rating);			
					
				}else {
					PriorityQueue<Integer> newQ = new PriorityQueue();
					newQ.add(rating);
					ratings.put(name, newQ);
				}
			}
		}
		
		return ratings; 
	}

}
