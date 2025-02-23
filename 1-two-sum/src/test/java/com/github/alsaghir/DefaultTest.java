package com.github.alsaghir;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class DefaultTest 
 {

    @Test
    void whenValidInputThenCorrectResponse() {

         // Given
         int[] nums1 = new int[]{2,7,11,15};
         int target1 = 9;
         int[] expected1 = new int[]{0, 1};
 
         int[] nums2 = new int[]{3,2,4};
         int target2 = 6;
         int[] expected2 = new int[]{1,2};
 
         int[] nums3 = new int[]{3,3};
         int target3 = 6;
         int[] expected3 = new int[]{0, 1};

         //When
         int[] result1 = new Solution().twoSum1(nums1, target1);
        int[] result2 = new Solution().twoSum1(nums2, target2);
        int[] result3 = new Solution().twoSum1(nums3, target3);

        // Then
        Assertions.assertArrayEquals(expected1, result1);
        Assertions.assertArrayEquals(expected2, result2);
        Assertions.assertArrayEquals(expected3, result3);

    }

}
