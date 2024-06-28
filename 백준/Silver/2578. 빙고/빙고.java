import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[5][5];
    static boolean[][] marked = new boolean[5][5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        outerLoop:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                count++;
                markNumber(num);
                if (checkBingo() >= 3) {
                    System.out.println(count);
                    break outerLoop;
                }
            }
        }

        br.close();
    }

    static void markNumber(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    marked[i][j] = true;
                    return;
                }
            }
        }
    }

    static int checkBingo() {
        int bingoCount = 0;

        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (!marked[i][j]) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                bingoCount++;
            }
        }

        for (int j = 0; j < 5; j++) {
            boolean isBingo = true;
            for (int i = 0; i < 5; i++) {
                if (!marked[i][j]) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                bingoCount++;
            }
        }

        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            bingoCount++;
        }

        isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][4 - i]) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            bingoCount++;
        }

        return bingoCount;
    }
}
