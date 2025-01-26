import  java.io.*;
import  java.util.*;

public class Main {
    static final int[] di = {-1,0,1,0};
    static final int[] dj = {0,1,0,-1};
    static int N,C,M=0;
    static int[][] a;
    static boolean [][]v;

    static int dfs(int i, int j) {
        v[i][j] = true;
        M++;
        for(int d=0; d<4; d++) {
            int ni = i+di[d];
            int nj = j+dj[d];
            if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && a[ni][nj] == 1) {
                dfs(ni,nj);
            }
        }
        return M;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        v = new boolean[N][N];
        a = new int[N][N];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for(int k=0; k<str.length(); k++) {
                a[i][k] = str.charAt(k) - '0';
            }
        }
        
        C = 0;
        for (int i=0; i<N; i++) {
            for(int j=0;j<N; j++) {
                if (a[i][j] == 1 && !v[i][j]) {
                    M = 0;
                    int x = dfs(i,j);
                    list.add(x);
                    C++;
                }
            }
        }
        Collections.sort(list);
        sb.append(C).append("\n");
        for(int d:list) sb.append(d).append("\n");
        System.out.println(sb);
    }
}

