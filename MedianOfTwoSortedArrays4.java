//Given two sorted arrays nums1 and nums2 of size m and n respectively,
// return the median of the two sorted arrays.
//
//The overall run time complexity should be O(log (m+n)).
//This solution does not take extra space and iterates the least possible
//also this solution supports situation when both arrays are of length Integer.MAX_VALUE
// O((m + n) / 2)
 package leetcode;

public class MedianOfTwoSortedArrays4 {
        public double findMedianSortedArrays ( int[] nums1, int[] nums2){
        int length = nums1.length + nums2.length;
        int[] arr = new int[length / 2 + 1];
        int nums1Index = 0;
        int nums2Index = 0;
        int i = 0;

        while ( i < arr.length )
        {
            if ( nums1Index < nums1.length && nums2Index < nums2.length )
            {
                if ( nums1[nums1Index] < nums2[nums2Index] )
                {
                    arr[i++] = nums1[nums1Index++];
                }
                else
                {
                    arr[i++] = nums2[nums2Index++];
                }
            }
            else if ( nums1Index < nums1.length )
            {
                arr[i++] = nums1[nums1Index++];
            }
            else
            {
                arr[i++] = nums2[nums2Index++];
            }
        }

        if ( length % 2 == 1 )
        {
            return arr[arr.length - 1];
        }
        else
        {
            double temp = ((arr[arr.length - 2] + arr[arr.length - 1])) / 2.00;
            return temp;
        }
    }
    }
