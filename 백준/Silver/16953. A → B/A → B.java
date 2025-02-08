import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(greedy(A, B));
    }

    public static int greedy(long A, long B) {
        int count = 1; // 최소 연산 횟수 (B에서 A로 변환하기 때문에 1부터 시작)

        while (B > A) {
            if (B % 2 == 0) {
                B /= 2; // 2로 나누는 연산
            } else if (B % 10 == 1) {
                B /= 10; // 마지막 숫자가 1이면 제거
            } else {
                return -1; // 만들 수 없는 경우
            }
            count++;
        }

        return (B == A) ? count : -1;
    }
}
