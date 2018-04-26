package leetcode.code_0011_0020;

import java.util.Stack;

public class Code_0020_Valid_Parentheses {
    public static void main(String[] args) {
        System.out.println(Solution.isValid(""));               // true
        System.out.println(Solution.isValid("()"));             // true
        System.out.println(Solution.isValid( "()[]{}"));        // true
        System.out.println(Solution.isValid( "(]"));            // false
        System.out.println(Solution.isValid("([)]"));           // false
        System.out.println(Solution.isValid( "{[]}"));          // true

    }
    static class Solution {
        public static boolean isValid(String s) {
            // 空，奇数个字符，直接返回false
            if (s == null || s.length() % 2 == 1) {
                return false;
            }
            if (s.length() == 0) {
                return true;
            }
            Stack<Character> stack = new Stack<>();
            char c;
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (stack.isEmpty()){
                    stack.push(c);
                } else {
                    char peekChar = stack.peek();
                    if (c == ')' && peekChar == '(' ||
                            c == ']' && peekChar == '[' ||
                            c == '}' && peekChar == '{') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}


