import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayDeque ad = new ArrayDeque();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                ad.push(x);
            }
            else if(s.equals("top")){
                if(ad.size() >0)
                    sb.append(ad.peek()).append('\n');
                else
                    sb.append(-1).append('\n');
            }
            else if(s.equals("size")){
                sb.append(ad.size()).append('\n');
            }
            else if(s.equals("pop")){
                if(ad.size() >0)
                    sb.append(ad.pop()).append('\n');
                else
                    sb.append(-1).append('\n');
            } else if (s.equals("empty")) {
                if(ad.size() > 0)
                    sb.append(0).append('\n');
                else
                    sb.append(1).append('\n');
            }
        }
        System.out.println(sb);
    }
}
