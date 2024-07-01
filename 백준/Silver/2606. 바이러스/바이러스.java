import java.util.*;
import java.io.*;

public class Main {
	static int Computer,Pair,cnt;
	static ArrayList<Integer>[] list;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Computer = Integer.parseInt(br.readLine());
		Pair = Integer.parseInt(br.readLine());
		v = new boolean[Computer+1];
		list = new ArrayList[Computer+1];
		
		for(int i =0; i< Computer+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i =0; i< Pair; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		dfs(1);
		System.out.println(cnt);
	}
	static void dfs(int i) {
		v[i] = true;
		for(int j=0; j<list[i].size(); j++) {
			if(!v[list[i].get(j)]) {
				cnt++;
				dfs(list[i].get(j));
			}
		}
	}
}
