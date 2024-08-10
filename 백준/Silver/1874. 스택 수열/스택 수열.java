import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        int current = 1; // 스택에 넣을 숫자

        boolean possible = true;
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            // target까지 숫자를 스택에 넣음
            while (current <= target) {
                stack.push(current);
                sb.append("+\n"); // push 연산 기록
                current++;
            }

            // 스택의 최상단이 target과 일치하면 pop
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n"); // pop 연산 기록
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}
