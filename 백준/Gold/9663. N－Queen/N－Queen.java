import java.io.*;
import java.util.*;

public class Main {
    static int N,cnt, board[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N];
        cnt = 0;
        
        nqueen(0);

        System.out.println(cnt);
    }

    private static void nqueen(int row) {
        if (notAvailable(row-1)){
            return;
        }
        if (row == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            board[row] = i;
            nqueen(row+1);
        }
    }

    private static boolean notAvailable(int RowNo) {
        for (int i = 0; i < RowNo; i++) {
            if (board[i] == board[RowNo] || Math.abs(board[i] - board[RowNo]) == RowNo - i){
                return true;
            }
        }
        return false;
    }

}

