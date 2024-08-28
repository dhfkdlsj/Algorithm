import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if( str.equals("#") && age == 0 && weight == 0)
                break;
            if (age > 17 || weight >= 80){
                sb.append(str).append(' ').append("Senior").append('\n');
            }
            else
                sb.append(str).append(' ').append("Junior").append('\n');
        }
        System.out.println(sb);
    }
}
