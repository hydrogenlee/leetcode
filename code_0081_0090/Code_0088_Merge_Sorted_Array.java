package leetcode.code_0081_0090;

public class Code_0088_Merge_Sorted_Array {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        Solution.merge(nums1, m, nums2, n);     // 1 2 2 3 5 6

        for (int i = 0; i < m + n; i++) {
            System.out.printf(nums1[i] + " ");
        }
        System.out.println();
    }

    static class Solution{
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n <= 0) {
                return;
            }
            int num1Index = m - 1;
            int num2Index = n - 1;
            int end = m + n - 1;
            while (end >= 0 && num1Index >= 0 && num2Index >= 0) {
                if (nums1[num1Index] >= nums2[num2Index]) {
                    nums1[end--] = nums1[num1Index--];
                } else {
                    nums1[end--] = nums2[num2Index--];
                }
            }

            // 如果是num1Index >= 0 则不需要移动
            // 如果是num2Index >= 0，则需要将nums2的元素移动到nums1上去
            while (num2Index >= 0) {
                nums1[end--] = nums2[num2Index--];
            }
        }
    }

}
