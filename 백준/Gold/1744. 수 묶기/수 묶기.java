import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(br.readLine());
            if(data > 1) plusPq.add(data);
            else if(data == 1) one++;
            else if(data == 0) zero++;
            else minusPq.add(data);
        }

        int sum = 0;
        while(plusPq.size() > 1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum += (first*second);
        }
        if (!plusPq.isEmpty()) {
            sum += plusPq.remove();
        }

        while (minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum += (first*second);
        }
        if(!minusPq.isEmpty()){
            if (zero == 0) {
                sum = sum + minusPq.remove();
            }
        }
        sum += one;
        System.out.println(sum);
        br.close();
    }

}
