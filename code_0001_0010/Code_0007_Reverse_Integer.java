package leetcode.code_0001_0010;

public class Code_0007_Reverse_Integer  {

    public static void main(String[] args) {
        System.out.println(Solution.reverse(123));
        System.out.println(Solution.reverse(-123));
        System.out.println(Solution.reverse(0));
        System.out.println(Solution.reverse(-0));
        System.out.println(Solution.reverse(Integer.MIN_VALUE));
        System.out.println(Solution.reverse(Integer.MAX_VALUE));

    }

    static class Solution {
        public static int reverse(int x) {
            if (x == 0 || x == Integer.MIN_VALUE) {
                return 0;
            }

            int sign = x > 0 ? 1: -1;
            int result = 0;
            int temp = Math.abs(x);
            while (temp != 0){
                if (result > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                result = result * 10 + temp % 10;
                temp /= 10;
            }

            return sign * result;
        }
    }
}
