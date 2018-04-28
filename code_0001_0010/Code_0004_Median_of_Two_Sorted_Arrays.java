package leetcode.code_0001_0010;

public class Code_0004_Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] num1 = {1, 3};
        int[] num2 = {2};
        System.out.println(Solution.findMedianSortedArrays(num1, num2));    // 2
        num1 = new int[]{1, 2};
        num2 = new int[]{3, 4};
        System.out.println(Solution.findMedianSortedArrays(num1, num2));    // 2.5
        num1 = new int[]{};
        num2 = new int[]{1};
        System.out.println(Solution.findMedianSortedArrays(num1, num2));    // 1
        num1 = new int[]{};
        num2 = new int[]{1, 2};
        System.out.println(Solution.findMedianSortedArrays(num1, num2));    // 1.5
        num1 = new int[]{1, 1};
        num2 = new int[]{2, 2, 4, 5};
        System.out.println(Solution.findMedianSortedArrays(num1, num2));    // 2
    }

    // 双指针
    // T-C: O(M+N)
    // S-C: O(1)
    static class Solution {
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 两个都为空数组 （并且不允许有null，有null就直接返回0）
            if (nums1 == null || nums2 == null || nums1.length == 0 && nums2.length == 0) {
                return 0;
            }

            int index = 0;
            int num1Index = 0;
            int num2Index = 0;
            int sum = nums1.length + nums2.length;
            double median = 0;
            double lastMedian = 0;

            for (; index <= sum / 2 && num1Index < nums1.length &&
                    num2Index < nums2.length; index++) {
                lastMedian = median;
                if (nums1[num1Index] <= nums2[num2Index]) {
                    median = nums1[num1Index++];
                } else {
                    median = nums2[num2Index++];
                }
            }
            // 一个数组已经到达尾部，那么在执行过程中，另一个不可能到达尾部
            while (index <= sum / 2) {
                lastMedian = median;
                median = num1Index < nums1.length ? nums1[num1Index++] :nums2[num2Index++];
                index++;
            }
            return sum % 2 == 0 ? (median + lastMedian) / 2 : median;
        }
    }
}