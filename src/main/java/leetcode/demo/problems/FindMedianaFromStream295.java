package leetcode.demo.problems;

import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 */
public class FindMedianaFromStream295 {
    PriorityQueue<Integer> bigger = new PriorityQueue<>();
    PriorityQueue<Integer> smaller = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

    public void addNum(int num) {
        if (!smaller.isEmpty() && num < smaller.peek()) {
            smaller.offer(num);
        } else {
            bigger.offer(num);
        }
        if (Math.abs(bigger.size() - smaller.size()) > 10) balance(bigger, smaller);
    }

    private void balance(PriorityQueue<Integer> bigger, PriorityQueue<Integer> smaller) {
        while (smaller.size() > bigger.size()) {
            bigger.offer(smaller.poll());
        }
        while (bigger.size() > smaller.size() + 1) {
            smaller.offer(bigger.poll());
        }
    }

    public double findMedian() {
        if ( bigger.isEmpty()) return 0;
        return bigger.size() == smaller.size() ? (double) (bigger.peek() + smaller.peek()) /2 : bigger.element();
    }
}

/*
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */