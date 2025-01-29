import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] request = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            request[i] = Integer.parseInt(st.nextToken());
        }

        int money = Integer.parseInt(br.readLine());

        Arrays.sort(request);

        int left = 0;
        int right = request[N-1];
        int result = 0;

        while(left<=right){
            int mid = (left+right) / 2;
            int sum = 0;

            for (int i : request){
                sum += Math.min(i,mid);
            }

            if (sum <= money){
                result = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        System.out.println(result);
        br.close();
    }
}
