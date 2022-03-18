package Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Part2 {
    
    // Question 1
    public static boolean isStringPermutation(String s1, String s2) {
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        // put both string s1 and s2 in a hashmap
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

        // This checks if there is any character that is not in s2.
        // return false if that is the case
        for(Character character : s1Map.keySet()){
            if(!s2Map.containsKey(character)){
                return false;
            }
            else if (s1Map.get(character) != s2Map.get(character)) {
                return false;
            }

        }

        // return true if the conditions were met
        return true;
    }


    // Question 2
    public static List<List<Integer>> pairsThatEqualSum(List<Integer> inputArray, Integer targetSum) {
        List<List<Integer>> finNumList = new ArrayList<>(); // a list to return in the end
        HashMap<Integer,Integer> numMap = new HashMap<>(); // a hashmap that stores input array list numbers

        // stores the number in a hashmap
        for(int i = 0; i < inputArray.size(); i++){
            numMap.put(inputArray.get(i), 1);
        }

        // adds the number and it is corresponding number that sums to target sum if that number exist in numMap hashmap
        for(int j : numMap.keySet()) {
            if(numMap.containsKey(targetSum - j)) {
                List<Integer> pairSum = new ArrayList<>();
                pairSum.add(j);
                pairSum.add(targetSum -j);

                finNumList.add(pairSum);
            } 
        }

        // To deal with list redundancies. Ex: (1,3), or (3,1)
        // The below loop will remove existing redundancies in the finNumList
        int listSize = finNumList.size();

        // As it loops within the size of the finNumList, 
        // It checks if there is a same number in the end of list's list values such as [(3,1), (1,3)] which is redundant
        // and must be removed to [(1,3)] as the final list
        for(int k = 0; k < listSize; k++) {
            List<Integer> listToCheck = new ArrayList<>();
            listToCheck.add(finNumList.get(k).get(1));
            listToCheck.add(finNumList.get(k).get(0));

            if(finNumList.contains(listToCheck)) {
                finNumList.remove(listToCheck);
                listSize --;
            }
        }
 
        return finNumList;
    }


    public static void main(String[] args) {

        // isStringPermutation(...) test codes
        System.out.println(isStringPermutation("asdf", "fsda"));
        System.out.println(isStringPermutation("asdf", "fsa"));
        System.out.println(isStringPermutation("asdf", "fsax"));
        System.out.println(isStringPermutation("ff", "fsda"));
        System.out.println(isStringPermutation("aa", "aa"));


        // pairsThatEqualSum(...) test codes
        // assuming that the numbers are positive and I will sort it
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);

        Collections.sort(testList);

        System.out.println(pairsThatEqualSum(testList, 5));
        System.out.println(pairsThatEqualSum(testList, 1));
        System.out.println(pairsThatEqualSum(testList, 7));
    }


}
