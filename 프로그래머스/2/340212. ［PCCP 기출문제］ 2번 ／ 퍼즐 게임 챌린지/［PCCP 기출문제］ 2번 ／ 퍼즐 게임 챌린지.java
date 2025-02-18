import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max = Arrays.stream(diffs).max().getAsInt();
        int min = 1;
        int result = 0;
        
        while (max >= min) {
            int mid = (max + min) / 2;
            long durationTime = puzzle(diffs, times, mid);
            if(durationTime <= limit) {
                max = mid - 1;
                result = mid;
            }
            else {
                min = mid + 1;
            }
        }
        return result;
    }
    
    private long puzzle(int[] diffs, int[] times, long level) {
        long durationTime = 0L;
        int timePrev = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                durationTime += times[i];
            }
            else {
                durationTime += (diffs[i] - level) * (timePrev + times[i]) + times[i];
            }
            timePrev = times[i];
        }
        return durationTime;
    }
}