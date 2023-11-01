package leetcode.demo.problems;

import java.util.*;

/**
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 * <p>
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such
 * that there are no two jobs in the subset with overlapping time range.
 * <p>
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 */
public class MaximumProfitinJobScheduling1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < profit.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        jobs.sort(Comparator.comparingInt(job -> job.endTime));
        TreeMap<Integer, Integer> maxProfit = new TreeMap<>();
        maxProfit.put(0, 0);
        for (Job job : jobs) {
            int prevProfit = maxProfit.floorEntry(job.startTime).getValue();
            int currProfit = prevProfit + job.profit;
            int lastProfit = maxProfit.lastEntry().getValue();
            if (lastProfit < currProfit) {
                maxProfit.put(job.endTime, currProfit);
            }
        }
        return maxProfit.lastEntry().getValue();
    }

    public record Job(int startTime, int endTime, int profit) {
    }
}
