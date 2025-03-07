import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(s < n) return new int[]{-1};
        
        int num = s / n;
        int plus = s % n;
        for (int i = 0; i < n; i++) {
            answer[i] = num;
        }
        
        for (int i = 0; i < plus; i++) {
            answer[n - 1 - i]++;
        }
            
        return answer;
    }
}