package leetcode.code_0031_0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_0040_Combination_Sum_II {
    public static void main(String[] args) {
        printList(Solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        printList(Solution.combinationSum2(new int[]{}, 8));
        printList(Solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    private static void printList(List<List<Integer>> lists) {
        if (lists != null) {
            for (List<Integer> list: lists) {
                for (Integer i: list) {
                    System.out.printf(i + " ");
                }
                System.out.println();
            }
            System.out.println("============================");
        }
    }
    private static class Solution {
        public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
             List<List<Integer>> lists = new ArrayList<>();
            if (candidates == null || candidates.length == 0) {
                return lists;
            }
            Arrays.sort(candidates);
            doCombination(lists, candidates, new ArrayList<>(), 0, 0, target);

            return lists;
        }

        private static void doCombination(List<List<Integer>> lists, int[] candidates,
                                          List<Integer> item, int index, int sum, int target) {
            if (sum == target) {
                List<Integer> list = new ArrayList<>(item);
                if (!lists.contains(list)) {
                    lists.add(list);
                }
            }

            for (int i = index; i < candidates.length; i++) {
                if ( i != index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (sum + candidates[i] <= target) {
                    item.add(candidates[i]);
                    doCombination(lists, candidates, item, i + 1, sum + candidates[i], target);
                    item.remove(item.size() - 1);
                } else {
                    break;
                }
            }
        }
    }
}
