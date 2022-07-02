package LeetCode;

import java.util.*;


/**
Write a function that takes an array of words and returns all the compound words and the word parts. 
A compound word is made of two word parts. 
For example, the compound word "highway" is made up of the word parts "high" and "way". 

var words = ["star", "rock", "rockstar", "rocks", "tar", "super", "highway", "superhighway", "high", "way"];
*/

/*
 rockstar
 star
  star
   star
    star
 */

// for loop with one word comparing the rest of the word : ie: nested loop
// iterate char in words by words to the end of its length, and then see if the reuslting string is equal? If true :
    // for loops to check if the remaining word exists in the array to confirm that the word is a compound word


public class Problem {
    
    public void findWords (String [] words) {
        HashMap<String, Integer> listOfWords = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            listOfWords.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].length() < words[j].length()) {
                    if (words[i] == words[j].substring(0, words[i].length()-1)) {
                        System.out.print(words[i] + " ");
                        String currWord = words[j].substring(words[i].length(), words[j].length()-1);
                        if (listOfWords.containsKey(currWord)) {
                            System.out.print(currWord);
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    public String compare (String word, String comWord) {
        for (int i = 0; i < comWord.length(); i++) {
            if (word == comWord.substring(i, i + word.length())) {
                return word;
            }
        }
 
        return null;
    }


    public static void main(String[] args) {
        Problem problem = new Problem();

        String [] words = new String[] {"star", "rock", "rockstar", "rocks", "tar", "super", "highway", "superhighway", "high", "way"};

        problem.findWords(words);
    }
}
