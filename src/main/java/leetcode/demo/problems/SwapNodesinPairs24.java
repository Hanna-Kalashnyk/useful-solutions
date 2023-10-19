//Given a linked list, swap every two adjacent nodes and return its head.
// You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
package leetcode.demo.problems;

public class SwapNodesinPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode second = head.next;
        ListNode third = second.next;
        second.next = head;
        second.next.next = swapPairs(third);
        return second;
    }
}
