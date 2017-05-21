import java.util.*;
import java.io.*;
import java.net.*;
public class Search {
    private String[][] index;
    public Search(String[][] i, String path) throws IOException {
        try {
            index = i;
            search(randomizer(path));
        }
        catch(URISyntaxException use) {
			System.out.println("error: somehow Josh's fault");
		}
    }
    /**
	* Randomly chooses searches to perform
	* @param path of file
	*/
	File randomizer(String path) throws IOException {
		File ret = new File(path);
		PrintWriter p = new PrintWriter(ret);
		for(String[] i : index) {
			String s = null;
			while(s == null) {
				s = i[(int)(Math.random() * i.length)];
				if(s != null)
					break;
			}
			p.println(s);
		}
		p.close();
		return ret;
	}
	/**
	* Searches all lines from File f
	* @param File f
	*/
	void search(File f) throws IOException, URISyntaxException {
		System.out.print("                                                                                              \r");
		Scanner scan = new Scanner(f);
		double c = 0;
		while(scan.hasNextLine()) {c++; scan.nextLine();}
		scan = new Scanner(f);
		for(double i = 0; scan.hasNextLine(); i++) { 
			search(scan.nextLine());
			System.out.print("Search: " + (int)(i / c * 100) + "%\r");
		}
		scan.close();
		System.out.print("                                                                                              \r");
		System.out.print("Search: done\r");
		System.out.print("                                                                                              \r");
	}
	/**
	* Searches google for the given searchTerm
	* @param searchTerm to search with google
	*/
	void search(String searchTerm) throws IOException, URISyntaxException {
		try {
			String url = "https://www.google.com/search?q=" + searchTerm.replace(" ", "+") + "&tbm=isch";
			//if(Desktop.isDesktopSupported()) {
			//	Desktop.getDesktop().browse(new URI(url));
			//}
			HttpURLConnection google = (HttpURLConnection)(new URL(url)).openConnection();
			System.setProperty("http.agent", "");
			google.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			BufferedReader br = new BufferedReader(new InputStreamReader(google.getInputStream()));
			br.close();
		}
		catch(MalformedURLException mue) {System.out.println("error: internet?");}
	}
}