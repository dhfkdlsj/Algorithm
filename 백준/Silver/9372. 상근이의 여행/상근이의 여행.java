import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 

        for (int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken()); 
            
            for (int i = 0; i < M; i++) {
                br.readLine();
            }
            
            System.out.println(N - 1);
        }
    }
}
