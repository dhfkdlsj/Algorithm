import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayDeque ad = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            if(x.equals("push")){
                ad.addLast(st.nextToken());
            } else if (x.equals("front")) {
                if(ad.size()>0)
                    sb.append(ad.peekFirst()).append('\n');
                else
                    sb.append(-1).append('\n');
            } else if (x.equals("pop")) {
                if(ad.size()>0)
                    sb.append(ad.pollFirst()).append('\n');
                else
                    sb.append(-1).append('\n');
            } else if (x.equals("size")) {
                sb.append(ad.size()).append('\n');
            } else if (x.equals("empty")) {
                if(ad.size()>0)
                    sb.append(0).append('\n');
                else
                    sb.append(1).append('\n');
            } else {
                if(ad.size()>0)
                    sb.append(ad.peekLast()).append('\n');
                else
                    sb.append(-1).append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }
}