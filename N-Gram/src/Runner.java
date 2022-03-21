import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner;
		File f = new File("shrek.txt");
		
		try {
			scanner = new Scanner(f);
			String curr = scanner.next().replaceAll("[^a-zA-Z ]", "").toLowerCase();
			HashMap<String, HashMap<String, Integer>> pairs = new HashMap<String, HashMap<String, Integer>>();
			while(scanner.hasNext()) {
				String next = scanner.next().replaceAll("[^a-zA-Z ]", "").toLowerCase();
				if(!next.equals("") && !next.equals(" ")) {
					if(pairs.containsKey(curr)) {
						if(pairs.get(curr).containsKey(next)) {
							pairs.get(curr).put(next, pairs.get(curr).get(next) +1);
						}else {
							pairs.get(curr).put(next, 1);
						}
					}else {
						HashMap<String, Integer> temp = new HashMap<String, Integer>();
						temp.put(next, 1);
						pairs.put(curr, temp);
					}
				}
				
				
			
				curr = next;
			}
			for(String word : pairs.keySet()) {
				int most = 0;
				String mostWord = "";
				for(String word2:pairs.get(word).keySet()) {
					if(pairs.get(word).get(word2) > most) {
						most = pairs.get(word).get(word2);
						mostWord = word2;
//						System.out.println(word2 + " appears " + most + " times after " + word);
					}
				}	
			}
			int mostThe = 0;
			String theWord = "";
			for(String word2:pairs.get("the").keySet()) {
				if(pairs.get("the").get(word2) > mostThe) {
					mostThe = pairs.get("the").get(word2);
					theWord = word2;
				}
			}
			System.out.println("The most common word that appears after the word 'the' is: " + theWord + " which appears " + mostThe + " times.");
			System.out.println("All of the words which appear after the word 'the' are : " + pairs.get("the").keySet());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
