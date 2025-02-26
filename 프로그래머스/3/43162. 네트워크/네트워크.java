import java.util.*;
class Solution {
    static boolean[] visited;
    static int network;
    static ArrayList<Integer>[] list;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        network = 0;
        list = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    list[i].add(j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                network++;
            }
        }
        return network;
        
    }
    static void dfs(int i) {
        visited[i] = true;
        for(int j = 0; j < list[i].size(); j++) {
            if(!visited[list[i].get(j)]) dfs(list[i].get(j));
        }
    }
}