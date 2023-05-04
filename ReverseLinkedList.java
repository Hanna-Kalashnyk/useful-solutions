package leetcode;

public class ReverseLinkedList
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
    public ListNode reverseList(ListNode head)
    {
        if ( head == null || head.next == null )
            return head;

        ListNode p = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return p;
    }
    
        public ListNode reverseListNoRecursion(ListNode head) {
        ListNode prev = null;  
        ListNode current = head;
    
        
        while(current != null) { 
            ListNode next = current.next; 
            current.next = prev;
            prev = current;
            current = next;
        }
       return prev; 
    }
}
