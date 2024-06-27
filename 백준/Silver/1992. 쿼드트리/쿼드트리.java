import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
        	String s = br.readLine();
            for (int j = 0; j < N; j++) {
                paper[i][j] = s.charAt(j)-48;
            }
        }

        cutPaper(0, 0, N);

    }

    static void cutPaper(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            if (paper[x][y] == 0) {
                System.out.print(0);
            } else {
            	System.out.print(1);
            }
            return;
        }
        System.out.print("(");
        int newSize = size / 2;
        cutPaper(x, y, newSize);
        cutPaper(x, y + newSize, newSize);
        cutPaper(x + newSize, y, newSize);
        cutPaper(x + newSize, y + newSize, newSize);
        System.out.print(")");
    }

    static boolean isSameColor(int x, int y, int size) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
