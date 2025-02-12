import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String pwd = br.readLine();

        long ans = 0;
        int anum = 'a';
        N -= 1;

        // 문자열을 char 배열로 변환하여 처리
        for (char alpha : pwd.toCharArray()) {
            // 비밀번호와 a의 차이 구하기
            int diff = alpha - anum;
            if (diff > 0) {
                ans += (long) ((diff) * 26 * (Math.pow(26, N) - 1) / 25 + diff); // Math.pow(26,N)-1 알파벳 26개의 N제곱 -1 , 
            }
            ans += 1;
            N -= 1;
        }

        System.out.println(ans);
    }
}
