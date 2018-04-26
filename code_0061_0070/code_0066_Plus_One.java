package leetcode.code_0061_0070;

public class code_0066_Plus_One {
    public static void main(String[] args) {
        int[] result = Solution.plusOne(new int[]{1, 2, 3});
        for (int i : result) {
            System.out.printf(i + " ");
        }
        System.out.println();
        result = Solution.plusOne(new int[]{4, 3, 2, 1});
        for (int i : result) {
            System.out.printf(i + " ");
        }
        System.out.println();
        result = Solution.plusOne(new int[]{9, 9});
        for (int i : result) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }
    static class Solution {
        public static int[] plusOne(int[] digits) {
            int[] result = digits.clone();

            for (int i = digits.length - 1; i >= 0; i--) {
                // 执行这个判断语句时，说明有进位
                if (digits[i] + 1 < 10) {
                    result[i] = digits[i] + 1;
                    return result;
                } else {
                    result[i] = (digits[i] + 1) % 10;
                }
            }

            // 当执行到此处时，说明数组长度不足，需要将数组长度加1
            int[] carriedArray = new int[result.length + 1];
            carriedArray[0] = 1;
            System.arraycopy(result, 0, carriedArray, 1, carriedArray.length - 1);
            return carriedArray;
        }
    }
}
