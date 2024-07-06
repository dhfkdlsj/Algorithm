import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] S = new int[12];
        S[1] = 1;
        S[2] = 2;
        S[3] = 4;
        for(int i=4; i<12; i++){
            S[i] = S[i-1] + S[i-2] + S[i-3];
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(S[n]).append("\n");
        }
        System.out.println(sb);
    }
}
