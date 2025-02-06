import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long num = 1;

        while (num <= N){
            N -= num;
            num++;
        }

        System.out.println(num - 1);
    }
}