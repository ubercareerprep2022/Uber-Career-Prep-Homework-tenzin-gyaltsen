package LeetCode;

import java.util.*;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();

        for (int n : nums) {
            if (!numbers.containsKey(n)) {
                numbers.put(n, 1);
            } else {
                numbers.put(n, numbers.get(n) + 1);
            }
        }

        for (int n : nums) {
            if (numbers.containsKey(target - n)) {
                return new int[] { n, target - n };
            }
        }

        return new int[] { -1, -1 };
    }

    public int[] sortArrayByParity(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int rightIndex = nums.length - 1 - i;
            if ( (nums[i] % 2 == 1) ) {
                int temp = nums[i];
                nums[i] = nums[rightIndex];
                nums[rightIndex] = temp;
                System.out.print(nums[i] + " ");
            }
        }

        System.out.println();
        
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        return nums;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {3,1,2,4};

        s.sortArrayByParity(nums);
    }

}
