package leetcode.code_0041_0050;

import java.util.*;

public class Code_0041_First_Missing_Positive {
    public static void main(String[] args) {
        System.out.println(Solution.firstMissingPositive(new int[]{1, 2, 0}));              // 3
        System.out.println(Solution.firstMissingPositive(new int[]{3, 4, -1, 1}));          // 2
        System.out.println(Solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));      // 1
        System.out.println("-------------------------------");
        System.out.println(Solution2.firstMissingPositive(new int[]{1, 2, 0}));              // 3
        System.out.println(Solution2.firstMissingPositive(new int[]{3, 4, -1, 1}));          // 2
        System.out.println(Solution2.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));      // 1
    }

    // T-C O(N)
    // S-C O(N)
    private static class Solution {
        public static int firstMissingPositive(int[] nums) {
            int result = 1;
            List<Integer> list = new LinkedList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            int index = 0;
            while (index++ < nums.length){
                if (list.contains(result)) {
                    result++;
                } else {
                    break;
                }
            }
            return result;
        }
    }

    // 核心思想是将 i 和 nums[i] - 1 位置互换，直到nums[i] = i + 1
    private static class Solution2 {
        public static int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 1;
            }
            int i = 0;
            while (i < nums.length) {
                if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                    // 将 i 和 nums[i] - 1 位置互换
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                } else {
                    i++;
                }
            }
            for (int j = 0; j < nums.length; j++) {
                if (j + 1 != nums[j]) {
                    return j + 1;
                }
            }
            return nums.length + 1;
        }
    }
}