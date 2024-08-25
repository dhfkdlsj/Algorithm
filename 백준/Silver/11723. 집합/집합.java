import java.util.*; // Set, HashSet, List, ArrayList, StringTokenizer 등을 위해 필요
import java.io.*;   // BufferedReader, InputStreamReader 등을 위해 필요

public class Main { // 클래스 이름을 대문자로 시작
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<String>();
        List<String> list = new ArrayList<>();
        
        // 1부터 20까지의 숫자를 문자열로 리스트에 추가
        for (int i = 1; i <= 20; i++) {
            list.add(String.valueOf(i));
        }
        
        // 명령의 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 명령 처리
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            // "all"과 "empty"는 별도로 처리
            if (command.equals("all")) {
                set.clear();
                set.addAll(list);
            } else if (command.equals("empty")) {
                set.clear();
            } else {
                String value = st.nextToken();  // 숫자 값 읽기
                
                if (command.equals("add")) {
                    set.add(value);
                } else if (command.equals("remove")) {
                    set.remove(value);
                } else if (command.equals("check")) {
                    if (set.contains(value)) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                } else if (command.equals("toggle")) {
                    if (set.contains(value)) {
                        set.remove(value);
                    } else {
                        set.add(value);
                    }
                }
            }
        }
        
        // 결과 출력
        System.out.print(sb);
    }
}
