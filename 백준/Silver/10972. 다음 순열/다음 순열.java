import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 기존에는 StringTokenizer로 잘라서 for문 돌리면서 집어 넣었는데, 이런 방법으로 한 번에 넣을 수 있다는 것을 알게되었습니다..
        // 하지만 속도는 더 느리다고 하네요
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        if (nextPermutation(arr)) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("-1");
        }
    }

    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;

        // 뒤에서부터 오름차순이 깨지는 지점 찾기
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i == -1) return false; // 마지막 순열이면 false 반환해서 최종적으로 -1 출력

        // 뒤에서부터 가장 먼저오는 i보다 큰 값 찾아서 swap
        int j = arr.length - 1;
        while (arr[i] >= arr[j]) {
            j--;
        }

        swap(arr, i, j);

        // i 이후의 값들을 오름차순 정렬
        // 앞을 기준으로 볼 때 이미 내림차순 정렬이 되어있기 때문에 뒤집기만해도 오름차순이 된다
        reverse(arr, i + 1, arr.length - 1);

        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}