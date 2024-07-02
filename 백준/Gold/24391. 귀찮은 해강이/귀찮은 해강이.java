import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,cnt;
    static int[] p;
    static int find(int a) {
        if (p[a] == a) {
            return a;
        }
        return p[a] = find(p[a]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            p[rootB] = rootA;
        }
    }
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	p =new int[N+1];
    	for(int i=1; i<N+1; i++) p[i] = i;
    	
        for (int i = 1; i < M+1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
    		union(a,b);
        }
        cnt =0;
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
    	int first = find(w); 
        for(int i=1; i < N; i++) {
        	int e = Integer.parseInt(st.nextToken());
        	int se = find(e);
        	if(first == se)continue;
        	else {
        		cnt++;
        		first = find(e);
        	}
        }
        
        System.out.println(cnt);
        br.close();
    }


}