import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }

        // 시작 시간을 기준으로 정렬
        list.sort(Comparator.comparingInt(a -> a[0]));

        // 우선순위 큐(최소 힙)를 사용하여 회의 종료 시간을 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0)[1]);

        for (int i = 1; i < list.size(); i++) {
            int[] meeting = list.get(i);

            // 현재 회의의 시작 시간이 가장 빨리 끝나는 회의의 종료 시간보다 크거나 같다면
            // 회의실을 재사용할 수 있음
            if (meeting[0] >= pq.peek()) {
                pq.poll(); // 가장 빨리 끝나는 회의 제거
            }

            // 새로운 회의의 종료 시간을 추가
            pq.add(meeting[1]);
        }

        // 최소 힙에 남아있는 요소의 개수가 필요한 강의실의 수
        System.out.println(pq.size());
    }
}
