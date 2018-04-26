package leetcode.code_0011_0020;

public class Code_0014_Longest_Common_Prefix {

    public static void main(String[] args) {
        System.out.println(Solution.longestCommonPrefix(
                new String[]{"flower","flow","flight"}));       // fl
        System.out.println(Solution.longestCommonPrefix(
                new String[]{"dog","racecar","car"}));          // ""
        System.out.println(Solution.longestCommonPrefix(
                new String[]{"caa","","a", "acc"}));            // ""
    }

    static class Solution {
        public static String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }
           return mergePrefix(strs, 0, strs.length - 1);
        }

        private static String mergePrefix(String[] strs, int start, int end) {
            if (start == end) {
                return strs[start];
            }

            int mid = (start + end) / 2;
            String pre1 = mergePrefix(strs, start, mid);
            String pre2 = mergePrefix(strs, mid + 1, end);

            return getCommonPrefix(pre1, pre2);
        }

        private static String getCommonPrefix(String s1, String s2) {
            if ("".equals(s1) || "".equals(s2)) {
                return "";
            }

            if (s1.equals(s2)) {
                return s1;
            }

            int commonLength = 0;
            int length = s1.length() < s2.length() ? s1.length() : s2.length();
            for(int i = 0; i < length; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    break;
                }
                commonLength++;
            }

            return s1.substring(0, commonLength);
        }
    }
}
