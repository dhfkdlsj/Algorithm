import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int mOne = 0;		
    static int zero = 0;
    static int one = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        division(0, 0, N);

        System.out.println(mOne);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void division(int row, int col, int size) {
        if (numCheck(row, col, size)) {
            if(board[row][col] == -1) {
                mOne++;
            }
            else if(board[row][col] == 0) {
                zero++;
            }
            else {
                one++;
            }

            return;
        }

        int newSize = size / 3;

        division(row, col, newSize);
        division(row, col + newSize, newSize);
        division(row, col + 2 * newSize, newSize);

        division(row + newSize, col, newSize);
        division(row + newSize, col + newSize, newSize);
        division(row + newSize, col + 2 * newSize, newSize);

        division(row + 2 * newSize, col, newSize);
        division(row + 2 * newSize, col + newSize, newSize);
        division(row + 2 * newSize, col + 2 * newSize, newSize);
    }

    private static boolean numCheck(int row, int col, int size) {
        int number = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (number != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
