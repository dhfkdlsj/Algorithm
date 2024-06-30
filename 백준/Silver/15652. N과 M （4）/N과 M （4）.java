import java.io.*;
import java.util.*;

public class Main {
    static int N,R;
    static int[]a, b;
    static StringBuilder sb = new StringBuilder();
    static void nm3(int cnt,int start){
        if(cnt == R){
            for(int x:b) sb.append(x).append(" ");
            sb.append("\n");
            return;
        }
        for(int i=start; i<N; i++){
            b[cnt] = a[i];
            nm3(cnt+1,i);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        a = new int[N];
        b = new int[R];

        for(int i=0; i<N; i++){
            a[i] = i+1;
        }

        nm3(0,0);
        System.out.println(sb);

    }
}
