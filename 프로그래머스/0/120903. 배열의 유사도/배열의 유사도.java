import java.util.HashSet;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();

        // s1의 모든 원소를 HashSet에 추가
        for (String str : s1) {
            set.add(str);
        }

        // s2의 원소가 set에 있으면 공통 원소이므로 카운트 증가
        for (String str : s2) {
            if (set.contains(str)) {
                answer++;
            }
        }

        return answer;
    }
}
