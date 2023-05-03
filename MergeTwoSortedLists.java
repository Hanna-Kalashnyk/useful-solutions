//You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists in a one sorted list. The list should be made
// by splicing together the nodes of the first two lists.

//Return the head of the merged linked list.
package leetcode;

public class MergeTwoSortedLists
{
    public class ListNode
    {
        int val;
        ListNode next;

        ListNode()
        {
        }

        ListNode(int val)
        {
            this.val = val;
        }

        ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        if ( list1 == null || list2 == null )
            return list1 != null ? list1 : list2;
        if ( list1.val < list2.val )
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        else if ( list1.val == list2.val )
            return new ListNode(list1.val, new ListNode(list2.val, mergeTwoLists(list1.next, list2.next)));
        else if ( list1.val > list2.val )
            return new ListNode(list2.val, mergeTwoLists(list2.next, list1));
        return null;
    }
}
