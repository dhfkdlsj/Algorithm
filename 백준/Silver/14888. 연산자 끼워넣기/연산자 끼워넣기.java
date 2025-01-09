import java.io.*;
import java.util.*;

public class Main {
    static int N, min, max;
    static int[] number;
    static int[] operatorCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        operatorCount = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operatorCount[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        calculate(1, number[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void calculate(int index, int currentResult) {
        if (index == N) {
            max = Math.max(max, currentResult);
            min = Math.min(min, currentResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operatorCount[i] > 0) {
                operatorCount[i]--;

                switch (i) {
                    case 0: // Addition
                        calculate(index + 1, currentResult + number[index]);
                        break;
                    case 1: // Subtraction
                        calculate(index + 1, currentResult - number[index]);
                        break;
                    case 2: // Multiplication
                        calculate(index + 1, currentResult * number[index]);
                        break;
                    case 3: // Division
                        calculate(index + 1, currentResult / number[index]);
                        break;
                }

                operatorCount[i]++;
            }
        }
    }
}
