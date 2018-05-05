package leetcode.code_0021_0030;

public class Code_0029_Divide_Two_Integers {
    public static void main(String[] args) {
        System.out.println(Solution.divide(10, 3));             // 3
        System.out.println(Solution.divide(7, -3));             // -2
        System.out.println(Solution.divide(1, 3));              // 0
        System.out.println(Solution.divide(Integer.MAX_VALUE, 1));      // 2147483647
        System.out.println(Solution.divide(Integer.MIN_VALUE, 1));      // -2147483648

    }

    static class Solution {
        public static int divide(int dividend, int divisor) {
            if (divisor == 0) {
                throw new IllegalArgumentException("除数不能为0");
            }
            if (dividend == 0) {
                return 0;
            }

            int neg = (int) (Math.signum(dividend) * Math.signum(divisor));
            // 转为long，这样可以不用考虑-2147483648(Integer.MIN_VALUE)
            long lDividend = Math.abs((long)dividend);
            long lDivisor = Math.abs((long) divisor);

            long result = 0;
            while (lDividend >= lDivisor) {
                long temp = lDivisor;
                int i = 1;
                while (lDividend >= temp){
                    lDividend -= temp;
                    result += i;
                    i <<= 1;            // ==*2
                    temp <<= 1;         // ==*2
                }
            }
            // 越界处理
            if (result > Integer.MAX_VALUE){
                return neg == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            return (int)result * neg;
        }
    }
}