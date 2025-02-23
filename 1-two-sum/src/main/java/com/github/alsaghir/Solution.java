package com.github.alsaghir;

import java.util.HashMap;

public class Solution {

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) { // n * n
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {

        // will hold key as the number itself from nums input and value as the index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Fill the map with key numbers and value indices
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }


        for (int i = 0; i < nums.length; i++) {
            int numberToFind = target - nums[i];

            // search in the map using the number, if found, get its index
            if (map.containsKey(numberToFind)) { // O(1)
                return new int[]{i, map.get(numberToFind)};
            }
        }
        return new int[0];
    }
}
