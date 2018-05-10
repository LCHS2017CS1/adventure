import acm.program.ConsoleProgram;
import java.util.Arrays;
import java.util.List;

/**
 * Main class for text adventure game.
 *
 * @author LCHS Computer Science I
 * @version Spring 2018
 */
public class Adventure extends ConsoleProgram
{
    private static final String PROMPT = "> ";
    private static final String FONT = "Consolas-plain-22";
    private static final String QUIT = "quit";
    
    private static final List<String> STOPWORDS =
        Arrays.asList("a", "an", "the");
        
    public static void main(String[] args) {
        new Adventure().start();
    }
    
    public void run() {
        setFont(FONT);
        printInitialMessage();
        while(true) {
            String line = readLine(PROMPT);
            if(line.equals(QUIT)) {
                System.exit(0);  // end program
            }
            String result = eval(line);
            println(result);
        }
    }
    
    private void printInitialMessage() {
        println("Initial message goes here");
    }
    
    private String eval(String line) {
        String[] words = breakIntoWords(line);
        return "OK";
    }
    
    private String[] breakIntoWords(String line) {
        line = line.toLowerCase().replaceAll("[^ a-z0-9]", "");
        List<String> wordList = Arrays.asList(line.split("\\s+"));
        wordList.removeAll(STOPWORDS);
        return wordList.toArray(new String[wordList.size()]);
    }
        
}
