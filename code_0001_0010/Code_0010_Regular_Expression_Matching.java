package leetcode.code_0001_0010;

public class Code_0010_Regular_Expression_Matching {
    public static void main(String[] args) {
        System.out.println(Solution.isMatch("aa", "a"));                    // false
        System.out.println(Solution.isMatch("aa", "a*"));                   // true
        System.out.println(Solution.isMatch("ab", ".*"));                   // true
        System.out.println(Solution.isMatch("baab","bc*a*b"));              // true
        System.out.println(Solution.isMatch("aab","c*a*b"));                // true
        System.out.println(Solution.isMatch("mississippi", "mis*is*p*."));  // false
        System.out.println(Solution.isMatch("aaa", "ab*a*c*a"));            // true
    }

    // 因为*不确定匹配几个字符串，因此使用动态规划
    // 具体分析情况如下：
    //  base case:
    //      1. s == "" && p == "" dp[0][0] = true
    //      2. s != "" && p == "" dp[i][0] = false
    //      3. s == "" && p != "" dp[0][i] = dp[0][i-2]
    // dp 操作：
    //      1. p.charAt(j-1) == s.charAt(i-1)   可以匹配    dp[i][j] = dp[i-1][j-1]
    //      2. p.charAt(j-1) == '.'             可以匹配    dp[i][j] = dp[i-1][j-1]
    //      3. p.charAt(j-1) == '*'             需要看其前一个字符，可能匹配0次到多次
    //          3.1. s.charAt(i-1) != p.charAt(j-2)     匹配0次     dp[i][j] = dp[i][j-2]
    //          3.2. s.charAt(i-1) == p.charAt(j-2)
    //                      3.2.1 匹配0次     dp[i][j] = dp[i][j-2]
    //                      3.2.2 匹配1次     dp[i][j] = dp[i][j-1]
    //                      3.2.3 匹配多次    dp[i][j] = dp[i-1][j]
    static class Solution {
        public static boolean isMatch(String s, String p) {
            // i和j代表长度（从1开始），dp[i][j] 表示s[0~i-1]和p[0~j-1]匹配
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];   // 默认值为false
            dp[0][0] = true;    // 表示s和p都是空字符串
            // s不为空，p为空的时候，dp[i][0] 肯定是false，上面已经包含这种情况
            // s为空，p不为空，则必须是 ?*?*?*这种情况
            for (int i = 1; i <= p.length(); i++) {
                if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                    dp[0][i] = true;
                }
            }
            // s和p都不为空时
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    // s[i] == p[j] 或者 p[j] == '.'
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    // p[j] = '*'
                    if (p.charAt(j - 1) == '*') {
                        if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                            // s[i] != p[j-1]， 那么*号匹配0次
                            dp[i][j] = dp[i][j - 2];
                        } else {
                            // s[i] == p[j-1]，那么*号匹配0次或者多次
                            dp[i][j] = (dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j]);
                            //              ^                  ^               ^
                            //            匹配0次            匹配1次         匹配多次
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}