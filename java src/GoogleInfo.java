import java.util.*;
import java.io.*;
import java.net.*;
public class GoogleInfo {
    private String searches;
    private String[][] index;
    private int searchLines;
    public GoogleInfo(int[] x, String srchs) throws IOException {
        searches = srchs;
        for(int i = 0; i < x.length; i++) {
			getGoogleInfo(x[i]);
			System.out.print("Google Info: " + (int)((double)i / 35.0 * 100) + "%\r");
		}
		System.out.print("Google Info: done\r");
    }
    /**
	 * This methods gets the top 20 searches in the specific country
	 * @param country used to check trends in google
	 */
	void getGoogleInfo(int x) throws IOException, MalformedURLException {
		BufferedReader br = new BufferedReader(new InputStreamReader((new URL("https://trends.google.com/trends/hottrends/atom/feed?pn=p" + x)).openStream()));
		String line, sourceCode = "";
		while((line = br.readLine()) != null)
			sourceCode += line + "\n";
		//parses through source code
		sourceCode = sourceCode.substring(sourceCode.indexOf("<item>") + 6);
		while(sourceCode.contains("<ht:approx_traffic>")) {
			//isolates search title
			searches += sourceCode.substring(0, sourceCode.indexOf("<ht:approx_traffic>")).replace("<title>", "").replace("</title>", "").replace("<item>", "").trim() + "\n";
			searchLines++;
			if(!sourceCode.contains("<item>"))
				break;
			sourceCode = sourceCode.substring(sourceCode.indexOf("<item>") + 6);
		}
		br.close();
	}
    /**
	 * This method takes all searches and transfers them to
	 * a two-dimensional array.
	 * @param number of groups
	 */ 
    void googleSearchIndex(int grps) throws IOException {
		int k = 0;
		String[] str = searches.split("\n");
		index = new String[grps][(searchLines + 100) / grps];
		for(int i = 0; i < index.length; i++) {
			for(int j = 0; j < index[0].length; j++) {
				index[i][j] = str[k];
				k++;
			}
			//shuffling
			index[i] = shuffle(Arrays.asList(index[i]));
		}
		System.out.println("search index done");
	}
	String[] shuffle(java.util.List<String> list) {
		Collections.shuffle(list);
		return (String[])list.toArray();
	}
	void setSearches(String s) {
	    searches = s;
	}
	String getSearches() {
	    return searches;
	}
	String[][] getIndex() {
	    return index;
	}
}