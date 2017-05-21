{"filter":false,"title":"Browswer.java","tooltip":"/Browswer.java","undoManager":{"mark":0,"position":0,"stack":[[{"start":{"row":0,"column":0},"end":{"row":134,"column":1},"action":"insert","lines":["import java.io.*;","","public class Browser {","","\tprivate boolean browsing;","\tprivate WebVisit currentVisit;","\tprivate WebVisit noname;","","\t/**","\t  * Main method for the application. Create a new Browser object and set it to run.","\t  */","\tpublic static void main(String[] args) {","\t\tBrowser b = new Browser();","\t\tb.run();","\t}","","\t/**","\t  * Constructor for the Browser. Welcome the user and initialize the instance variables.","\t  */","\tpublic Browser() {","\t\tbrowsing = true;","\t\tcurrentVisit = null;","\t\tSystem.out.println(\"Welcome to FCS Browser v0.01\");","\t}","","\t/**","\t  * The primary method for the web browser: while the user is browsing the web, continually prompt, read, and execute commands.","\t  */","\tpublic void run() {","\t\tBufferedReader br = new BufferedReader(new InputStreamReader(System.in));","\t\twhile (browsing) {","\t\t\ttry {","\t\t\t\tpromptUser();","\t\t\t\tString cmd = br.readLine();","\t\t\t\tinterpretAndExecute(cmd);","\t\t\t} catch (IOException e) {","\t\t\t\tSystem.out.println(\"Oops! There was an error reading your command.\");","\t\t\t}","\t\t}","\t}","","\t/**","\t  * Prompt the user with a message to the command line.","\t  */","\tprivate void promptUser() {","\t\tSystem.out.println(\"\\nBrowser ready.\\n(Commands: visit *web url*; history; back; quit; forward ;)\");","\t}","","\t/**","\t  * Given a string, determine which command (if any) is being issued and execute it","\t  *  hint: splitting at \" \" will be useful","\t  *  hint: notice that comparing Strings requires use of the .equals() method. Let's talk about it.","\t  * @param cmd The complete string entered by the user","\t  */","\tprivate void interpretAndExecute(String cmd) {","\t\tString[] commands = cmd.split(\" \");","\t\tif (cmd.equals(\"back\")) {","\t\t\tgoBack();","\t\t} else if (cmd.equals(\"history\")) {","\t\t\tviewHistory();","\t\t} else if (commands[0].equals(\"visit\")) {","\t\t\tvisitPage(commands[1]);","\t\t} else if (cmd.equals(\"quit\")) {","\t\t\tquit();","\t\t} else if (cmd.equals(\"forward\")){","\t\t\tgoForward();","","\t\t}else {","\t\t\tSystem.out.println(\"Command not recognized\");","\t\t}","\t}","","\t/**","\t  * Create a new WebVisit object according to the URL passed in, move it to the top of the stack.","\t  * @param url The URL of the new webpage the user would like to visit","\t  */","\tprivate void visitPage(String url) {","\t\tSystem.out.println(\"Now going to visit \"+url);","\t\tWebVisit wv = new WebVisit(url, currentVisit,nn);","\t\tnn = null;","\t\tcurrentVisit = wv;","\t\tSystem.out.println(currentVisit);","\t}","\t/**","\t  * If there is a previous visit in the browser's history, pop the current one off the top of the stack","\t  *  and print out the browser's new page (if it exists). If there is no page to go back to, alert the user and do nothing.","\t  */","\tprivate void goBack() {","\t\tif (currentVisit) {","\t\t\tSystem.out.println(\"Going back...\");","\t\t\tnextVisit= currentVisit;","\t\t\tcurrentVisit = currentVisit.getPreviousNode();","\t\t\tif (currentVisit != null) {","\t\t\t\tSystem.out.println(currentVisit);","\t\t\t}","\t\t} else {","\t\t\tSystem.out.println(\"No web visits in browser history\");","\t\t}","\t}","","\tprivate void goForward() {","\t\tif (currentVisit) {","\t\t\tSystem.out.print(\"Going forward...\");","\t\t\tcurrentVisit = currentVisit.getNextNode();","\t\t\tnextVisit = currentVisit.getNextNode();","\t\t\tif (currentVisit) {","\t\t\t\tSystem.out.println(currentVisit);","\t\t\t} else {","\t\t\t\tSystem.out.println(\"No next page to show.\");","\t\t\t}","\t\t}","\t}","","\t/**","\t  * View a list of all WebVisits in the browser's history; list the total number of visits.","\t  */","\tprivate void viewHistory() {","\t\tSystem.out.println(\"Showing browser history...\");","\t\tWebVisit tmp = currentVisit;","\t\tint counter = 0;","\t\twhile (tmp != null) {","\t\t\tSystem.out.println(\"\\t~\"+tmp);","\t\t\ttmp = tmp.getPreviousNode();","\t\t\tcounter++;","\t\t}","\t\tSystem.out.println(\"\\t\\t\"+counter+\" total\");","\t}","\t/**","\t  * Say goodbye; quit the program.","\t  */","\tprivate void quit() {","\t\tSystem.out.println(\"Quitting now...\");","\t\tbrowsing = false;","\t}","}"],"id":1}]]},"ace":{"folds":[],"scrolltop":0,"scrollleft":0,"selection":{"start":{"row":134,"column":1},"end":{"row":134,"column":1},"isBackwards":false},"options":{"guessTabSize":true,"useWrapMode":false,"wrapToView":true},"firstLineState":0},"timestamp":1495307526753,"hash":"a72e3acd0b064ec1a75b8d35a3a50f72554114c8"}