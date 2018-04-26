package leetcode.code_0081_0090;

public class Code_0083_Remove_Duplicates_from_Sorted_List {
    public static void main(String[] args) {
        // 1->1->2->3->3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode result = Solution.deleteDuplicates(head);
        while (result != null) {
            System.out.printf(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

    private static class Solution {
        public static ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prior = head;
            ListNode next = head.next;
            while (next != null) {
                if (prior.val == next.val) {
                    prior.next = next.next;
                } else {
                    prior = prior.next;
                }
                next = next.next;
            }
            return head;
        }
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
