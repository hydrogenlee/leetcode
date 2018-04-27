package leetcode.code_0001_0010;

import java.util.HashMap;
import java.util.Map;

public class Code_0003_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        System.out.println("Solution1:" + Solution1.lengthOfLongestSubstring("bbbbbb"));    // b
        System.out.println("Solution2:" + Solution2.lengthOfLongestSubstring("bbbbbb"));    // b
        System.out.println("Solution1:" + Solution1.lengthOfLongestSubstring("abba"));      // ba
        System.out.println("Solution2:" + Solution2.lengthOfLongestSubstring("abba"));      // ba
        System.out.println("Solution1:" + Solution1.lengthOfLongestSubstring("abcabcbb"));  // abc
        System.out.println("Solution2:" + Solution2.lengthOfLongestSubstring("abcabcbb"));  // abc
        System.out.println("Solution1:" + Solution1.lengthOfLongestSubstring("pwwkew"));    // wke
        System.out.println("Solution2:" + Solution2.lengthOfLongestSubstring("pwwkew"));    // wke
        System.out.println("Solution1:" + Solution1.lengthOfLongestSubstring("bbtablud"));  // tablud
        System.out.println("Solution2:" + Solution2.lengthOfLongestSubstring("bbtablud"));  // tablud
    }
    // Sliding  window
    // T-C (O(N^2))
    // S-C (O(N)-->using charArray or O(1))
    static class Solution1 {
        public static int lengthOfLongestSubstring(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            int max = Integer.MIN_VALUE;
            int tempMax = 0;
            int start = 0;
            char[] arr = s.toCharArray();
            for (int end = 0; end < arr.length; end++) {
                int lastIndex;
                if ((lastIndex = getLastIndex(arr, start, end)) == -1) {
                    tempMax++;
                } else {
                    tempMax = tempMax - (lastIndex - start);
                    start = lastIndex + 1;
                }
                max = Math.max(max, tempMax);
            }
            return max;
        }
        private static int getLastIndex(char[] arr, int start, int end) {
            if (start >= end) {
                return -1;
            }
            for (int i = end - 1; i >= start; i--) {
                if (arr[i] == arr[end]) {
                    return i;
                }
            }
            // 没有找到
            return -1;
        }
    }

    // optimized sliding window     using hash map
    // T-C O(N)
    // S-C O(N)
    static class Solution2 {
        public static int lengthOfLongestSubstring(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            // 存放的是当前的字符串 s[i~j]
            Map<Character, Integer> map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            int tempMax = 0;
            for (int i = 0; i < s.length(); i++) {
                Integer lastIndex;
                if (map.isEmpty() || (lastIndex = map.get(s.charAt(i))) == null) {
                    tempMax++;
                } else {
                    // 不在当前子串中
                    if (i - lastIndex > tempMax) {
                        tempMax++;
                    } else {
                        tempMax = i - lastIndex;
                    }
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, tempMax);
            }
            return max;
        }
    }
}