package leetcode.code_0031_0040;

import java.util.Stack;

public class Code_0032_Longest_Valid_Parentheses {
    public static void main(String[] args) {
        printResult("(()");                 // 2
        printResult("())");                 // 2
        printResult("()(()");               // 2
        printResult(")()())");              // 4
        printResult(")()())()()()");        // 6
        printResult(")()())(())()");        // 6
        printResult(")()())((()))");        // 6
        printResult("))))())()()(()");      // 4
    }

    private static void printResult(String s) {
        System.out.println("s = " + s);
        System.out.println(SolutionDP.longestValidParentheses(s));
        System.out.println(SolutionUsingStack.longestValidParentheses(s));
        System.out.println(SolutionScanningTwice.longestValidParentheses(s));
        System.out.println("----------------------");
    }

    // Dynamic Programming
    // 只有在遇到右括号的时候才更新dp，查看dp[i-2]的原因是为了验证是否能和前面组成子串
    // 分为以下几种情况：1. 遇到')'时，前一个字符是'('，则dp[i-2]加2
    //                          dp[i+1] = dp[i-2] + 2
    //                 2. 当遇到')'时，前一个字符是')'，则需要判断 s[i - dp[i-1] - 1] 是不是'(',
    //                          如果是： dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2
    //                 3. 其他情况
    //                          dp[i+1] = 0;
    // T-C: O(N)
    // S-C: O(N)
    private static class SolutionDP {
        private static int longestValidParentheses(String s) {
            if (s == null || s.length() < 2) {
                return 0;
            }
            int longest = 0;
            int[] dp = new int[s.length()];         // 默认是0
            // 从1位置开始查询，因为s[0]无论是'('还是'), dp[i] = 0
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                    } else if (s.charAt(i - 1) == ')' &&
                            i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = (i - 2 >= 0 ? dp[i - 1] : 0) +
                                (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
                longest = Math.max(longest, dp[i]);
            }
            return longest;
        }
    }


    // Using stack
    // 先将-1压栈，避免讨论特殊情况。然后，每次遇到')'号，就弹出栈顶元素
    //  然后判断栈是否为空，如果栈为空，将当前的索引压栈，即可以保证其前置元素信息存在在栈中
    // T-C: O(N)
    // S-C: O(N)
    private static class SolutionUsingStack {
        private static int longestValidParentheses(String s) {
            if (s == null || s.length() < 2) {
                return 0;
            }
            int longest = 0;
            Stack<Integer> stack = new Stack<>();
            // 先压栈-1，可以避免讨论特殊情况
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.add(i);
                } else if (s.charAt(i) == ')') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        // 时刻保持栈不空
                        // 情况1：弹出的是不符合条件的右括号的索引值
                        // 情况2：前面的括号序列已经全部匹配
                        stack.push(i);
                    } else {
                        longest = Math.max(longest, i - stack.peek());
                    }
                }
            }
            return longest;
        }
    }

    // Scanning Twice
    // 从左侧往右侧扫描一次（当open == close时，更新最大值，当open < close 时，将open和close归0），
    // 然后从右侧往左侧扫描一次（当open == close时，更新最大值，当open > close 时，将open和close归0）
    // T-C: O(N),但是不如dp快，因为dp只扫描一次
    // S-C: O(1)
    private static class SolutionScanningTwice {
        private static int longestValidParentheses(String s) {
            if (s == null || s.length() < 2) {
                return 0;
            }
            int longest = 0;
            int tempLong = 0;
            int open = 0;
            int close = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    open++;
                } else if (s.charAt(i) == ')') {
                    close++;
                }
                if (close == open) {
                    tempLong = 2 * close;
                } else if (close > open) {
                    open = 0;
                    close = 0;
                    tempLong = 0;
                }
                longest = Math.max(longest, tempLong);
            }

            // open和close变量归0
            open = 0;
            close = 0;
            tempLong = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    open++;
                } else if (s.charAt(i) == ')') {
                    close++;
                }
                if (close == open) {
                    tempLong = 2 * close;
                } else if (close < open) {
                    open = 0;
                    close = 0;
                    tempLong = 0;
                }
                longest = Math.max(longest, tempLong);
            }
            return longest;
        }
    }
}