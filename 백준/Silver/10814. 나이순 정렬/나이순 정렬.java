import java.util.*;
import java.io.*;

class Member {
    int age;
    String name;
    int index;

    public Member(int age, String name, int index) {
        this.age = age;
        this.name = name;
        this.index = index;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Member> members = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(age, name, i));
        }

        Collections.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                if (m1.age == m2.age) {
                    return Integer.compare(m1.index, m2.index);
                } else {
                    return Integer.compare(m1.age, m2.age);
                }
            }
        });

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }

        br.close();
    }
}
