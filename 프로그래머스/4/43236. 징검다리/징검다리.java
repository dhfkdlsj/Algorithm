import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int maxRemovals) {
        int maxMinDistance = 0;
        
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (countRemovals(rocks, mid, distance) <= maxRemovals) {
                maxMinDistance = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return maxMinDistance;
    }
    
    public int countRemovals(int[] rocks, int minDistance, int totalDistance) {
        int prevRock = 0;
        int removeCount = 0;
        
        for (int rock : rocks) {
            if (rock - prevRock < minDistance) {
                removeCount++;
                continue;
            }
            prevRock = rock;
        }
        
        if (totalDistance - prevRock < minDistance) removeCount++;
        
        return removeCount;
    }
}
