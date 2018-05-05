package leetcode.code_0011_0020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_0018_4Sum {
    public static void main(String[] args) {
        printList(Solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
    private static void printList(List<List<Integer>> lists) {
        if (lists != null) {
            for (List<Integer> list: lists) {
                for (Integer i: list) {
                    System.out.printf(i + " ");
                }
                System.out.println();
            }
            System.out.println("==============================");
        }
    }
    // 双指针
    static class Solution {
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            if (nums == null || nums.length < 4) {
                return lists;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                // 去重
                while (i >= 1 && i < nums.length - 3 && nums[i] == nums[i - 1]) {
                    i++;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    // 去重
                    while (j >= i + 2 && j < nums.length - 2 && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        int total = nums[i] + nums[j] + nums[left] + nums[right];
                        if (total == target) {
                            lists.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                            // 去重
                            while (left < right && nums[left] == nums[left - 1]) left++;
                            while (left < right && nums[right] == nums[right + 1]) right--;
                        } else if (total < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return lists;
        }
    }
}