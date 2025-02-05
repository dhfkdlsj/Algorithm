import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Integer[] weight = new Integer[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight, Collections.reverseOrder());

        int total = 0;
        for (int i = 0; i < N; i++) {
            total = Math.max(total,weight[i]*(i+1));
        }

        System.out.println(total);
        br.close();
    }
}
