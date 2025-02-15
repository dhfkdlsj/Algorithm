import java.io.*;
import java.util.*;

public class Main {
    static int nodeCount, node1, node2;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static int[] parent;
    
    static void findParents(int currentNode) {
        visited[currentNode] = true;
        // 현재 노드와 연결된 모든 노드 탐색
        for (int i = 0; i < adjList[currentNode].size(); i++) {
            int nextNode = adjList[currentNode].get(i);
            if (!visited[nextNode]) {  // 방문하지 않았다면
                visited[nextNode] = true;
                parent[nextNode] = currentNode;  // 부모 저장
                findParents(nextNode);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        
        parent = new int[nodeCount + 1];
        visited = new boolean[nodeCount + 1];
        adjList = new ArrayList[nodeCount + 1];
        
        for (int i = 1; i <= nodeCount; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        // 트리의 간선 정보 입력
        for (int i = 1; i < nodeCount; i++) {
            st = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());
            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }
        
        findParents(1); // 루트 노드부터 DFS 실행
        
        // 2번 노드부터 부모 노드 출력
        for (int i = 2; i <= nodeCount; i++) {
            System.out.println(parent[i]);
        }
    }
}
