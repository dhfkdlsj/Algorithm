import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int work : works) {
            maxHeap.add(work);
        }
        
        for (int i = 0; i < n; i++) {
            if (maxHeap.isEmpty()) break;
            int maxWork = maxHeap.poll();
            if (maxWork > 0) {
                maxHeap.add(maxWork - 1);
            }
        }
        
         while (!maxHeap.isEmpty()) {
            int work = maxHeap.poll();
            answer += (long) work * work;
        }
        return answer;
    }
}