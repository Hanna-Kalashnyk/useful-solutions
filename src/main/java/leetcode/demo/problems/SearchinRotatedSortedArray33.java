//Given the array nums after the possible rotation
// and an integer target, return the index of target
// if it is in nums, or -1 if it is not in nums.
package leetcode.demo.problems;

public class SearchinRotatedSortedArray33
{
	public int search(int[] nums, int target)
	{
		//Approach: Using Binary Search, T.C: O(logn), S.C: O(1)
		int l = 0;
		int r = nums.length - 1;
		
		while(l<=r){
			
			int mid = (l+r)/2;
			
			if(nums[mid] == target){
				return mid;
			}
			//left sorted
			if(nums[l]<=nums[mid]){
				if(target > nums[mid] || target < nums[l]){
					l = mid + 1;
				}else{
					r = mid - 1;
				}
			}else{//right sorted
				if(target < nums[mid] || target > nums [r]){
					r = mid - 1;
				}
				else
				{
					l = mid + 1;
				}
			}
		}
		return -1;
	}
}