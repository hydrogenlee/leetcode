package leetcode.code_0031_0040;

import java.util.*;

public class Code_0039_Combination_Sum {
    public static void main(String[] args) {
        printList(SolutionBruteForce.combinationSum(new int[]{2, 3, 6, 7}, 7));
        printList(SolutionOptimized.combinationSum(new int[]{2, 3, 6, 7}, 7));

        printList(SolutionBruteForce.combinationSum(new int[]{2, 3, 5}, 8));
        printList(SolutionOptimized.combinationSum(new int[]{2, 3, 5}, 8));
    }

    private static void printList(List<List<Integer>> lists) {
        if (lists != null) {
            for (List<Integer> list: lists) {
                for (Integer i: list) {
                    System.out.printf(i + " ");
                }
                System.out.println();
            }
            System.out.println("-------------------------");
        }
    }

    // 暴力递归
    static class SolutionBruteForce {
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            if (candidates == null || candidates.length == 0) {
                return lists;
            }
            Arrays.sort(candidates);
            doCombinationSum(lists, candidates, new ArrayList<>(), 0, target);

            return lists;
        }
        public static void doCombinationSum(List<List<Integer>> lists, int[] candidates,
                                            List<Integer> item, int sum, int target) {
            for (int candidate : candidates) {
                if (candidate + sum < target) {
                    List<Integer> temp = new ArrayList<>(item);
                    temp.add(candidate);
                    doCombinationSum(lists, candidates, temp, sum + candidate, target);
                } else if (candidate + sum == target) {
                    item.add(candidate);
                    Collections.sort(item);
                    if (!lists.contains(item)) {
                        lists.add(item);
                    }
                }
            }
        }
    }


    // 优化
    // 每次递归的不是从头开始了，而是从上一次开始的位置继续往下扫描
    static class SolutionOptimized {
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            if (candidates == null || candidates.length == 0) {
                return lists;
            }
            Arrays.sort(candidates);
            doCombination(lists, candidates, new ArrayList<>(), 0, 0, target);
            return lists;
        }
        public static void doCombination(List<List<Integer>> lists, int[] candidates,
                                            List<Integer> item, int index, int sum, int target) {
            if (sum == target) {
                List<Integer> temp = new ArrayList<>(item);
                lists.add(temp);
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] + sum <= target) {
                    item.add(candidates[i]);                   // 要这个数，然后进行递归
                    doCombination(lists, candidates, item, i, sum + candidates[i], target);
                    item.remove(item.size() - 1);       // 不要当前数，然后再往后递归
                }
            }
        }
    }
}