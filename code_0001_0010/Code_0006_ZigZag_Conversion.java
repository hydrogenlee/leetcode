package leetcode.code_0001_0010;

public class Code_0006_ZigZag_Conversion {
    public static void main(String[] args) {
        //System.out.println("PAHNAPLSIIGYIR".equals(Solution.convert("PAYPALISHIRING",3)));  // PAHNAPLSIIGYIR
        //System.out.println("PINALSIGYAHRPI".equals(Solution.convert("PAYPALISHIRING",4)));  // PINALSIGYAHRPI
        System.out.println("AB".equals(Solution.convert("AB",1)));                          // AB

    }
    static class Solution {
        public static String convert(String s, int numRows) {
            if (s == null || s.length() == 0 || numRows <= 0) {
                return "";
            }
            if (s.length() == 1 || numRows == 1) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                // 打印 第一排、最后一排
                // 每次打印一个
                if (i == 0 || i == numRows - 1) {
                    for (int j = 0; i + j * (2 * numRows - 2) < s.length(); j++) {
                        sb.append(s.charAt(i + j * (2 * numRows - 2)));
                    }
                } else {
                    // 打印中间
                    // 每次打印两个数字
                    for (int j = 0; i + j * (2 * numRows - 2) < s.length() ||
                            (j + 1) * (2 * numRows - 2) - i < s.length(); j++) {
                        // 第一列
                        if (i + j * (2 * numRows - 2) < s.length()) {
                            sb.append(s.charAt(i + j * (2 * numRows - 2)));
                        }
                        // 中间
                        if ((j + 1) * (2 * numRows - 2) - i < s.length()) {
                            sb.append(s.charAt((j + 1) * (2 * numRows - 2) - i));
                        }
                    }
                }
            }
            return sb.toString();
        }
    }
}