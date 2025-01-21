import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N == 1) {
            System.out.println(1);
            return;
        }
        
        if (N == 2) {
            System.out.println(2);
            return;
        }

        int prev1 = 1;
        int prev2 = 2;
        int current = 0;

        for (int i = 3; i <= N; i++) {
            current = (prev1 + prev2) % 10007;
            prev1 = prev2;
            prev2 = current;
        }

        System.out.println(current);
        br.close();
    }
}
