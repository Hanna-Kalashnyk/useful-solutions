//Given the head of a linked list,
// remove the nth node from the end of the list and return its head.
package leetcode.demo.problems;

public class RemoveNthNodeFromEndofList19
{
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode fast = head;
        ListNode slow = head;

        int i = 1;

        while ( i <= n )
        {
            fast = fast.next;
            i++;
        }
        if ( fast == null )
            return head.next;

        while ( fast.next != null )
        {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}