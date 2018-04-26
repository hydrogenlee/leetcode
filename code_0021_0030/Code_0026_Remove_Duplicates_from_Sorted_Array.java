package leetcode.code_0021_0030;

public class Code_0026_Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        System.out.println(Solution.removeDuplicates(nums1));
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(Solution.removeDuplicates(nums2));
    }
    static class Solution {
        public static int removeDuplicates(int[] nums){
            if (nums.length <= 1) {
                return nums.length;
            }
            // nums.length > 1
            int len = 0;
            for(int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[len]) {
                    nums[++len] = nums[i];
                }
            }
            // 因为len是从0开始的，所以加1
            return len + 1;
        }
    }
}
