//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order, and each of their nodes contains a single digit.
// Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
package leetcode.demo.problems;

public class AddTwoNumbers2
{

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int a, b;
        ListNode rez = new ListNode();
        ListNode current = rez;
        int collect = 0;
        while ( l1 != null || l2 != null || collect != 0)
        {
            a = l1 != null ? l1.val : 0;
            b = l2 != null ? l2.val : 0;
            ListNode next = new ListNode((a + b + collect) % 10);
            collect = (a + b + collect) / 10;


            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            current.next = next;
            current = current.next;

        }
        return rez.next;
    }
}
