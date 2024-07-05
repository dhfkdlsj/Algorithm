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
            System.out.println(3);
            return;
        }

        int S[] = new int[N + 1];
        S[1] = 1;
        S[2] = 3;
        
        for (int i = 3; i <= N; i++) {
        	S[i] = (S[i - 1] + 2*(S[i - 2])) % 10007;
        }
		
		System.out.println(S[N]);
	}

}
