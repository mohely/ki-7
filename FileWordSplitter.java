import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWordSplitter {
    //Fields
    private ArrayList<String> words = new ArrayList<>();
    
    //Getters
    public ArrayList<String> getWords(){
        return words;
    }

    //Consructor
    public FileWordSplitter(String filename){
        try {
            // Attempt to open a text file
            BufferedReader file = new BufferedReader(new FileReader("src/" + filename));
            
            // Try to read the first line of the file
            String line = file.readLine();
            
            // Keep reading while there are lines left
            while (line != null){
                //Split the line where " " exists. 
                String[] lineWords = line.split(" ");
                
                //add the words from the split line in to words.
                for(String w : lineWords){
                    words.add(w.toLowerCase());
                }

                line = file.readLine();
            }

            //Closeing the file
            file.close();
            // Handle any errors that come up, such as the file not existing
        } 
        catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            // Exit the program    
            System.exit(1);     
        }
    }

    //Methods


    //Main
    public static void main(String[] args) {
        FileWordSplitter splitter = new FileWordSplitter("hamlet.txt");
        ArrayList<String> hamletWords = splitter.getWords();
        System.out.println(hamletWords.get(3)); // Get the fourth word in hamlet.txt
        
    }
}
