//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule207 {
        private static boolean rez = true;
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> map = new HashMap<>();

            int counter = 1;
            for (int i = 0; i < prerequisites.length; i++) {
                map.getOrDefault(prerequisites[i][0], new ArrayList<Integer>()).add(prerequisites[i][1]);
            }
            for (int i = 0; i < prerequisites.length; i++) {
                if (isSequential(prerequisites, prerequisites[i][0], prerequisites[i][0], map)) counter++;
            }
            return counter >= numCourses;
        }

        private static boolean isSequential(int[][] prerequisites, int course, int investigationKey, Map<Integer, List<Integer>> map)
        {

            if (map.containsKey(investigationKey) && map.get(investigationKey) != null && !map.get(investigationKey).isEmpty()) {
                for (int prev : map.get(investigationKey)) {
                    if (prev == course) {
                        rez = false;
                    } else isSequential(prerequisites, course, prev, map);
                }
            }
            return rez;
        }
}