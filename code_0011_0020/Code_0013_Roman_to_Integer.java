package leetcode.code_0011_0020;

import java.util.HashMap;
import java.util.Map;

public class Code_0013_Roman_to_Integer {

    public static void main(String[] args) {
        System.out.println(Solution.romanToInt("I"));           // 1
        System.out.println(Solution.romanToInt("III"));         // 3
        System.out.println(Solution.romanToInt("IV"));          // 4
        System.out.println(Solution.romanToInt("IX"));          // 9
        System.out.println(Solution.romanToInt("LVIII"));       // 58
        System.out.println(Solution.romanToInt("MCMXCIV"));     // 1994
    }

    static class Solution {
        public static int romanToInt(String s) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M',1000);

            int result = 0;
            int i = 0;
            for (; i < s.length() - 1; i++) {
                if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                    // two steps
                    result += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                    i++;
                } else {
                    // one step
                    result += map.get(s.charAt(i));
                }
            }

            if (i == s.length() - 1) {
                result += map.get(s.charAt(i));
            }

            return result;
        }
    }
}
