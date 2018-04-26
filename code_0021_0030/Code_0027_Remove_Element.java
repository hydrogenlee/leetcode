package leetcode.code_0021_0030;

public class Code_0027_Remove_Element {
    public static void main(String[] args) {
        int[] nums1 = {3,2,2,3};
        int len = Solution.removeElement(nums1, 3);
        System.out.println("nums1: " + len);
        for (int i = 0; i < len; i++) {
            System.out.printf(nums1[i] + " ");
        }
        System.out.println("\n-----------------------------------");
        int[] nums2 = {0,1,2,2,3,0,4,2};
        len = Solution.removeElement(nums2, 2);
        System.out.println("nums2: " + len);
        for (int i = 0; i < len; i++) {
            System.out.printf(nums2[i] + " ");
        }

        System.out.println("\n-----------------------------------");
        int[] nums3 = {};
        len = Solution.removeElement(nums3, 0);
        System.out.println("nums3: " + len);
        for (int i = 0; i < len; i++) {
            System.out.printf(nums3[i] + " ");
        }

        System.out.println("\n-----------------------------------");
        int[] nums4 = {1};
        len = Solution.removeElement(nums4, 0);
        System.out.println("nums4: " + len);
        for (int i = 0; i < len; i++) {
            System.out.printf(nums4[i] + " ");
        }

        System.out.println("\n-----------------------------------");
        int[] nums5= {1, 1, 1, 1};
        len = Solution.removeElement(nums5, 1);
        System.out.println("nums5: " + len);
        for (int i = 0; i < len; i++) {
            System.out.printf(nums5[i] + " ");
        }
        System.out.println("\n-----------------------------------");


        int[] nums6= {3, 2, 2, 2, 4};
        len = Solution.removeElement(nums6, 2);
        System.out.println("nums6: " + len);
        for (int i = 0; i < len; i++) {
            System.out.printf(nums6[i] + " ");
        }
        System.out.println("\n-----------------------------------");
    }

    static class Solution {
        public static int removeElement(int[] nums, int val) {
            if (nums == null || nums.length == 0) {
                return nums.length;
            }
            // nums.length > 1
            int len = nums.length - 1;
            for (int i = 0; i <= len; i++) {
                if (nums[i] == val) {
                    while (len >= i && nums[len] == val) {
                        len--;
                    }
                    if (len >= i) {
                        nums[i] = nums[len--];
                    }
                }
            }
            return len + 1;
        }
    }
}
