import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int number = 666;

        while(true) {
            if (String.valueOf(number).contains("666")){
                cnt++;
            }
            if (cnt == N){
                break;
            }
            number++;
        }

        System.out.println(number);
    }
}

