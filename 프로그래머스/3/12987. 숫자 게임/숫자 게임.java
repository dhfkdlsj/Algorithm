import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int A_i = 0;
        int B_i = 0;
        
        while(true) {
            if(A_i >= A.length || B_i >= B.length) break;
            if(A[A_i] < B[B_i]) {
                answer++;
                A_i++;
                B_i++;
            }
            else {
                B_i++;
            }
        }
        
        return answer;
    }
}