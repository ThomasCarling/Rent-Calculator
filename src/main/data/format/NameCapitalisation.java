package data.format;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to correct Capitalisation of a name.
 * 
 * @author Thomas
 *
 */
public class NameCapitalisation {
    
    /**
     * Method to correct the capitalisation of a String.
     * 
     * @param name the String to correct.
     * @return the String, with gaps at the end removed, one 
     * space between each word and each word beginning with a 
     * capital letter.
     * @throws IllegalArgumentException if name is null, or empty.
     */
    public static String correct(String name) throws IllegalArgumentException{
	if (name == null) {
	    throw new IllegalArgumentException();
	}
	name = name.trim();
	if (name.length() == 0) {
	    throw new IllegalArgumentException();
	}
	List<String> words = new ArrayList<>();
	while (name.indexOf(" ") != -1) {
	    int gapIndex = name.indexOf(" ");
	    String firstWord = name.substring(0, gapIndex);
	    firstWord = firstWord.trim();
	    words.add(firstWord);
	    name = name.substring(gapIndex);
	    name = name.trim();
	}
	words.add(name);
	
	name = "";
	for (String myWord : words) {
	    myWord = correctWord(myWord);
	    name += myWord + " ";
	}
	name = name.trim();
	return name;
    }
    
    /**
     * private helper method to correct the capitalisation of
     * a single word.
     * @param word the String to correct.
     * @return the same String, trimmed, and with the first letter 
     * capitalised.
     */
    private static String correctWord(String word) {
	word = word.toLowerCase();
	word = word.substring(0, 1).toUpperCase() + word.substring(1);
	return word;
    }
}
