import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int offset = 10_000_000; // 음수를 처리하기 위한 오프셋
        int[] countArray = new int[20_000_001]; // -10,000,000 ~ 10,000,000

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            countArray[num + offset]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(countArray[target + offset]).append(" ");
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}
