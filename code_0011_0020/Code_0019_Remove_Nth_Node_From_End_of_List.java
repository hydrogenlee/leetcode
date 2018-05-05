package leetcode.code_0011_0020;

import java.util.ArrayList;
import java.util.List;

public class Code_0019_Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
        // 1->2->3->4->5 n = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = Solution3.removeNthFromEnd(head, 5);
        while (head != null) {
            System.out.printf(head.val + " ");
            head = head.next;
        }
        System.out.println();               // 2->3->4->5
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 链表倒置的方法，LeetCode 2.84%
    // T-C: O(N) need 2*N
    // T-C: O(1)
    static class Solution {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            if (n <= 0) {
                return head;
            }
            int count = 0;
            ListNode end = head;
            head = head.next;
            end.next = null;
            ListNode temp;
            while (head != null) {
                temp = head;
                head = head.next;
                temp.next = end;
                end = temp;
            }
            head = end;
            end = end.next;
            head.next = null;
            while (end != null) {
                temp = end;
                end = end.next;
                temp.next = ++count == n ? head.next : head;
                head = temp;
            }
            return ++count == n ? head.next : head;     // 需要处理第一个节点
        }
    }

    // 使用辅助数组  LeetCode 61.98%
    // T-C: O(N)
    // S-C: O(N)
    static class Solution2 {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || n <= 0) {
                return head;
            }
            List<ListNode> preList = new ArrayList<>();     // 记录每个节点的前置指针
            ListNode preNode = null;                        // 头节点的pre为空
            ListNode temp = head;
            int count = 0;
            while (temp != null) {
                preList.add(preNode);
                preNode = temp;
                temp = temp.next;
                count++;
            }

            if (n > count) {
                return head;            // 什么也不删除
            } else {
                if ((preNode = preList.get(count - n)) == null) {
                    head = head.next;   /* 删除头结点 */
                } else {
                    preNode.next = preNode.next.next;
                }
            }
            return head;
        }
    }


    // 快慢指针
    // 快慢指针开始时都指向一个虚的节点，然后快指针先走n-1步，然后慢指针再开始走，
    // 当快指针到达最后一个节点的时候，慢指针的位置就是需要删除的位置的前一个位置
    // T-C: O(N)
    // S-C: O(1)
    static class Solution3 {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || n <= 0) {
                return head;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode fastPointer = dummy;
            ListNode slowPointer = dummy;
            for (int i = 1; i <= n; i++) {
                if (fastPointer == null) {
                    return head;    // n大于链表的长度
                }
                fastPointer = fastPointer.next;
            }
            while (fastPointer.next != null) {
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
            slowPointer.next = slowPointer.next.next;

            return dummy.next;
        }
    }
}