package leetcode.code_0001_0010;

import java.util.Map;

public class Code_0005_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        System.out.println("Solution1: " + Solution1.longestPalindrome("babad"));    // bab
        System.out.println("Solution2: " + Solution2.longestPalindrome("babad"));    // bab
        System.out.println("Solution1: " + Solution1.longestPalindrome("cbbd"));     // bb
        System.out.println("Solution2: " + Solution2.longestPalindrome("cbbd"));     // bb
        System.out.println("Solution1: " + Solution1.longestPalindrome("babaddtattarrattatddetartrateedredividerb")); // ddtattarrattatdd
        System.out.println("Solution2: " + Solution2.longestPalindrome("babaddtattarrattatddetartrateedredividerb")); // ddtattarrattatdd
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
            // 如果center为偶数，那么是一个字母
            int left = center % 2 == 0 ? center / 2 - 1 : center / 2;
            int right = center / 2 + 1;
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return new int[]{left + 1, right - 1};
        }
    }

    // Manacher's Algorithm
    // T-C: O(N)
    // S-C: O(N)
    // 包括四种情况： 1. 右边界没有包含下一个中心点
    //               2. 右边界包括中心点，包括3种情况：中心点i关于C的对称点i'的回文左边界L'在L的左侧(a)、右侧(b)以及重合(c)
    // 其中只有情况1和情况2中的情况c，需要继续往外扩(相应的调整C和R)，而另外的两种情况可以根据pArr直接得出（不调整C和R）
    private static class Solution2 {
        public static String longestPalindrome(String s) {
            if (s == null || s.isEmpty() || s.length() == 1) {
                return s;
            }
            // 预处理，用'#'分隔
            char[] arr = new char[s.length() * 2 + 1];
            int[] pArr = new int[arr.length];       // 每个点的回文半径
            for (int i = 0; i < arr.length; i++) {
                    arr[i] = i % 2 == 0 ? '#' : s.charAt(i / 2);
            }
            int C = -1;      // 取得最大回文右边界的中心点
            int R = -1;      // 最大回文右边界
            int maxC = -1;   // 最大回文字符串的中心
            int maxRadix = Integer.MIN_VALUE;  // 最大回文半径

            for (int i = 0; i < arr.length; i++) {

                // 下面这句只是确定以该点为中心的最小回文半径
                pArr[i] = i < R ? Math.min(pArr[2 * C - i], R - i) : 1;

                // 情况1和情况2中的情况c，需要对回文半径进行扩展
                // i' - pArr[i'] 左边界     i'是i关于C的对称点
                // i + pArr[i] 右边界
                // 判断的是i'左边界的前一个位置和i右边界的下一个位置是否相等
                while (i - pArr[i] >= 0 && i + pArr[i]< arr.length &&
                        arr[i - pArr[i]] == arr[i + pArr[i]]) {
                    pArr[i]++;
                }
                // 只有当新的回文右边界大于R时，调整R，同时调整C
                if (i + pArr[i] > R) {
                    R = i + pArr[i];
                    C = i;
                }
                // 每次判断是不是最大回文子串
                if (maxRadix < pArr[i]) {
                    maxRadix = pArr[i];
                    maxC = i;
                }
            }
            return s.substring((maxC - maxRadix + 1) / 2, (maxC + maxRadix) / 2);
        }
    }
}