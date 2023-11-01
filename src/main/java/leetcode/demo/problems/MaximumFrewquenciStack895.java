//package leetcode.demo.problems;
//
//import java.util.*;
//
///**
// * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
// * <p>
// * Implement the FreqStack class:
// * <p>
// * FreqStack() constructs an empty frequency stack.
// * void push(int val) pushes an integer val onto the top of the stack.
// * int pop() removes and returns the most frequent element in the stack.
// * If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
// */
//public class MaximumFrewquenciStack895 {
//    private Stack<Integer> stack;
//    private SortedMap<Integer, Integer> map;
//    private PriorityQueue<Integer> queue;
//    public MaximumFrewquenciStack895() {
//        stack = new Stack<>();
//        map = new TreeMap<>(Integer.compare());
//        queue = new PriorityQueue<>(Collections.reverseOrder());
//    }
//
//    public void push(int val) {
//stack.push(val);
//map.put(val, map.getOrDefault(val, 0) + 1);
//queue.add
//    }
//
//    public int pop() {
//
//    }
//}
//
///**
// * Your FreqStack object will be instantiated and called as such:
// * FreqStack obj = new FreqStack();
// * obj.push(val);
// * int param_2 = obj.pop();
// */