package leetcode.code_0031_0040;

public class Code_0031_Next_Permutation {
    public static void main(String[] args) {
        int[] result = {1, 2, 3};
        Solution.nextPermutation(result);
        printArray(result);     // 1->3->2
        result = new int[]{3, 2, 1};
        Solution.nextPermutation(result);
        printArray(result);     // 1->2->3
        result = new int[]{1, 1, 5};
        Solution.nextPermutation(result);
        printArray(result);     // 1->5->1
        result = new int[]{1, 2, 3, 2, 1};
        Solution.nextPermutation(result);
        printArray(result);     // 1->3->1->2->2
        result = new int[]{1, 3, 2};
        Solution.nextPermutation(result);
        printArray(result);     // 2->1->3
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.printf(num + " ");
        }
        System.out.println();
    }

    static class Solution {
        public static void nextPermutation(int[] nums) {
            if (nums.length <= 1) {
                return;
            }
            int i = nums.length - 1;
            for (; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    // 先找到一个大于num[i - 1]的最小的值
                    int min = nums[i];
                    int index = i;
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] > nums[i - 1]) {
                            min = Math.min(min, nums[j]);
                            index = j;
                        }
                    }
                    // 交换i-1和index的值
                    nums[index] ^= nums[i - 1];
                    nums[i - 1] ^= nums[index];
                    nums[index] ^= nums[i - 1];
                    break;
                }
            }
            // 将后续序列改成升序
            int start = i;
            int end = nums.length - 1;
            while (start < end) {
                // 交换
                nums[start] ^= nums[end];
                nums[end] ^= nums[start];
                nums[start] ^= nums[end];
                start++;
                end--;
            }
        }
    }
}