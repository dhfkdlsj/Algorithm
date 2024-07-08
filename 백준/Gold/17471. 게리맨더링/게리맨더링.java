import java.io.*;
import java.util.*;

public class Main {
    static int N, total, min;
    static int[] person;
    static ArrayList<Integer>[] list;

    static boolean isConnected(List<Integer> group) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(group.get(0));
        visited[group.get(0)] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : list[cur]) {
                if (group.contains(next) && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count == group.size();
    }

    static void check(int bitmask) {
        List<Integer> group1 = new ArrayList<>();
        List<Integer> group2 = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if ((bitmask & (1 << i)) > 0) {
                group1.add(i + 1);
            } else {
                group2.add(i + 1);
            }
        }

        if (group1.isEmpty() || group2.isEmpty()) return;

        if (isConnected(group1) && isConnected(group2)) {
            int sum1 = 0;
            int sum2 = 0;

            for (int num : group1) sum1 += person[num];
            for (int num : group2) sum2 += person[num];

            min = Math.min(min, Math.abs(sum1 - sum2));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        list = new ArrayList[N + 1];
        person = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            for (int j = 0; j < x; j++) {
                int y = Integer.parseInt(st.nextToken());
                list[i].add(y);
            }
        }

        int totalSubsets = 1 << N;
        for (int bitmask = 1; bitmask < totalSubsets; bitmask++) {
            check(bitmask);
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
