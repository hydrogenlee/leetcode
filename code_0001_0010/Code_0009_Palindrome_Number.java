package leetcode.code_0001_0010;

public class Code_0009_Palindrome_Number {

    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome(0));       // true
        System.out.println(Solution.isPalindrome(1));       // true
        System.out.println(Solution.isPalindrome(121));     // true
        System.out.println(Solution.isPalindrome(-121));    // false
        System.out.println(Solution.isPalindrome(10));      // false
        System.out.println(Solution.isPalindrome(123));     // false
    }

    static class Solution {
        public static boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x == 0) {
                return true;
            }

            String s = Integer.toString(x);
            for (int i = 0; i <= s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
