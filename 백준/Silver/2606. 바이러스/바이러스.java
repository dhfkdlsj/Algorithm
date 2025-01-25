import java.util.*;
import java.io.*;
public class Main {
    static int computer,pair,count;
    static boolean[] v;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        computer = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());
        list = new ArrayList[computer+1];
        v = new boolean[computer+1];

        for (int i = 1; i < computer+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        count = 0;
        dfs(1);
        System.out.println(count);

        br.close();
    }

    private static void dfs(int number) {
        v[number] = true;
        for (int i : list[number]) {
            if (!v[i]) {
                count++;
                dfs(i);
            }
        }
    }


}
