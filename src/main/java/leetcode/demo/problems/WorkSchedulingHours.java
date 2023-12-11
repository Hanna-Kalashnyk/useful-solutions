package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Remote task interview
 * REturn the list or all possible scheduling to fulfill the work of workHours. No more, than maxDay hours per day.
 */

public class WorkSchedulingHours {
    public List<List<Integer>> findAllSchedulings(int workHours, int maxDay, int daysNum) {
        List<List<Integer>> res = new ArrayList<>();
        int[] workSessions = new int[maxDay + 1];
        for (int i = 0; i <= maxDay; i++) {
            workSessions[i] = i;
        }
        findSched(res, new ArrayList<Integer>(), workSessions, 0,0, 0, workHours, daysNum);
        return res;
    }

    private static void findSched(List<List<Integer>> res, ArrayList<Integer> sched, int[] workSessions, int start, int sumH, int count, int workHours, int daysNum) {
        if (sumH == workHours && count <= daysNum) {
            if (sched.size() < daysNum) {
                for ( int i = 0; i < daysNum - sched.size(); i++) {
                    sched.add(0);
                }
            }
            res.add(new ArrayList<>(sched));
            return;
        }

        for (int i = 0; i < workSessions.length; i++) {
            sumH += workSessions[i];
            count++;
            sched.add(workSessions[i]);
            findSched(res, sched, workSessions,  i, sumH, count, workHours, daysNum);
            count--;
            sched.remove(sched.remove(sched.size())- 1);
            sumH -= workSessions[i];
        }

    }
}
