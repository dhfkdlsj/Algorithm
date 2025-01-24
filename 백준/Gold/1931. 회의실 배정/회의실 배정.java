import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(meetings, (a,b) -> {
            if (a[1] == b[1]) {
                return
                        Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        
        int count = 0;
        int endtime = 0;
        
        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= endtime) {
                endtime = meetings[i][1];
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}
