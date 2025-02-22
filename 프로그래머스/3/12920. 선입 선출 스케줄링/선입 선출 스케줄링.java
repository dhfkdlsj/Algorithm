import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int coreCount = cores.length;
        
        if (n <= coreCount) return n;

        int minTime = 1;
        int maxTime = 10000 * n;
        int elapsedTime = 0;
        int totalProcessedTasks = 0;

        while (minTime <= maxTime) {
            int midTime = (minTime + maxTime) / 2;
            int processedTasks = getProcessedTaskCount(midTime, cores);

            if (processedTasks >= n) {
                maxTime = midTime - 1;
                elapsedTime = midTime;
                totalProcessedTasks = processedTasks;
            } else {
                minTime = midTime + 1;
            }
        }

        int remainingTasks = totalProcessedTasks - n;
        for (int coreIndex = coreCount - 1; coreIndex >= 0; coreIndex--) {
            if (elapsedTime % cores[coreIndex] == 0) {
                if (remainingTasks == 0) {
                    return coreIndex + 1;
                }
                remainingTasks--;
            }
        }

        return -1;
    }

    private int getProcessedTaskCount(int time, int[] cores) {
        int taskCount = cores.length;

        for (int core : cores) {
            taskCount += time / core;
        }

        return taskCount;
    }
}
