package leetcode.demo.problems;
/*
Nested List Weight Sum II
You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also
be integers or other lists.

The depth of an integer is the number of lists that it is inside of.
For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
Let maxDepth be the maximum depth of any integer.

The weight of an integer is maxDepth - (the depth of the integer) + 1.
Return the sum of each integer in nestedList multiplied by its weight.


 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedListSum {

}
    class Solution {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            int maxDepth = 1;
            for (int i = 0; i < nestedList.size(); i++) {
                makeMap(nestedList.get(i).getList(), 1, 0, map);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                res += (maxDepth - entry.getValue()) * entry.getKey();
            }
            return res;

        }



        public static void makeMap (NestedInteger nestedList, int depth, int maxDepth, Map<Integer, Integer> map) {

            if (!nestedList.isInteger()) {
                depth++;
                for (Object list : nestedList ) {
                    makeMap((NestedInteger) list, depth, maxDepth, map);
                }
            } else {
                maxDepth = Math.max(depth, maxDepth);
                map.put(nestedList.getInteger(), depth);
                return;
            }
        }
    }