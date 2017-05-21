import java.util.*;
import java.io.*;

public class CrossReference {
    private String[][] index;
    public CrossReference(String[][] i, File f) throws IOException {
        index = i;
        crossReference(f);
    }
    /**
	* Parses through URLs extracted from personal history to find keywords
	* @param string to parse
	*/
    String keyWords(String str) throws IOException {
		Scanner scan = new Scanner(new File("./reference files/words.txt"));
		boolean isWord = false;
		String ret = "";
		ArrayList<String> array = new ArrayList<String>();
		String[] arr = (str.replaceAll("[^a-zA-Z]", " ")).split(" ");
		for(String s : arr) {
			array.add(s);
	        for(String w : s.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
	            array.add(w); 
	        }
		}
		array = new ArrayList<String>(new LinkedHashSet<String>(array));
		for(int i = 0; i < array.size(); i++) {
		    String word = array.get(i);
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				if(line.equalsIgnoreCase(word)) {
					isWord = true;
					break;
				}
			}
			scan = new Scanner(new File("./reference files/words.txt"));
			if(!isWord) {
				array.remove(word);
				i--;
			}
			isWord = false;
		}
		scan.close();
		array = new ArrayList<String>(new LinkedHashSet<String>(array));
		for(String s : array) {
			ret += s + "\n";
		}
		return ret;
	}
	/*
	* Method called to cross reference the users personal history to the algorithm 
	* @param personal history file
	*/
	void crossReference(File f) throws IOException {
		File file = new File("./reference files/xref.txt"); 
		PrintWriter pw = new PrintWriter(file);
		System.out.print("                                                                                              \r");
		int x = 0;
		Scanner scan = new Scanner(f);
		while(scan.hasNextLine()) {
			scan.nextLine();
			x++;
		}
		scan = new Scanner(f);
		int y = 0;
		while(scan.hasNextLine()) {
			pw.println(keyWords(scan.nextLine()));
			System.out.print("Cross referencing: " + (int)((double)y * 100.0 / (double)x) + "%\r");
			y++;
		}
		pw.close();
		scan = new Scanner(f);
		while(scan.hasNextLine()) {
			String ref = scan.nextLine();
			for(int i = 0; i < index.length; i++)
				for(int j = 0; j < index[0].length; j++) 
					if(index[i][j] != null && index[i][j].equalsIgnoreCase(ref))
						index[i][j] = null;
		}
		scan.close();
	}
	String[][] getIndex() {
	    return index;
	}
}