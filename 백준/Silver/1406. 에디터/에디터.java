import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        LinkedList<Character> left = new LinkedList<>();
        LinkedList<Character> right = new LinkedList<>();

        // 초기 커서 위치를 맨 오른쪽으로 설정
        for (char c : s.toCharArray()) {
            left.add(c);
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "L":
                    if (!left.isEmpty()) {
                        right.addFirst(left.removeLast());
                    }
                    break;
                case "D":
                    if (!right.isEmpty()) {
                        left.addLast(right.removeFirst());
                    }
                    break;
                case "B":
                    if (!left.isEmpty()) {
                        left.removeLast();
                    }
                    break;
                case "P":
                    left.addLast(command[1].charAt(0));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            sb.append(left.removeFirst());
        }
        while (!right.isEmpty()) {
            sb.append(right.removeFirst());
        }

        System.out.println(sb);
    }
}

