
import java.util.Collections;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	/**
     * This method assumes the input LinkedList is already sorted in non-descending order, inserts the input int value into the correct location of the list.
     * If the input LinkedList is null, this method should simply terminate.
     * @param list
     * @param value
     */
    public static void insertSorted(LinkedList<Integer> list, int value) {
        if (list != null) {
            int index = 0;
            while (index < list.size()) {
                if (list.get(index) < value) {
                index++;                
            }
                else {
                    break;
                }
            }
            list.add(index, value);
        }

        

    }
    
    /**
     * removes all instances of the N largest values in the LinkedList.
     * If the input LinkedList is null or if N is non-positive, this method should simply return without any modifications to the input LinkedList.
     * @param list
     * @param N
     */
    public static void removeMaximumValues(LinkedList<String> list, int N) {
        if (list != null && !list.isEmpty() && N > 0) {
            int counter = 0;
            while(counter < N && counter < list.size()) {
                String top = Collections.max(list);
                while (list.contains(top)){
                    list.remove(top);
                }
                counter++;
            }
        }

    }
    
    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

        if (one != null && !one.isEmpty() && two != null && !two.isEmpty()) {            
            return Collections.indexOfSubList(one, two) != -1;
                  }
        return false;
        }
}

