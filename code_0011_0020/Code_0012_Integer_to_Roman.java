package leetcode.code_0011_0020;

public class Code_0012_Integer_to_Roman {
    public static void main(String[] args) {
        System.out.println(Solution.intToRoman(3));     // III
        System.out.println(Solution.intToRoman(4));     // IV
        System.out.println(Solution.intToRoman(9));     // IX
        System.out.println(Solution.intToRoman(58));    // LVIII
        System.out.println(Solution.intToRoman(1994));  // MCMXCIV
    }
    static class Solution {
        public static String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            int[] weight = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int i = 0;
            while (num > 0) {
                if (num >= weight[i]) {
                    num -= weight[i];
                    sb.append(roman[i]);
                } else {
                    i++;
                }
            }
            return sb.toString();
        }
    }
}