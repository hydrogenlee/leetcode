package leetcode.code_0031_0040;

public class Code_0033_Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        System.out.println(Solution.search(new int[]{1}, 1));                       // 0
        System.out.println(Solution.search(new int[]{2, 1}, 1));                    // 1
        System.out.println(Solution.search(new int[]{2, 1}, 2));                    // 0
        System.out.println(Solution.search(new int[]{1, 2}, 1));                    // 0
        System.out.println(Solution.search(new int[]{1, 2}, 2));                    // 1
        System.out.println(Solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));     // 4
        System.out.println(Solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));     // -1
        System.out.println(Solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));     // 1
    }
    // 是按照一个不固定的支点旋转的，并不一定是按照中间旋转的，一定要注意这点
    // 思路：首先判断一下中点是位于旋转支点的左侧还是右侧，然后比较中点值和目标值的大小，判断出是往左移还是右移
    // T-C: O(logN)
    static class Solution {
        public static int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            if (nums.length == 1) {
                return target == nums[0] ? 0 : -1;
            }
            int result = -1;
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] >= nums[start]) {
                    // 中点在左半侧
                    if (nums[mid] < target) {
                        start = mid + 1;        // 往右边找
                    } else {
                        if (target < nums[start]) {
                            start = mid + 1;    // 往右边找
                        } else if (target >= nums[start]) {
                            end = mid - 1;      // 往左边找
                        }
                    }
                } else {
                    // 中点在右半侧
                    if (nums[mid] > target) {
                        end = mid - 1;          // 往左边找
                    } else {
                        if (target <= nums[end]) {
                            start = mid + 1;    // 往右边找
                        } else {
                            end = mid - 1;      // 往左边找
                        }
                    }
                }
            }
            return result;
        }
    }
}