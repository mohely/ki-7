import java.util.HashMap;

public class FileTextAnalyzer {
    //Fields
    private FileWordSplitter words;
    private HashMap<String, Integer> wordOccurrences;
    
    //Getters
    public HashMap<String, Integer> getwordOccurrences(){
        return wordOccurrences;
    }

    //Constructor
    public FileTextAnalyzer(String filename){
        words = new FileWordSplitter(filename);
        wordOccurrences = new HashMap<>();

        for(String word : words.getWords()){
            if(!wordOccurrences.containsKey(word)){
                wordOccurrences.put(word, 1);
            }
            else{
                wordOccurrences.merge(word, 1, Integer::sum);
            }
        }
    }

    //Methods
    public int wordCount(){
        return words.getWords().size();
    }

    public double frequencyOf(String word){
        return ((occurrencesOf(word) + 0.0) / (wordCount() + 0.0 ));
    }

    public int occurrencesOf(String word){
        String lWord = word.toLowerCase();
        return (words.getWords().contains(lWord) ? getwordOccurrences().get(lWord) : 0);
    }

    public int uniqueWordCount(){
        return wordOccurrences.size();
    }

    //Main
    public static void main(String[] args) {
        FileTextAnalyzer e = new FileTextAnalyzer("hamlet.txt");
        System.out.println(e.wordCount());                  //30720
        System.out.println(e.occurrencesOf("Hamlet")); //92
        System.out.println(e.frequencyOf("Hamlet"));   //0.002994791666666667     
        System.out.println(e.frequencyOf("Hamlet"));   //0.002994791666666667     
        System.out.println(e.uniqueWordCount());            //4810
    }
}
