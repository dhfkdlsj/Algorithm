import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];

        String s = br.readLine();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            arr[c-'a'] += 1;
        }
        for(int b:arr) sb.append(b).append(" ");
        System.out.println(sb);
    }
}
