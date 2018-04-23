import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {

		List<Sentence> sentences = new ArrayList<>();
	    if (filename == null) return sentences;	    
	    
	    String line;
	    int score;
	    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	    	while ((line = br.readLine()) != null) {
	    		try {
	    			int spaceIndex = line.indexOf(" ");
	    			score = Integer.parseInt(line.substring(0, spaceIndex));
	    			String text = line.substring(spaceIndex + 1);
	    			if (score <=2 && score >=-2) {
	    				sentences.add(new Sentence(score, text));	    				
	    			}
	    		}catch(Exception e) {
	    			continue;
	    		}
	    	}
	    }catch (IOException e) {
	        e.printStackTrace();
	    }
		
		return sentences; 
	}
	
	/*
	 * Implement this method in Part 2
	 * to retrieve an object in a hashset, need to convert set to array,See https://stackoverflow.com/questions/12014641/java-retrieving-an-element-from-a-hashset
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {

		List<Word> words = new ArrayList<>();
		if ((sentences == null) || sentences.isEmpty()) return new HashSet<>(words);
		for (Sentence s: sentences) {
			if (s == null || s.getText() == null) continue;
			String[] tks = s.getText().toLowerCase().split(" ");
			for (String tk: tks) {
				if(Character.isLetter(tk.charAt(0))) {
					Word w = new Word(tk);
					w.increaseTotal(s.getScore());
					if (words.contains(w)) {
						words.get(words.indexOf(w)).increaseTotal(w.getTotal());
					}else {
						words.add(w);
					}
				}
			}
		}
		
		return new HashSet<Word>(words);
	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		Map<String, Double> map = new HashMap<String, Double>();
		if (words != null && !words.isEmpty()) {
			for (Word w: words) {
				if (w != null) {
					map.put(w.text, w.calculateScore());
				}
			}
		}
		return map;		
	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		double totalScore = 0;
		int count = 0;
		if (wordScores == null || wordScores.isEmpty() || sentence == null || sentence.isEmpty()) return 0;
		String[] tks = sentence.toLowerCase().split(" ");
		for (String tk: tks) {
			if(Character.isLetter(tk.charAt(0))){
				if(wordScores.containsKey(tk)) {
					totalScore += wordScores.get(tk);
				}
				count++;
			}
		}
		return totalScore == 0 ? 0 : totalScore / count; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
