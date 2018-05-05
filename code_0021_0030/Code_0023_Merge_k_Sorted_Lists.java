package leetcode.code_0021_0030;

public class Code_0023_Merge_k_Sorted_Lists {
    public static void main(String[] args) {
        /**
         * 1->4->5,
         * 1->3->4,
         * 2->6
         * Output: 1->1->2->3->4->4->5->6
         */
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1);
        listNodes[0].next = new ListNode(4);
        listNodes[0].next.next = new ListNode(5);

        listNodes[1] = new ListNode(1);
        listNodes[1].next = new ListNode(3);
        listNodes[1].next.next = new ListNode(4);

        listNodes[2] = new ListNode(2);
        listNodes[2].next = new ListNode(6);
        ListNode result = Solution.mergeKLists(listNodes);
        while (result != null) {
            System.out.printf(result.val + " ");
            result = result.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // divide and conquer 分治法
    static class Solution {
        public static ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            return doMergeKLists(lists, 0, lists.length - 1);
        }

        private static ListNode doMergeKLists(ListNode[] lists, int start, int end) {
            if (end - start == 0) {         // 只有一个链表
                return lists[start];
            } else if (end - start == 1) {  // 只有两个链表
                return mergeTwoLists(lists[start], lists[end]);
            }
            int mid = (start + end) / 2;
            ListNode node1 = doMergeKLists(lists, start, mid);
            ListNode node2 = doMergeKLists(lists, mid + 1, end);
            return mergeTwoLists(node1, node2);
        }

        private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            } 
            ListNode head = new ListNode(-1); // 头节点
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
}