package leetcode;

public class MiddleOfTheLinkedList
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

    public ListNode middleNode(ListNode head)
    {
        ListNode middle = head;
        int count = 0;
        while ( head != null )
        {
            count++;
            if ( count % 2 == 0 )
            {
                middle = middle.next;
            }
            head = head.next;
        }
        return middle;
    }
}
