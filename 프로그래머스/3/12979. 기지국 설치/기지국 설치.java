import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2 * w + 1;

        int left = stations[0] - w - 1;
        if (left > 0) {
            answer += (left + range - 1) / range;
        }

        for (int i = 0; i < stations.length - 1; i++) {
            int right = stations[i] + w;
            int next = stations[i + 1] - w - 1;
            int gap = next - right;
            if (gap > 0) {
                answer += (gap + range - 1) / range;
            }
        }

        int right = stations[stations.length - 1] + w;
        if (right < n) {
            int gap = n - right;
            answer += (gap + range - 1) / range;
        }

        return answer;
    }
}
