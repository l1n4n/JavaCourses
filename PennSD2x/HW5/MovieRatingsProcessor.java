/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;


public class MovieRatingsProcessor {

	/**
	 * 
	 * @param movieRatings
	 * @return a List of movie titles in alphabetical order
	 */
	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		
		List<String> titles = new ArrayList<>();
		if (movieRatings != null && !movieRatings.isEmpty()) {
			titles.addAll(movieRatings.keySet());
		}		
		return titles; 
	}
	/**
	 * 
	 * @param movieRatings
	 * @param rating
	 * @return a List of movie titles in alphabetical order, 
	 * where all movies in the List do not have any ratings less than or equal to rating
	 */
	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		List<String> titles = new ArrayList<>();
		if (movieRatings != null && !movieRatings.isEmpty()) {
			movieRatings.forEach((key, value) ->{
				if(value.peek() > rating) titles.add(key);}
			);
		}		
		return titles;
	}
	
	/**
	 * remove all ratings in the PriorityQueue that are below (but not equal to) rating for every movie in the Map
	 * @param movieRatings
	 * @param rating
	 * @return a new TreeMap that maps a movie title to the number of ratings that were removed from its corresponding PriorityQueue
	 */
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		TreeMap<String, Integer> records = new TreeMap();
		if (movieRatings != null && !movieRatings.isEmpty()) {
			
		    // Get an iterator http://www.baeldung.com/java-concurrentmodificationexception
			Iterator<Map.Entry<String, PriorityQueue<Integer>>> entries = movieRatings.entrySet().iterator();
		    
		    while (entries.hasNext()) {
		    	Map.Entry<String, PriorityQueue<Integer>> me = (Map.Entry)entries.next();
		    	String m = me.getKey();
		    	PriorityQueue<Integer> q = me.getValue();
		    	if(q.peek() < rating) {
		    		Iterator<Integer> ratingsMe = q.iterator();
		    		while(ratingsMe.hasNext()) {
		    			Integer current = ratingsMe.next();
		    			if(current < rating) {
		    				ratingsMe.remove();
		    				if (records.containsKey(m)) {
			    				records.put(m, records.get(m)+1);
			    			}else {
			    				records.put(m, 1);
			    			}
		    			}
		    			
		    		}
		    		
		    	}
		    	if (q.isEmpty()) {
		    		entries.remove();
		    	}
		    }
		}
		
		return records; // this line is here only so this code will compile if you don't modify it
	}
}
