import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        if (N<=0) {
            System.err.println("1이상의 수만 입력 가능합니다.");
        }
        int[] number = new int[N+1];
        Arrays.fill(number, Integer.MAX_VALUE);
        number[1] = 0;
        if (N>=2)
            number[2] = 1;
        if (N>=3)
            number[3] = 1;

        for (int i=4; i<N+1; i++) {
            if (i%3==0){
                number[i] = Math.min(number[i],number[i/3]+1);
            }
            if (i%2==0){
                number[i] = Math.min(number[i],number[i/2]+1);
            }
            number[i] = Math.min(number[i],number[i-1]+1);
        }
        System.out.println(number[N]);

    }
}
