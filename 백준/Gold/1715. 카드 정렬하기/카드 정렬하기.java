import java.io.*;
import java.util.*;

public class Main {
	static int N;
    static long  sum,A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
        	pq.add(Long.parseLong(br.readLine()));
        }
        
        sum =0;
        
        while(pq.size()>1) {
        	long first = pq.poll();
        	long second = pq.poll();
        	long mix = first+second;
        	sum += mix;
        	pq.add(mix);
        }
        System.out.println(sum);
    }
}
