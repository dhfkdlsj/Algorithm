import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 900528;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String stringSet = br.readLine();  // 사용할 수 있는 문자들
        String code = br.readLine();       // 암호화된 문자열

        // Map에 문자와 인덱스 저장, 배열보다 간편한 느낌
        Map<Character, Integer> map = new HashMap<>();
        int size = stringSet.length();
        int result = 0;

        // 문자에 대한 인덱스 저장 - 1부터 시작
        for (int i = 0; i < size; i++) {
            map.put(stringSet.charAt(i), i + 1);
        }

        // 암호를 숫자로 변환하여 계산
        for (int i = 0; i < code.length(); i++) {
            // 진법 변환 계산
            result = (result * size + map.get(code.charAt(i))) % MOD;
        }

        System.out.println(result);
    }
}
