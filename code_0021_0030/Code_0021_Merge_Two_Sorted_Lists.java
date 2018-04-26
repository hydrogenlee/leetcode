package leetcode.code_0021_0030;

// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4
public class Code_0021_Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode mergeList = Solution.mergeTwoLists(l1, l2);
        while (mergeList != null) {
            System.out.println(mergeList.val);
            mergeList = mergeList.next;
        }
    }

    static class Solution {
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 头结点
            ListNode head = new ListNode(Integer.MIN_VALUE);
            ListNode p = head;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            if (l1 != null) {
                p.next = l1;
            }
            if (l2 != null) {
                p.next = l2;
            }

            return head.next;
        }
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
