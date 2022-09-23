
/**
 * The StringPermuter class has a baseWord, and allows
 * someone to get permutations of that word.  The purpose
 * is to find a word that is "close" to baseWord.  This way, if 
 * baseWord is misspelled, we can find a word that's correctly
 * spelled which is "close" to baseWord, aka a spellchecker.
 */
public class StringPermuter
{
    private String baseWord;

    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private String[] permutations;


    public StringPermuter(String word) 
    {
        baseWord = word;
        int numPermutations = (word.length()+1)*26 + word.length() + word.length()-1 + word.length()*26;
        permutations = new String[numPermutations];
        int index = 0;
        for(int i = 0; i <= baseWord.length(); i++){
            for(int k = 0; k < alphabet.length(); k++){
                permutations[index] = (baseWord.substring(0, i) + alphabet.charAt(k) + baseWord.substring(i, baseWord.length()));
                index++;
            }
        }

        for(int i = 0; i < baseWord.length(); i++){
            permutations[index] = (baseWord.substring(0, i) + baseWord.substring(i+1, baseWord.length()));
            index++;
        }

        for(int i = 0; i < baseWord.length()-1; i++){
            permutations[index] = (baseWord.substring(0, i) + baseWord.charAt(i+1) + baseWord.charAt(i) + baseWord.substring(i+2, baseWord.length()));
            index++;
        }

        for(int i = 0; i < baseWord.length(); i++){
            for(int k = 0; k < alphabet.length(); k++){
                permutations[index] = (baseWord.substring(0, i) + alphabet.charAt(k) + baseWord.substring(i+1, baseWord.length()));
                index++;
            }
        }


    }
    
    //returns true if goodWord is a potential match for baseWord
    //false if it isn't
    //initially we will permute baseWord and see if any of the permutations 
    //match goodWord.  Later on we can make a list of permutations in 
    //the constructor, so we only need to genereate the permutations once
    //instead of doing so everytime isMatch is called
    public boolean isMatch(String goodWord)
    {
        for(int i = 0; i<permutations.length; i++){
            if(permutations[i].equals(goodWord)){
                return true;
            }
        }
        return false;
    }
    
    /*
    
    //The methods below are to help practice writing the isMatch method
    
    //This method should modify the word by adding a letter to it
    //E.g. hello -> ahello, bhello, ... haello, hbello, ... helloz
    private void printAllAdditions() 
    {
        for(int i = 0; i <= baseWord.length(); i++){
            for(int k = 0; k < alphabet.length(); k++){
                System.out.println(baseWord.substring(0, i) + alphabet.charAt(k) + baseWord.substring(i, baseWord.length()));
            }
        }
    }
    
    //Here we remove a letter from the word
    //hello -> ello, hllo, helo, helo, hell
    private void printAllDeletions() 
    {
        for(int i = 0; i < baseWord.length(); i++){
            System.out.println(baseWord.substring(0, i) + baseWord.substring(i+1, baseWord.length()));
        }
    }
    
    //Here we look at swapping two adjacent letters
    //hello -> ehllo, hlelo, hello, helol
    private void printAllSwaps() 
    {
        for(int i = 0; i < baseWord.length()-1; i++){
            System.out.println(baseWord.substring(0, i) + baseWord.charAt(i+1) + baseWord.charAt(i) + baseWord.substring(i+2, baseWord.length()));
        }
    }
    
    //Here we exchange each letter with a different letter
    //hello -> aello, bello, cello, ... , hallo, hbllo, ... hellz
    private void printAllExchanges() 
    {
        for(int i = 0; i < baseWord.length(); i++){
            for(int k = 0; k < alphabet.length(); k++){
                System.out.println(baseWord.substring(0, i) + alphabet.charAt(k) + baseWord.substring(i+1, baseWord.length()));
            }
        }
    }

    */

    public static void printArray(String [] arrayToPrint)
    {
        for (int i = 0; i < arrayToPrint.length; i++) 
        {
            System.out.print(arrayToPrint[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //StringPermuter sp = new StringPermuter("hellop");
        //sp.printAllAdditions();
        //sp.printAllDeletions();
        //sp.printAllSwaps();
        //sp.printAllExchanges();
        //printArray(sp.permutations);
        //System.out.println(sp.isMatch("hello"));

        
    }
}
