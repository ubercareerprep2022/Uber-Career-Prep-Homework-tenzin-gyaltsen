package Assignment1;

import java.util.HashMap;
import java.util.List;

public class Part2 {
    
    public static boolean isStringPermutation(String s1, String s2) {
        boolean result = true;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            if(s1Map.containsKey(s1.charAt(i))) {
                s1Map.put(s1.charAt(i), s1Map.get(s1.charAt(i))+1);
            }
            else {
                s1Map.put(s1.charAt(i),1); 
            }
        }

        for(int i = 0; i < s2.length(); i++){
            if(s2Map.containsKey(s2.charAt(i))) {
                s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i))+1);
            }
            else {
                s2Map.put(s2.charAt(i),1); 
            }
        }

        for(Character character : s1Map.keySet()){
            if(!s2Map.containsKey(character)){
                result = false;
                break;
            }
            else if (s1Map.get(character) != s2Map.get(character)) {
                result = false;
                break;
            }

        }


        return result;
    }


    public static List<List<Integer>> pairsThatEqualSum(List<Integer> inputArray, Integer targetSum) {
        
        return null;
    }


    public static void main(String[] args) {

        // isStringPermutation(...) test codes
        System.out.println(isStringPermutation("asdf", "fsda"));
        System.out.println(isStringPermutation("asdf", "fsa"));
        System.out.println(isStringPermutation("asdf", "fsax"));
        System.out.println(isStringPermutation("ff", "fsda"));
        System.out.println(isStringPermutation("aa", "aa"));

        // pairsThatEqualSum(...) test codes
        
    }


}
