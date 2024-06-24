import  java.io.*;
import  java.util.*;

public class Main {
	static int N,S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		while(queue.size()>1) {
			queue.pop();
			S = queue.pop();
			queue.offer(S);
		}
		System.out.println(queue.peek());
	}
}
