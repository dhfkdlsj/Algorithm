import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque ad;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            String s = br.readLine();
            ad = new ArrayDeque();
            boolean b = true;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == '(') {
                    ad.push(c);
                }
                else{
                    if(ad.size()>0)
                        ad.pop();
                    else{
                        b = false;
                        break;
                    }
                }
            }
            if(ad.size() > 0) {
                sb.append("NO").append('\n');
            }
            else {
                if (!b){
                    sb.append("NO").append('\n');
                }
                else {
                    sb.append("YES").append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}