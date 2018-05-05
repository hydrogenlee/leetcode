package leetcode.code_0011_0020;

import java.util.*;

public class Code_0017_Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
        List<String> result = Solution.letterCombinations("23456789");
        for (String s: result) {
            System.out.printf(s + " ");
        }
        System.out.println();
    }

    static class Solution {
        public static List<String> letterCombinations(String digits) {
            List<String> list = new LinkedList<>();
            if (digits == null || digits.isEmpty() || !digits.matches("[2-9]*")) {
                return list;
            }
            String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            char[] arr = digits.toCharArray();
            list.add("");
            int start = 0;
            int end = 1;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < dict[arr[i] - '0'].length(); j++) {
                    for (int k = start; k < end; k++) {
                        list.add(list.get(k) + dict[arr[i] - '0'].charAt(j));
                    }
                }
                start = end;
                end = list.size();
            }
            return list.subList(start, end);
        }
    }
}