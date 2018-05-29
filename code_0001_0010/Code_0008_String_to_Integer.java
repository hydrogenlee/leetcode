package leetcode.code_0001_0010;

public class Code_0008_String_to_Integer {
    public static void main(String[] args) {
        System.out.println(Solution.myAtoi(""));                    // 0
        System.out.println(Solution.myAtoi("  "));                  // 0
        System.out.println(Solution.myAtoi("0"));                   // 0
        System.out.println(Solution.myAtoi("-0"));                  // 0
        System.out.println(Solution.myAtoi("+0"));                  // 0
        System.out.println(Solution.myAtoi("+ 11"));                // 0
        System.out.println(Solution.myAtoi("- 11"));                // 0
        System.out.println(Solution.myAtoi("+11"));                 // 11
        System.out.println(Solution.myAtoi("42"));                  // 42
        System.out.println(Solution.myAtoi("   -42"));              // -42
        System.out.println(Solution.myAtoi("4193 with words"));     // 4193
        System.out.println(Solution.myAtoi("words and 987"));       // 0
        System.out.println(Solution.myAtoi("-91283472332"));        // -2147483648
        System.out.println(Solution.myAtoi("-2147483648"));         // -2147483648
        System.out.println(Solution.myAtoi("-2147483649"));         // -2147483648
        System.out.println(Solution.myAtoi("2147483647"));          // 2147483647
        System.out.println(Solution.myAtoi("2147483648"));          // 2147483647
    }

    static class Solution {
        public static int myAtoi(String str) {
            if (str == null) {
                return 0;
            }
            int index = 0;
            // 删除空格
            while (index < str.length() && str.charAt(index) == ' ') {
                index++;
            }
            // 排除第一个字符不是'0'~'9'和'-'的字符串
            // 注意！！！还有'+'也是符合条件的
            if (index >= str.length() || !(str.charAt(index) >= '0' &&
                    str.charAt(index) <= '9' || str.charAt(index) == '-' ||
                    str.charAt(index) == '+')) {
                return 0;
            }

            int signum = 1;    // 符号位
            int result = 0;
            char ch = str.charAt(index);
            // 判断第一个字符是不是'-'或者'+'
            if (ch == '-') {
                signum = -1;
                index++;
            } else if (ch == '+') {
                index++;
            }

            for (; index < str.length(); index++) {
                ch = str.charAt(index);
                if (ch < '0' || ch > '9') {
                    break;
                }
                if (result < Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10
                       && ch - '0' <= Integer.MAX_VALUE % 10){
                    result = result * 10 + ch - '0';
                } else {
                    // 越界 支持的大小为[-2^31 ~ 2^31-1]
                    return signum == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            }
            return signum * result;
        }
    }
}