package leetcode.code_0091_0100;

public class Code_0100_Same_Tree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(Solution.isSameTree(p, q));          // true
    }


    static class Solution {
        public static boolean isSameTree(TreeNode p, TreeNode q) {
            return p == null ? q == null : q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
