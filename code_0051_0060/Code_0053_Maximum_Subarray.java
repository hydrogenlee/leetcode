package leetcode.code_0051_0060;

public class Code_0053_Maximum_Subarray {
    public static void main(String[] args) {
        System.out.println(Solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    static class Solution {
        public static int maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
            int tempSum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (tempSum + nums[i] < nums[i]) {
                    tempSum = nums[i];
                } else {
                    tempSum += nums[i];
                }
                maxSum = Math.max(maxSum, tempSum);
            }
            return maxSum;
        }
    }
}
