package leetcode.code_0001_0010;

public class Code_0005_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        System.out.println(Solution1.longestPalindrome("babad"));    // bab
        System.out.println(Solution1.longestPalindrome("cbbd"));     // bb
        System.out.println(Solution1.longestPalindrome("babaddtattarrattatddetartrateedredividerb")); // ddtattarrattatdd
    }

    // Expand Around Center
    // T-C: O(N^2)
    // S-C: O(1)
    private static class Solution1 {
        public static String longestPalindrome(String s) {
            if (s == null || s.isEmpty() || s.length() == 1) {
                return s;
            }
            int[] result = new int[]{0,0};
            // 一共有2n-1个中心点（因为中心点可能在两个字母中间）
            for (int i = 0; i < 2 * s.length() - 1; i++) {
                int[] temp = expandAroundCenter(s, i);
                result = temp[1] - temp[0]> result[1] - result[0] ? temp : result;
            }
            return s.substring(result[0], result[1] + 1);
        }

        // 返回值 int[] result
        // result[0] startIndex, inclusive
        // result[1] endIndex, inclusive
        private static int[] expandAroundCenter(String s, int center) {
            // 最左边和最右边的中心点就是字母本身
            if (center == 0 || center == 2 * s.length() - 2) {
                return new int[]{center / 2, center / 2};
            }
            // aba -> a#b#a
            //        01234
            // 如果center为奇数，那么是两个字母的中间
            // 如果center为偶数，那么是一个字
            int left = center % 2 == 0 ? center / 2 - 1 : center / 2;
            int right = center / 2 + 1;
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return new int[]{left + 1, right - 1};
        }
    }
}