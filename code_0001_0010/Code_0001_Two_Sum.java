package leetcode.code_0001_0010;

import java.util.HashMap;
import java.util.Map;

// 注意，题目不能排序
public class Code_0001_Two_Sum {
    public static void main(String[] args) {
        // int[] nums = {2, 7, 11, 15};
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = Solution_Brute_Force.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
        result = Solution_One_Way_Hash.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    // 暴力破解
    static class Solution_Brute_Force {
        public static int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for(int j = 0; j < nums.length; j++) {
                    if (i != j && nums[i] + nums[j] == target) {
                        return i < j ? new int[]{i, j} : new int[]{j, i};
                    }
                }
            }
            throw new IllegalArgumentException("No solution");
        }
    }
    
    static class Solution_One_Way_Hash {
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])
                        && map.get(target - nums[i]) != i) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }

            throw new IllegalArgumentException("No solution");
        }
    }
}
