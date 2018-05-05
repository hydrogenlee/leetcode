package leetcode.code_0021_0030;

public class Code_0025_Reverse_Nodes_in_k_Group {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = Solution.reverseKGroup(head, 3);
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
        public static ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k <= 1) {
                return head;
            }

            ListNode temp = new ListNode(-1);   // 头结点
            temp.next = head;
            head = temp;
            int count = 0;

            // 使用头插法
            while (temp.next != null) {
                ListNode p = temp;

                while (p.next != null && count < k) {
                    p = p.next;
                    count++;
                }
                if (count < k) {
                    // 没有足够的k个数进行交换
                    return head.next;
                }

                // reverse
                ListNode tempHead = temp;
                ListNode tempTail = temp.next;
                ListNode q;         // 辅助交换
                temp = temp.next;   // 指向下一个需要操作的节点
                while (count > 0) {
                    q = temp;
                    temp = temp.next;
                    q.next = tempHead.next;
                    tempHead.next = q;
                    count--;
                }
                tempTail.next = temp;
                temp = tempTail;        // 前移一个位置，便于下一次插入
            }
            return head.next;
        }
    }
}