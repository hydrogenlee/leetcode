package leetcode.code_0011_0020;

import java.util.*;

public class Code_0015_3Sum {
    public static void main(String[] args) {
        printList(SolutionBruteForce.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        printList(SolutionTwoPointer.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println();
        printList(SolutionBruteForce.threeSum(new int[]{-1, 0, 0, 2, -1, -4}));
        printList(SolutionTwoPointer.threeSum(new int[]{-1, 0, 0, 2, -1, -4}));
        System.out.println();
        printList(SolutionBruteForce.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
        printList(SolutionTwoPointer.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }

    private static void printList(List<List<Integer>> lists) {
        if (lists != null) {
            for (List<Integer> list: lists) {
                for (Integer i: list) {
                    System.out.printf(i + " ");
                }
                System.out.println();
            }
            System.out.println("------------------------------");
        }
    }

    // 暴力求解，超时
    private static class SolutionBruteForce {
        public static List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> lists = new ArrayList<>();
            if (nums == null || nums.length == 0 || nums[0] > 0 || nums[nums.length - 1] < 0) {
                return lists;
            }
            // 第一个数肯定小于等于0
            for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
                // 前两个数小于等于0，才去找第三个数
                for (int j = i + 1; j < nums.length && nums[i] + nums[j] <= 0; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> item = new ArrayList<>();
                            item.add(nums[i]);
                            item.add(nums[j]);
                            item.add(nums[k]);
                            if (!lists.contains(item)) {
                                lists.add(item);
                            }
                        } else if (nums[i] + nums[j] + nums[k] > 0) {
                            break;
                        }
                    }
                }
            }
            return lists;
        }
    }

    // 双指针
    // T-C: O(N^2)
    // S-C: O(1)
    private static class SolutionTwoPointer {
        public static List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> lists = new ArrayList<>();
            if (nums == null || nums.length == 0 || nums[0] > 0 || nums[nums.length - 1] < 0) {
                return lists;
            }
            for (int i = 0; i < nums.length - 2; i++) {
                // 去重
                while (i >= 1 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
                    i++;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int total = nums[i] + nums[left] + nums[right];
                    if (total == 0) {
                        lists.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                        // 去重
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (total < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return lists;
        }
    }
}