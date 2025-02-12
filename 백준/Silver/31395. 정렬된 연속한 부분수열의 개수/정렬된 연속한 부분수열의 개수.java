import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long before = Long.parseLong(st.nextToken());  // 제일 앞 숫자 받기
        long now, cnt = 1;  // 1개짜리도 되니까 cnt 1로
        List<Long> increasingLengths = new ArrayList<>(); // 증가하는 부분 수열 길이를 저장할 연결 리스트

        for (long i = 2; i <= N; i++) {
            now = Long.parseLong(st.nextToken());
            // now가 before보다 크면 cnt를 1씩 증가
            if (before < now) {
                cnt++;
            }
            // now가 before보다 작다면 현재 cnt를 increasingLengths에 저장하고 cnt를 1로 초기화
            else {
                increasingLengths.add(cnt);
                cnt = 1;
            }
            before = now;
        }
        // 반복문이 끝나면 추가로 한 번 더 저장
        increasingLengths.add(cnt);

        long sum = 0;
        for (long x : increasingLengths) {
            // 길이가 x인 부분 수열이 있을 경우, 해당 부분 수열 내에서 가능한 (i, j) 쌍의 개수는 x * (x + 1) / 2이다..
            // increasingLengths에 증가하는 부분 수열의 길이들을 저장해 놓았으니 하나씩 꺼내서 위 공식 사용해서 합치기
            sum += x * (x + 1) / 2;
        }
        System.out.println(sum);
    }
}
