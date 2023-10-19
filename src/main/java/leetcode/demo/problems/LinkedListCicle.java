package leetcode.demo.problems;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCicle
{/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

    public boolean detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while(head != null){
            if (set.contains(head)){
                return  true;
            }else
            {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
