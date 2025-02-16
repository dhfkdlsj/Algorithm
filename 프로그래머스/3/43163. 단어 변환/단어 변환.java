import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        if (!Arrays.asList(words).contains(target)) return 0;
        
        dfs(begin, target, words, 0);
        
        if (answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }
    private static void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && findOneCharDifference(begin, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
        
    }
    
    private static boolean findOneCharDifference(String begin, String word) {
        int count = 0;
        for(int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i)!=word.charAt(i)) {
                count++;
            }
        }
        if (count == 1) return true;
        return false;
    }
}