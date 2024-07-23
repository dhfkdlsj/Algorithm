import java.util.*;
import java.io.*;

public class Main {
	static int N,count;
	static StringBuilder sb = new StringBuilder();
	
	static void hanoi(int n,int from, int to, int mid) {
		count += 1;
		if(n == 1) {
			sb.append(from).append(' ').append(to).append('\n');
			return;
		}
		hanoi(n-1,from,mid,to);
		sb.append(from).append(' ').append(to).append('\n');
		hanoi(n-1,mid,to,from);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		hanoi(N,1,3,2);
		System.out.println(count);
		System.out.println(sb);
	}

}
