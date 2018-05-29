package leetcode.code_0041_0050;

public class Code_0042_Trapping_Rain_Water {
    public static void main(String[] args) {
        System.out.println(SolutionBruteForce.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));       // 6
        System.out.println(SolutionBruteForce.trap(new int[]{0, 1, 0, 3, 1, 0, 1, 2, 2, 1, 2, 1}));       // 6
        System.out.println(SolutionBruteForce.trap(new int[]{2, 0, 2}));                                  // 2
        System.out.println(SolutionBruteForce.trap(new int[]{2, 1, 0, 2}));                               // 3
        System.out.println(SolutionBruteForce.trap(new int[]{5, 4, 1, 2}));                               // 1
        System.out.println(SolutionBruteForce.trap(new int[]{5, 2, 1, 2, 1, 5}));                         // 14

        System.out.println("---------------------------------------------------------");

        System.out.println(SolutionTwoPointer.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));       // 6
        System.out.println(SolutionTwoPointer.trap(new int[]{0, 1, 0, 3, 1, 0, 1, 2, 2, 1, 2, 1}));       // 6
        System.out.println(SolutionTwoPointer.trap(new int[]{2, 0, 2}));                                  // 2
        System.out.println(SolutionTwoPointer.trap(new int[]{2, 1, 0, 2}));                               // 3
        System.out.println(SolutionTwoPointer.trap(new int[]{5, 4, 1, 2}));                               // 1
        System.out.println(SolutionTwoPointer.trap(new int[]{5, 2, 1, 2, 1, 5}));
    }

    // Brute Force
    private static class SolutionBruteForce {
        public static int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int result = 0;
            // 思路，查找一个比当前位置大的第一个数，作为结束点
            // 如果找不到，那么将这一段的最大值作为结束点
            for (int i = 0; i < height.length - 1; i++) {
                int j = i + 1;
                int tempMaxIndex = j;
                for (; j < height.length; j++) {
                    if (height[tempMaxIndex] <= height[j]) {
                        tempMaxIndex = j;
                    }
                    if (height[i] < height[j]) {
                        // 当找到比height[i]大的值的时候
                        if (j - i == 1) {
                            break;
                        } else{
                            int tempMin = Math.min(height[i], height[j]);
                            for (int k = i + 1; k < j; k++) {
                                result += (tempMin - height[k]);
                            }
                            i = j - 1;
                            break;
                        }
                    }
                }
                // 找不到比height[i]的值的时候
                if (height[tempMaxIndex] <= height[i]) {
                    for (int k = i + 1; k < tempMaxIndex; k++) {
                        result += (height[tempMaxIndex] - height[k]);
                    }
                    i = tempMaxIndex - 1;
                }
            }
            return result;
        }
    }

    // 双指针
    // T-C: O(N)
    // S-C: O(1)
    private static class SolutionTwoPointer {
        public static int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int result = 0;
            int maxLeft = 0;
            int maxRight = 0;
            int left = 0;
            int right = height.length - 1;

            while (left < right) {
                if (height[left] < height[right]) {
                    if (maxLeft <= height[left]) {
                        maxLeft = height[left];
                    } else {
                        result += (maxLeft - height[left]);
                    }
                    left++;
                } else {
                    if (maxRight <= height[right]) {
                        maxRight = height[right];
                    } else {
                        result += maxRight - height[right];
                    }
                    right--;
                }
            }
            return result;
        }
    }
}