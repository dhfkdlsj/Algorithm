import java.util.*;

public class Solution {
    static int userCount, banCount;
    static HashSet<Integer> set; // 중복 방지를 위해

    public int solution(String[] user_id, String[] banned_id) {
        userCount = user_id.length;
        banCount = banned_id.length;
        set = new HashSet<>();

        // '*' → '.'으로 변환하여 정규식 패턴 만들기
        //정규식에서는  . 은 임의의 한 문자이다.
        //"a".matches("."); -> true
        for (int i = 0; i < banCount; i++) {
            banned_id[i] = banned_id[i].replace('*', '.');
        }
        
        back(0, 0, banned_id, user_id); // 백트래킹 시작
        return set.size();
    }

    public static void back(int depth, int bitmask, String[] banned_id, String[] user_id) {
        if (depth == banCount) {
            set.add(bitmask);
            return;
        }

        for (int i = 0; i < userCount; i++) {
            if ((bitmask & (1 << i)) != 0) continue; // bitmask & (1 << i) 이미 있는지 확인
            if (!user_id[i].matches(banned_id[depth])) continue;
            
            back(depth + 1, bitmask | (1 << i), banned_id, user_id); // bitmask | (1 << i) 선택
        }
    }
}
