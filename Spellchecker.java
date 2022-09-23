
/**
 * The Spellchecker class will manage the database of all correctly
 * spelled words.  You will want to keep track of both the words
 * and the frequency at which those words appear.
 */

import java.util.Scanner;


public class Spellchecker
{

    private wordCount[] database;
    private int index;
    //the constructor should use the FileReader class to read in all
    //of the words contained in the given file.  You will need to keep
    //track of each word and how often it appears
    public Spellchecker(String filename)
    {
        FileReader fr = new FileReader(filename);

        database = new wordCount[1000];
        index = 0;

        while(fr.hasNextWord()){
            String word = fr.getNextWord();

            boolean counted = false;

            for(int i = 0; i<index && !counted; i++){
                if(database[i].word.equals(word)){
                    database[i].count++;
                    counted = true;
                }
            }
            if(!counted){
                if(index == database.length){
                    wordCount[] temp = new wordCount[2*database.length];
                    for(int i = 0; i<database.length; i++){
                        temp[i] = database[i];
                    }
                    database = temp;
                }

                database[index] = new wordCount();
                database[index].word = word;
                database[index].count = 1;
                index++;
            }
        }
    }
    
    //this method will return the correctly spelled word that is
    //the best match for the input word
    //do so by using the StringPermuter class to find permutations of 
    //misspeltWord, and see if any correctly spelt words match a permutation
    public String getBestMatch(String misspeltWord)
    {
        String bestMatch = "NO MATCH";
        int maxCount = 0;
        StringPermuter sp = new StringPermuter(misspeltWord);

        for(int i = 0; i<index; i++){
            if(database[i].count > maxCount && sp.isMatch(database[i].word)){
                bestMatch = database[i].word;
                maxCount = database[i].count;
            }
        }
        
        return bestMatch;
    }
    
    //below is a simple example of how you might use the Spellchecker class
    /*
    public static void test(String misspeltWord)
    {
        Spellchecker sc = new Spellchecker("words.txt");
        String bestMatch = sc.getBestMatch(misspeltWord);
        System.out.println("The best match for " + misspeltWord + " is: " + bestMatch);
    }
    */

    public static void main(String[] args) {
        
        //Spellchecker sc = new Spellchecker("words.txt");

        /*
        for(int i = 0; i<sc.index; i++){
            System.out.println(sc.database[i].word + " " + sc.database[i].count);
        }
        */
        
        //test("hello");
        //test("pictureg");
        //test("coronad");


        

        Spellchecker sc = new Spellchecker("words.txt");

        //example test
        System.out.println("The best match for pictureg is: " + sc.getBestMatch("pictureg"));


        //spellchecks inputted words
        Scanner s = new Scanner(System.in);
        while(true){
            String misspeltWord = s.nextLine();
            if(misspeltWord.equals("END")){
                break;
            }
            String bestMatch = sc.getBestMatch(misspeltWord);
            System.out.println("The best match for " + misspeltWord + " is: " + bestMatch);
        }
        s.close();


    }
}
