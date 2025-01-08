import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] number;
    static int[] findNumber;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        number = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        findNumber = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++){
            findNumber[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i<M; i++){
            if(find(findNumber[i], 0, N-1)) {
                sb.append("1\n");
            }
            else {
                sb.append("0\n");
            }
        }

        System.out.println(sb);

        br.close();
    }

    private static boolean find(int num, int start, int end) {
        while(start <= end){
            int middle = (start + end) / 2;
            if (num == number[middle]) {
                return true;
            }
            if (num > number[middle]) {
                start = middle + 1;
            }
            if (num < number[middle]) {
                end = middle - 1;
            }
        }
        return false;
    }
}





