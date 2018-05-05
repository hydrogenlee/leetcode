package leetcode.code_0021_0030;

import java.util.ArrayList;
import java.util.List;

public class Code_0022_Generate_Parentheses {
    public static void main(String[] args) {
        List<String> list;
        System.out.println("----------------1-----------------");
        list = Solution.generateParenthesis(1);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------2-----------------");
        list = Solution.generateParenthesis(2);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------3-----------------");
        list = Solution.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------4-----------------");
        list = Solution.generateParenthesis(4);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------------------------");
    }

    static class Solution {
        public static List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            doGenerate("", 0, 0, n, list);
            return list;
        }

        private static void doGenerate(String pre, int open, int close, int n, List<String> list) {
            // 当长度为2*n时，返回
            if (pre.length() == n * 2) {
                list.add(pre);
                return;
            }
            if (open < n) {
                doGenerate(pre + '(', open + 1, close, n, list);
            }
            if (close < open) {
                doGenerate(pre + ')', open, close + 1, n, list);
            }
        }
    }
}