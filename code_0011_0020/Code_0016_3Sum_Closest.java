package leetcode.code_0011_0020;

import java.util.Arrays;

public class Code_0016_3Sum_Closest {
    public static void main(String[] args) {
        System.out.println(Solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));           // 2
        System.out.println(Solution.threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));     // -2
    }
    private static class Solution {
        public static int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) {
                throw new IllegalArgumentException("输入数组的大小至少为3");
            }
            Arrays.sort(nums);
            int closest = nums[0] + nums[1] + nums[2];      // 初始值

            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int total = nums[i] + nums[left] + nums[right];
                    if (total == target) {
                        return target;
                    } else if (total < target) {
                        left++;
                    } else {
                        right--;
                    }
                    closest = Math.abs(closest - target) <= Math.abs(total - target) ? closest : total;
                }
            }
            return closest;
        }
    }
}