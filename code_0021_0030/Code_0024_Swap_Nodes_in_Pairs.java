package leetcode.code_0021_0030;

public class Code_0024_Swap_Nodes_in_Pairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = Solution.swapPairs(head);
        while (head != null) {
            System.out.printf(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public static ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode temp = new ListNode(-1);   // 头节点
            ListNode node1;
            ListNode node2;
            temp.next = head;
            head = temp;
            while (temp.next != null) {
                // 只有一个时，不需要翻转
                if (temp.next.next == null) {
                    return head.next;
                }
                node1 = temp.next;
                node2 = temp.next.next;
                temp.next = node2;
                node1.next = node2.next;
                node2.next = node1;

                temp = temp.next.next;
            }

            return head.next;
        }
    }
}