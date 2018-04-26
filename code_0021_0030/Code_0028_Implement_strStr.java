package leetcode.code_0021_0030;

public class Code_0028_Implement_strStr {

    public static void main(String[] args) {
        System.out.println(Solution.strStr("hello", "ll"));
        System.out.println(Solution.strStr("aaaaa", "baa"));
        System.out.println(Solution.strStr("hello", ""));
        System.out.println(Solution.strStr("", ""));

    }

    static class Solution {
        public static int strStr(String haystack, String needle) {
            if (needle == null || needle.isEmpty()) {
                return 0;
            }

            if (haystack == null || haystack.isEmpty() ||
                    haystack.length() < needle.length()) {
                return -1;
            }

            for (int i = 0; i < haystack.length() && (haystack.length() - i >= needle.length()); i++) {
                int temp = i;
                int j = 0;
                while (temp < haystack.length() && j < needle.length() &&
                        haystack.charAt(temp) == needle.charAt(j)) {
                    temp++;
                    j++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }

            return -1;
        }
    }
}
