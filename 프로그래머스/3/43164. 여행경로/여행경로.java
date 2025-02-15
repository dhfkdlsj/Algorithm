import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> allRoute = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        StringBuilder sb = new StringBuilder("ICN");
        
        // StringBuilder 사용해서 문자열 결합 더 쉽게
        dfs("ICN", sb, tickets, 0);
        
        // 여러 경우의 경로들 사전순 정렬하기
        Collections.sort(allRoute);
        
        return allRoute.get(0).split(" ");
    }
    
    public void dfs(String start, StringBuilder answer, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            // 경로가 만들어지면 연결리스트에 추가
            allRoute.add(answer.toString());
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                answer.append(" ").append(tickets[i][1]);
                dfs(tickets[i][1], answer, tickets, cnt+1);
                // return 되면 StringBuilder에 저장된 값 지우기
                // -1은 append(" ") 해줬던 공백 제거
                answer.setLength(answer.length() - tickets[i][1].length() - 1);
                visited[i] = false;
            }
            
        }
    }
}