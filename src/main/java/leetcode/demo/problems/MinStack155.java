//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//Implement the MinStack class:
//
//MinStack() initializes the stack object.
//void push(int val) pushes the element val onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.
//You must implement a solution with O(1) time complexity for each function.
package leetcode.demo.problems;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack155 {
    class MinStack {
        PriorityQueue<Integer> pq;
        Stack<Integer> minStack;

        public MinStack() {
            minStack = new Stack<>();
            pq = new PriorityQueue<>();
        }

        public void push(int val) {
            minStack.push(val);
            pq.add(val);
        }

        public void pop() {
            Integer removed = minStack.pop();
            pq.remove(removed);
        }

        public int top() {
            return minStack.peek();
        }

        public int getMin() {
            return pq.peek();
        }
    }
}
