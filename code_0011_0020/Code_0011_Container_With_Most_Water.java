package leetcode.code_0011_0020;

public class Code_0011_Container_With_Most_Water {
    public static void main(String[] args) {
        System.out.println(SolutionBruteForce.maxArea(new int[]{1, 1}));
        System.out.println(SolutionTwoPoint.maxArea(new int[]{1, 1}));
    }
    // 超时
    static class SolutionBruteForce {
        public static int maxArea(int[] height) {
            int max = -1;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    int tempArea = Math.min(height[i], height[j]) * (j - i);
                    max = Math.max(max, tempArea);
                }
            }
            return max;
        }
    }

    // 双指针
    // 思路是找到大于自己并且离自己最远的位置
    static class SolutionTwoPoint {
        public static int maxArea(int[] height) {
            int max = -1;
            int left = 0;
            int right = height.length - 1;
            while (left < right) {
                max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return max;
        }
    }
}
