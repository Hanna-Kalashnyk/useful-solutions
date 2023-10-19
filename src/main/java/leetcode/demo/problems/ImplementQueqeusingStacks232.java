//Implement a first in first out (FIFO) queue using only two stacks.
// The implemented queue should support all the functions of a normal queue
// (push, peek, pop, and empty).
//
//Implement the MyQueue class:
//
//void push(int x) Pushes element x to the back of the queue.
//int pop() Removes the element from the front of the queue and returns it.
//int peek() Returns the element at the front of the queue.
//boolean empty() Returns true if the queue is empty, false otherwise.
//Notes:
//
//You must use only standard operations of a stack, which means only push to top,
// peek/pop from top, size, and is empty operations are valid.
//Depending on your language, the stack may not be supported natively.
// You may simulate a stack using a list or deque (double-ended queue)
// as long as you use only a stack's standard operations.
//
package leetcode.demo.problems;

import java.util.Stack;

public class ImplementQueqeusingStacks232
{
	private Stack<Object> inQueue;
	private Stack<Object> outQueue;
	public ImplementQueqeusingStacks232() {
		inQueue = new Stack<Object>();
		outQueue = new Stack<Object>();
	}
	
	public void push(int x) {
		this.inQueue.push(x);
	}
	
	public int pop() {
		while (!inQueue.isEmpty()){
			outQueue.push(inQueue.pop());
		}
		if (outQueue.isEmpty()) return 0;
		int poped = (Integer)this.outQueue.pop();
		while (!outQueue.isEmpty()){
			inQueue.push(outQueue.pop());
		}
		return poped;
	}
	
	public int peek() {
		while (!inQueue.isEmpty()){
			outQueue.push(inQueue.pop());
		}
		if (outQueue.isEmpty()) return 0;
		int peeked = (Integer)this.outQueue.peek();
		while (!outQueue.isEmpty()){
			inQueue.push(outQueue.pop());
		}
		return peeked;
	}
	
	public boolean empty() {
		return this.inQueue.empty() && this.outQueue.empty();
	
	}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
