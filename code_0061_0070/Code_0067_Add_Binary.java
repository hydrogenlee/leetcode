package leetcode.code_0061_0070;

public class Code_0067_Add_Binary {
    public static void main(String[] args) {
        System.out.println(Solution.addBinary("11", "1"));      // 100
        System.out.println(Solution.addBinary("1010", "1011"));// 10101
        System.out.println(Solution.addBinary("0", "1"));
        System.out.println(Solution.addBinary("0", "0"));
        System.out.println(Solution.addBinary("00", "0"));

    }
    static class Solution {
        public static String addBinary(String a, String b) {
            char[] aArray = a.toCharArray();
            char[] bArray = b.toCharArray();
            char[] result = new char[Math.max(aArray.length, bArray.length) + 1];   // 大于1保存进位
            result[0] = '0'; // 初始值不存在进位
            int aIndex = aArray.length - 1;
            int bIndex = bArray.length - 1;
            int rIndex = result.length - 1;
            int carry = 0;          // 0 不进位， 1存在进位
            while (aIndex >= 0 && bIndex >= 0) {
                int aInt = aArray[aIndex--] - '0';
                int bInt = bArray[bIndex--] - '0';
                result[rIndex--] = (char) ((aInt + bInt + carry) % 2 + '0');
                carry = aInt + bInt + carry >= 2 ? 1 : 0;
            }

            // 下面两个while循环只会执行一个
            while (aIndex >= 0) {
                int aInt = aArray[aIndex--] - '0';
                result[rIndex--] = (char) ((aInt + carry) % 2 + '0');
                carry = aInt + carry >= 2 ? 1 : 0;
            }

            while (bIndex >= 0) {
                int bInt = bArray[bIndex--] - '0';
                result[rIndex--] = (char) ((bInt + carry) % 2 + '0');
                carry = bInt + carry >= 2 ? 1 : 0;
            }

            if (carry == 1) {
                result[0] = '1';    // 处理进位
                return new String(result);
            } else {
                int begin = 1;
                // 可能存在多个前置0
                for (; begin < result.length - 1; begin++) {
                    if (result[begin] != '0') {
                        break;
                    }
                }
                return new String(result, begin, result.length - begin);
            }
        }
    }
}
