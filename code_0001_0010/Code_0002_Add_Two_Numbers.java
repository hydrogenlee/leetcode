package leetcode.code_0001_0010;

public class Code_0002_Add_Two_Numbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = Solution.addTwoNumbers(l1, l2);
        //  7 -> 0 -> 8
        while (result != null) {
            System.out.printf(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }

            ListNode result = new ListNode(-1);  // 头结点
            ListNode p = result;
            int carry = 0;  //进位

            while (l1 != null && l2 != null) {
                p.next = new ListNode((l1.val + l2.val + carry) % 10);
                carry = l1.val + l2.val + carry >= 10 ? 1 : 0;
                l1 = l1.next;
                l2 = l2.next;
                p = p.next;
            }

            while (l1 != null) {
                p.next = new ListNode((l1.val + carry) % 10);
                carry = l1.val + carry >= 10 ? 1 : 0;
                l1 = l1.next;
                p = p.next;
            }
            while (l2 != null) {
                p.next = new ListNode((l2.val + carry) % 10);
                carry = l2.val + carry >= 10 ? 1 : 0;
                l2 = l2.next;
                p = p.next;
            }
            if (carry == 1) {
                p.next = new ListNode(1);
            }
            return result.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
