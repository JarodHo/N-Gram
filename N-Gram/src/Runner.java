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
			String curr = scanner.next();
			while(scanner.hasNext()) {
				boolean prev = false;
				String next = scanner.next();
				HashMap<String, String> pairs = new HashMap<String, String>();
				HashMap<HashMap<String, String>, Integer> reps = new HashMap<HashMap<String, String>, Integer>();
				ArrayList<Integer> repetitions = new ArrayList<Integer>();
				if(next.equals(".") || next.equals("!") || next.equals("?") || next.equals("-")) {
					next = scanner.next();
				}
				
				for(String i:pairs.keySet()) {
					if(i.equals(curr) && pairs.get(i).equals(next)) {
						prev = true;
					}
				}
				//start new enhanced for loop for reps
				if(!prev) {
					pairs.put(curr, next);
					reps.put(pairs, 0);
					repetitions.add(0);
				}
				curr = next;
				System.out.println(reps);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
