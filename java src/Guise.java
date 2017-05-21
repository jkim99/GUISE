import java.util.*;
import java.io.*;
import java.net.*;
public class Guise {
    final static int[] countries = {1, 3, 5, 8, 9, 13, 15, 16, 17, 18, 19, 21, 25, 26, 27, 30, 31, 32, 34, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 49, 50, 51, 52, 53, 54};
    public static void main(String args[]) {
        try {
			while(true) {
		        Process p = Runtime.getRuntime().exec("bash /java src/sqlite3script.bash");
		        p.waitFor();
		        p.destroy();
		        File personalIndex = new File("out123.csv");
		        
				int searchLines = 0;
				String searches = "";
				
			    GoogleInfo g = new GoogleInfo(countries, searches);
			    Dictionaries d = new Dictionaries(g.getSearches());
			    g.setSearches(d.getSearches());
			    g.googleSearchIndex(7);
				CrossReference c = new CrossReference(g.getIndex(), personalIndex);
				Search s = new Search(c.getIndex(), "./reference files/end.txt");
				System.out.print("Waiting...");
				Thread.sleep(60000); 
			}
		}
		catch(UnknownHostException uhe) {
			System.out.println("error: internet?");
		}
		catch(IOException ioe) {
			System.out.println("error: io" + ioe.toString());
		}
		catch(InterruptedException ie) {
			System.out.println("error: interrupted");
		}
		catch(Exception e) {
			System.out.println("error: " + e.toString());
		}
		finally {
			System.exit(0);
		}
	}
}