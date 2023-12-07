package leetcode.demo.problems;

import java.util.*;

/**
 * There are n cars going to the same destination along a one-lane road. The destination is target miles away.
 * <p>
 * You are given two integer array position and speed, both of length n, where position[i] is the position
 * of the ith car and speed[i] is the speed of the ith car (in miles per hour).
 * <p>
 * A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed.
 * The faster car will slow down to match the slower car's speed. The distance between these two cars is ignored
 * (i.e., they are assumed to have the same position).
 * <p>
 * A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.
 * <p>
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 * <p>
 * Return the number of car fleets that will arrive at the destination.
 */
public class CarFleet853 {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(e -> e));
        int n = speed.length;
        double gapTime = 0;
        for (int i = 0; i < n; i++) {
            map.put(position[i], speed[i]);
        }

        int count = 1;
        Map.Entry<Integer, Integer> prev = map.pollLastEntry();

        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> cur = map.pollLastEntry();
            double prevGapTime = (double) (target - prev.getKey()) / prev.getValue();

            if (!Objects.equals(cur.getValue(), prev.getValue())) {
                gapTime = (double) (prev.getKey() - cur.getKey()) / Math.abs(cur.getValue() - prev.getValue());
                if (gapTime > prevGapTime || prev.getValue() >= cur.getValue()) {
                    count++;
                    prev = cur;
                }
            }
        }
        return count;
    }

    public int carFleet1(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>(Comparator.comparingInt(e -> e));
        int n = speed.length;
        for (int i = 0; i < n; i++) {
            map.put(position[i], (double) (target - position[i]) / speed[i]);
        }

        int count = 1;
        Map.Entry<Integer, Double> prev = map.pollLastEntry();

        while (!map.isEmpty()) {
            Map.Entry<Integer, Double> cur = map.pollLastEntry();

// If the current car arrives later than the one behind it, it forms a new fleet
            if (cur.getValue() > prev.getValue()) {
                count++;
                prev = cur;
            }
        }
        return count;
    }
}

