import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minusSplit = br.readLine().split("-"); // "-" 기준으로 문자열 분리
        int result = sum(minusSplit[0]); // 첫 번째 그룹은 더해줌

        for (int i = 1; i < minusSplit.length; i++) {
            result -= sum(minusSplit[i]); // 이후 그룹은 모두 빼줌
        }

        System.out.println(result);
    }

    private static int sum(String expression) {
        String[] plusSplit = expression.split("\\+"); // "+" 기준으로 분리
        int sum = 0;
        for (String num : plusSplit) {
            sum += Integer.parseInt(num); // 정수로 변환하여 더하기
        }
        return sum;
    }
}
