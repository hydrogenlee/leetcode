package leetcode.code_0031_0040;

public class Code_0035_Search_Insert_Position {

    public static void main(String[] args) {
        System.out.println(Solution.searchInsert(new int[]{1,3,5,6}, 5));   // 2
        System.out.println(Solution.searchInsert(new int[]{1,3,5,6}, 2));   // 1
        System.out.println(Solution.searchInsert(new int[]{1,3,5,6}, 7));   // 4
        System.out.println(Solution.searchInsert(new int[]{1,3,5,6}, 0));   // 0
    }

    static class Solution {
        // 二分查找
        public static int searchInsert(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }

            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            // start == end
            if (nums[start] >= target) {
                return start;
            } else {
                return start + 1;
            }
        }
    }
}
