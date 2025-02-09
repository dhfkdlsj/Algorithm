import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); 
            int[][] applicants = new int[N][2];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                applicants[i][0] = Integer.parseInt(input[0]); 
                applicants[i][1] = Integer.parseInt(input[1]); 
            }

            Arrays.sort(applicants, (a, b) -> Integer.compare(a[0], b[0]));

            int count = 1; 
            int minSecondRank = applicants[0][1]; 

            for (int i = 1; i < N; i++) {
                if (applicants[i][1] < minSecondRank) {
                    count++;
                    minSecondRank = applicants[i][1];
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
