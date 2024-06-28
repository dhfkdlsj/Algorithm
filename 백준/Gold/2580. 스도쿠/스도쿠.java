import java.io.*;
import java.util.*;

public class Main {
	static int S[][], cnt;
	static StringBuilder sb = new StringBuilder();
	static boolean solved = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		cnt = 0;

		S = new int[9][9];
		for (int i = 0; i < S.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < S.length; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		supernova(0, 0);

		br.close();
	}

	static void supernova(int row, int col) {
		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(S[i][j]).append(" ");
				}
				sb.append("\n");
			}
			 solved = true;
			 System.out.println(sb.toString());
			return;
		}
		
		if (col == 9) {
			supernova(row + 1, 0);
			return;
		}
		if(S[row][col]==0) {
			for (int i = 1; i < 10; i++) {
				if (isRight(row, col, i)) {
					S[row][col] = i;
					supernova(row, col + 1);
					 if (solved) return;
	                 S[row][col] = 0;
				}
			}
		}
		 else {
	            supernova(row, col + 1);
	        }
	}

	private static boolean isRight(int row, int col, int val) {
		for (int i = 0; i < 9; i++) {
			if (S[row][i] == val)
				return false;
			if (S[i][col] == val)
				return false;
		}
		int newrow = row / 3 * 3;
		int newcol = col / 3 * 3;
		for (int k = newrow; k < newrow+3; k++) {
			for (int j = newcol; j < newcol+3; j++) {
				if (S[k][j] == val)
					return false;
			}
		}
		return true;
	}

}
