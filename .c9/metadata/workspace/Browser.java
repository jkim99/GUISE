{"filter":false,"title":"Browser.java","tooltip":"/Browser.java","undoManager":{"mark":38,"position":38,"stack":[[{"start":{"row":0,"column":0},"end":{"row":134,"column":1},"action":"insert","lines":["import java.io.*;","","public class Browser {","","\tprivate boolean browsing;","\tprivate WebVisit currentVisit;","\tprivate WebVisit noname;","","\t/**","\t  * Main method for the application. Create a new Browser object and set it to run.","\t  */","\tpublic static void main(String[] args) {","\t\tBrowser b = new Browser();","\t\tb.run();","\t}","","\t/**","\t  * Constructor for the Browser. Welcome the user and initialize the instance variables.","\t  */","\tpublic Browser() {","\t\tbrowsing = true;","\t\tcurrentVisit = null;","\t\tSystem.out.println(\"Welcome to FCS Browser v0.01\");","\t}","","\t/**","\t  * The primary method for the web browser: while the user is browsing the web, continually prompt, read, and execute commands.","\t  */","\tpublic void run() {","\t\tBufferedReader br = new BufferedReader(new InputStreamReader(System.in));","\t\twhile (browsing) {","\t\t\ttry {","\t\t\t\tpromptUser();","\t\t\t\tString cmd = br.readLine();","\t\t\t\tinterpretAndExecute(cmd);","\t\t\t} catch (IOException e) {","\t\t\t\tSystem.out.println(\"Oops! There was an error reading your command.\");","\t\t\t}","\t\t}","\t}","","\t/**","\t  * Prompt the user with a message to the command line.","\t  */","\tprivate void promptUser() {","\t\tSystem.out.println(\"\\nBrowser ready.\\n(Commands: visit *web url*; history; back; quit; forward ;)\");","\t}","","\t/**","\t  * Given a string, determine which command (if any) is being issued and execute it","\t  *  hint: splitting at \" \" will be useful","\t  *  hint: notice that comparing Strings requires use of the .equals() method. Let's talk about it.","\t  * @param cmd The complete string entered by the user","\t  */","\tprivate void interpretAndExecute(String cmd) {","\t\tString[] commands = cmd.split(\" \");","\t\tif (cmd.equals(\"back\")) {","\t\t\tgoBack();","\t\t} else if (cmd.equals(\"history\")) {","\t\t\tviewHistory();","\t\t} else if (commands[0].equals(\"visit\")) {","\t\t\tvisitPage(commands[1]);","\t\t} else if (cmd.equals(\"quit\")) {","\t\t\tquit();","\t\t} else if (cmd.equals(\"forward\")){","\t\t\tgoForward();","","\t\t}else {","\t\t\tSystem.out.println(\"Command not recognized\");","\t\t}","\t}","","\t/**","\t  * Create a new WebVisit object according to the URL passed in, move it to the top of the stack.","\t  * @param url The URL of the new webpage the user would like to visit","\t  */","\tprivate void visitPage(String url) {","\t\tSystem.out.println(\"Now going to visit \"+url);","\t\tWebVisit wv = new WebVisit(url, currentVisit,nn);","\t\tnn = null;","\t\tcurrentVisit = wv;","\t\tSystem.out.println(currentVisit);","\t}","\t/**","\t  * If there is a previous visit in the browser's history, pop the current one off the top of the stack","\t  *  and print out the browser's new page (if it exists). If there is no page to go back to, alert the user and do nothing.","\t  */","\tprivate void goBack() {","\t\tif (currentVisit) {","\t\t\tSystem.out.println(\"Going back...\");","\t\t\tnextVisit= currentVisit;","\t\t\tcurrentVisit = currentVisit.getPreviousNode();","\t\t\tif (currentVisit != null) {","\t\t\t\tSystem.out.println(currentVisit);","\t\t\t}","\t\t} else {","\t\t\tSystem.out.println(\"No web visits in browser history\");","\t\t}","\t}","","\tprivate void goForward() {","\t\tif (currentVisit) {","\t\t\tSystem.out.print(\"Going forward...\");","\t\t\tcurrentVisit = currentVisit.getNextNode();","\t\t\tnextVisit = currentVisit.getNextNode();","\t\t\tif (currentVisit) {","\t\t\t\tSystem.out.println(currentVisit);","\t\t\t} else {","\t\t\t\tSystem.out.println(\"No next page to show.\");","\t\t\t}","\t\t}","\t}","","\t/**","\t  * View a list of all WebVisits in the browser's history; list the total number of visits.","\t  */","\tprivate void viewHistory() {","\t\tSystem.out.println(\"Showing browser history...\");","\t\tWebVisit tmp = currentVisit;","\t\tint counter = 0;","\t\twhile (tmp != null) {","\t\t\tSystem.out.println(\"\\t~\"+tmp);","\t\t\ttmp = tmp.getPreviousNode();","\t\t\tcounter++;","\t\t}","\t\tSystem.out.println(\"\\t\\t\"+counter+\" total\");","\t}","\t/**","\t  * Say goodbye; quit the program.","\t  */","\tprivate void quit() {","\t\tSystem.out.println(\"Quitting now...\");","\t\tbrowsing = false;","\t}","}"],"id":1}],[{"start":{"row":0,"column":17},"end":{"row":1,"column":0},"action":"insert","lines":["",""],"id":2}],[{"start":{"row":1,"column":0},"end":{"row":1,"column":1},"action":"insert","lines":["i"],"id":3}],[{"start":{"row":1,"column":1},"end":{"row":1,"column":2},"action":"insert","lines":["m"],"id":4}],[{"start":{"row":1,"column":2},"end":{"row":1,"column":3},"action":"insert","lines":["p"],"id":5}],[{"start":{"row":1,"column":3},"end":{"row":1,"column":4},"action":"insert","lines":["o"],"id":6}],[{"start":{"row":1,"column":4},"end":{"row":1,"column":5},"action":"insert","lines":["r"],"id":7}],[{"start":{"row":1,"column":5},"end":{"row":1,"column":6},"action":"insert","lines":["t"],"id":8}],[{"start":{"row":1,"column":6},"end":{"row":1,"column":7},"action":"insert","lines":[" "],"id":9}],[{"start":{"row":1,"column":7},"end":{"row":1,"column":8},"action":"insert","lines":["j"],"id":10}],[{"start":{"row":1,"column":8},"end":{"row":1,"column":9},"action":"insert","lines":["a"],"id":11}],[{"start":{"row":1,"column":9},"end":{"row":1,"column":10},"action":"insert","lines":["v"],"id":12}],[{"start":{"row":1,"column":10},"end":{"row":1,"column":11},"action":"insert","lines":["a"],"id":13}],[{"start":{"row":1,"column":11},"end":{"row":1,"column":12},"action":"insert","lines":["."],"id":14}],[{"start":{"row":1,"column":12},"end":{"row":1,"column":13},"action":"insert","lines":["n"],"id":15}],[{"start":{"row":1,"column":13},"end":{"row":1,"column":14},"action":"insert","lines":["e"],"id":16}],[{"start":{"row":1,"column":14},"end":{"row":1,"column":15},"action":"insert","lines":["t"],"id":17}],[{"start":{"row":1,"column":15},"end":{"row":1,"column":16},"action":"insert","lines":["."],"id":18}],[{"start":{"row":1,"column":16},"end":{"row":1,"column":17},"action":"insert","lines":["*"],"id":19}],[{"start":{"row":1,"column":17},"end":{"row":1,"column":18},"action":"insert","lines":[";"],"id":20}],[{"start":{"row":79,"column":47},"end":{"row":79,"column":48},"action":"insert","lines":[" "],"id":21}],[{"start":{"row":79,"column":49},"end":{"row":79,"column":50},"action":"remove","lines":["n"],"id":22}],[{"start":{"row":79,"column":49},"end":{"row":79,"column":50},"action":"insert","lines":["u"],"id":23}],[{"start":{"row":79,"column":50},"end":{"row":79,"column":51},"action":"insert","lines":["l"],"id":24}],[{"start":{"row":79,"column":51},"end":{"row":79,"column":52},"action":"insert","lines":["l"],"id":25}],[{"start":{"row":80,"column":0},"end":{"row":80,"column":12},"action":"remove","lines":["\t\tnn = null;"],"id":26}],[{"start":{"row":79,"column":54},"end":{"row":80,"column":0},"action":"remove","lines":["",""],"id":27}],[{"start":{"row":87,"column":1},"end":{"row":87,"column":2},"action":"insert","lines":["/"],"id":28}],[{"start":{"row":87,"column":2},"end":{"row":87,"column":3},"action":"insert","lines":["*"],"id":29}],[{"start":{"row":98,"column":2},"end":{"row":98,"column":3},"action":"insert","lines":["*"],"id":30}],[{"start":{"row":98,"column":3},"end":{"row":98,"column":4},"action":"insert","lines":["/"],"id":31}],[{"start":{"row":98,"column":3},"end":{"row":98,"column":4},"action":"remove","lines":["/"],"id":32}],[{"start":{"row":98,"column":2},"end":{"row":98,"column":3},"action":"remove","lines":["*"],"id":33}],[{"start":{"row":111,"column":2},"end":{"row":111,"column":3},"action":"insert","lines":["*"],"id":34}],[{"start":{"row":111,"column":3},"end":{"row":111,"column":4},"action":"insert","lines":["/"],"id":35}],[{"start":{"row":66,"column":3},"end":{"row":66,"column":4},"action":"insert","lines":["/"],"id":36}],[{"start":{"row":66,"column":4},"end":{"row":66,"column":5},"action":"insert","lines":["/"],"id":37}],[{"start":{"row":58,"column":3},"end":{"row":58,"column":4},"action":"insert","lines":["/"],"id":38}],[{"start":{"row":58,"column":4},"end":{"row":58,"column":5},"action":"insert","lines":["/"],"id":39}]]},"ace":{"folds":[],"scrolltop":975,"scrollleft":0,"selection":{"start":{"row":58,"column":5},"end":{"row":58,"column":5},"isBackwards":false},"options":{"guessTabSize":true,"useWrapMode":false,"wrapToView":true},"firstLineState":{"row":66,"state":"start","mode":"ace/mode/java"}},"timestamp":1495307849309,"hash":"a2b049d716fc4ede08f9c0a50ce591424ffd8f1c"}