package leetcode.code_0031_0040;

public class Code_0034_Search_for_a_Range {
    public static void main(String[] args) {
        int[] result;
        result = Solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(result[0] + " ~ "+ result[1]);       // 3 ~ 4
        result = Solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(result[0] + " ~ "+ result[1]);       // -1 ~ -1
    }

    // T-C: O(logN)
    static class Solution {
        public static int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }

            return binarySearch(nums, 0, nums.length - 1, target);
        }

        private static int[] binarySearch(int[] nums, int s, int e, int target) {
            if (s > e) {
                return new int[]{-1, -1};
            }
            int start = s;
            int end = e;
            int left = -1;
            int right = -1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    left = mid;
                    right = mid;
                    // 需要判断是否需要继续往左右扩
                    if (mid - 1 >= start && nums[mid - 1] == target) {
                        // 当左侧还能找到一个等于目标值的值时，需要往左扩
                        left = binarySearch(nums, start, mid - 1, target)[0];
                    }
                    if (mid + 1 <= end && nums[mid + 1] == target) {
                        // 当右侧还能找到一个等于目标值的值时需要往右扩
                        right = binarySearch(nums, mid + 1, end, target)[1];
                    }
                    return new int[]{left, right};
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return new int[]{left, right};      // 其实是{-1, -1}
        }
    }
}