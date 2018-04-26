package leetcode.code_0061_0070;

public class Code_0069_Sqrt {
    public static void main(String[] args) {
        System.out.println(Solution.mySqrt(4));     // 2
        System.out.println(Solution.mySqrt(8));     // 2
        System.out.println(Solution.mySqrt(1));     // 1
        System.out.println(Solution.mySqrt(100));   // 10
        System.out.println(Solution.mySqrt(99));    // 9
        System.out.println(Solution.mySqrt(33));    // 5
        System.out.println(Solution.mySqrt(2147395599));     // 3


    }
    static class Solution {
        public static int mySqrt(int x) {
            // binary search
            int start = 1;
            int end = x;
            while (start <= end) {
                int mid = (end - start) / 2 + start;    // 防止越界
                long midPower = (long)mid * mid;
                if (midPower == x) {
                    return mid;
                } else if (midPower < x) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return Math.min(start, end);
        }
    }
}
