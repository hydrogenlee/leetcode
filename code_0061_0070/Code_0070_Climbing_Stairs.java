package leetcode.code_0061_0070;

public class Code_0070_Climbing_Stairs {
    public static void main(String[] args) {
        System.out.println(Solution.climbStairs(10));
        System.out.println(Solution.climbStairs(1));
        System.out.println(Solution.climbStairs(2));
        System.out.println(Solution.climbStairs(3));
        System.out.println(Solution.climbStairs(4));
        System.out.println(Solution.climbStairs(15));

    }
    // 动态规划
    static class Solution {
        public static int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }

            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
