import java.util.*;
import java.io.*;
public class Dictionaries {
    private String searches;
    public Dictionaries(String srchs) throws IOException {
        searches = srchs;
        dictionaryIndex();
    }
    /*
	* Adds searches from an external dictionary file. This can be modified if necessary.
	*/
    void dictionaryIndex() throws IOException {
		//adds searches from provided dictionary database
		File dictionary = new File("./reference files/dictionary.txt");
		Scanner scan = new Scanner(dictionary);
		while(scan.hasNextLine())
			searches += scan.nextLine() + "\n";
		scan.close();
		System.out.print("                                                                                              \r");
		System.out.println("dict done");
	}
	String getSearches() {
	    return searches;
	}
}