import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Long start = 1L;
        Long end = (long)Arrays.stream(times).max().getAsInt() * (long)n;
        Long answer = 0L;
        
        while (start <= end) {
            Long people = 0L;
            Long mid = (start + end) / 2;
            for (int time : times) {
                people += mid / time;
            }
            if (people < n) {
                start = mid + 1;
            }
            else {
                answer = mid;
                end = mid - 1;
            }
        }
        
        return answer;
    }
}