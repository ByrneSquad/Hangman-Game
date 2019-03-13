

package program3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {
    private static int NUMBER_OF_WORDS = 81452;
    private static String FILE_NAME = "dictionaryData.txt";
    private String[] dictionary;
    
    Dictionary() {
        dictionary = new String[NUMBER_OF_WORDS];
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(FILE_NAME));
        }catch (FileNotFoundException e) {
            System.out.println("Dictionary class cannot find file \"dictionaryData.txt\".");
            System.out.println("Please make sure that the file is in the project folder.");
            System.exit(0);
        }
        for (int i = 0; i < NUMBER_OF_WORDS; i++) {
            dictionary[i] = inputStream.next();
        }
    }
    
    public String getRandomWord(){
        Random generator = new Random();
        String temp = new String();
        temp += dictionary[generator.nextInt(NUMBER_OF_WORDS)];
        return temp;
    }
    
    public boolean find(String word) {
        int count = 0;
        int lowerIndex = 0;
        int upperIndex = NUMBER_OF_WORDS - 1;
        int middleIndex;
        while(lowerIndex <= upperIndex){
            middleIndex = (lowerIndex + upperIndex) / 2;
            count++;
            if(word.equalsIgnoreCase(dictionary[middleIndex])) { // found it
                return true;
            }
            else if (word.compareToIgnoreCase(dictionary[middleIndex]) < 0) { // word smaller than middle
                upperIndex = middleIndex - 1;
            }
            else { // word is larger than middle
                lowerIndex = middleIndex + 1;
            }
        }
        return false;
    }
}