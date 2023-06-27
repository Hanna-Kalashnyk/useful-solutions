//You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//Merge all the linked-lists into one sorted linked-list and return it.

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
class MergekSortedLists23.java{
public ListNode mergeKLists(ListNode[]lists)
	{List ll = new ArrayList();
		if (lists.length == 0) return null;
		ListNode currentMerge=lists[0];
		for(int i=1;i<lists.length;i++)
		{
			currentMerge=mergeTwoLists(currentMerge,lists[i]);
		}
	return currentMerge;
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