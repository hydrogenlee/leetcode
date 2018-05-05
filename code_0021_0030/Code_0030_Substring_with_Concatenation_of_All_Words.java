package leetcode.code_0021_0030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_0030_Substring_with_Concatenation_of_All_Words {
    public static void main(String[] args) {
        List<Integer> result;
        result = Solution.findSubstring("barfoothefoobarman",
                new String[]{"foo", "bar"});                        // 0 9
        for (Integer i : result) {
            System.out.printf(i + " ");
        }
        System.out.println("\n==========================");
        result = Solution.findSubstring("wordgoodstudentgoodword",
                new String[]{"word","student"});
        for (Integer i : result) {
            System.out.printf(i + " ");
        }
        System.out.println();

        System.out.println("\n==========================");
        result = Solution.findSubstring("wordgoodgoodgoodbestword",
                new String[]{"word","good","best","good"});         // 8
        for (Integer i : result) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }

    static class Solution {
        public static List<Integer> findSubstring(String s, String[] words) {
            if (s == null || s.length() == 0 || words.length == 0) {
                return new ArrayList<>();
            }
            // 判断word里面每个单词的长度是否相等
            int size = words.length;
            int len = words[0].length();
            for (int i = 1; i < words.length; i++) {
                if (words[i].length() != len) {
                    return new ArrayList<>();
                }
            }

            List<Integer> result = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            // 将所有的单词放到hash map中
            for (String word : words) {
                // words数组中可能存在相同的单词！！！！！
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            // 滑动窗口遍历
            for (int i = 0; i <= s.length() - size * len; i++) {
                Map<String, Integer> temp = new HashMap<>(map);
                int n = size;
                int j = i;
                while (n > 0){
                    String sub = s.substring(j, j + len);
                    if (!temp.containsKey(sub) || temp.get(sub) == 0) {
                        break;
                    }
                    temp.put(sub, temp.get(sub) - 1);
                    n--;
                    j += len;
                }
                if (n == 0) {
                    result.add(i);
                }
            }
            return result;
        }
    }
}