import java.io.*;
import java.util.*;

public class Main {
    static int N,cnt,arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        cnt = 0;
        
        nqueen(0);

        System.out.println(cnt);
    }

    private static void nqueen(int RowNo) {
        if (notAvailable(RowNo-1)){
            return;
        }
        if (RowNo == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[RowNo] = i;
            nqueen(RowNo+1);
        }
    }

    private static boolean notAvailable(int RowNo) {
        for (int i = 0; i < RowNo; i++) {
            if (arr[i] == arr[RowNo] || Math.abs(arr[i] - arr[RowNo]) == RowNo - i){
                return true;
            }
        }
        return false;
    }

}
