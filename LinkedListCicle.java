package leetcode;

public class LinkedListCicle
{/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

    public ListNode detectCycle(ListNode head) {

        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode pos = null;
        while (head != null)
        {
            if (map.containsKey(head.next))
            {
                return head.next;
            }
            map.put(head, head.next);
            head = head.next;
        }return  pos;
    }
}
