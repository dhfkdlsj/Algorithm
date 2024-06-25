import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String S,A;
	static ArrayList<String> list;
	static String[] s;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		list.add(st.nextToken());
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			A = st.nextToken();
			int cnt = 0;
			for(int j = 0; j<list.size(); j++) {
				if(list.get(j).equals(A)) {
					break;
				}else {
					cnt++;
				}
			}
			if(cnt == list.size()) list.add(A);
		}
		
		Collections.sort(list);
		s = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			s[i]= list.get(i);
		}
		
		 for (int i = 1; i < s.length; i++) {
	            String current = s[i];
	            int j = i - 1;
	            while (j >= 0 && s[j].length() > current.length()) {
	                s[j + 1] = s[j];
	                j--;
	            }
	            while (j >= 0 && s[j].length() == current.length() && s[j].compareTo(current) > 0) {
	                s[j + 1] = s[j];
	                j--;
	            }
	            s[j + 1] = current;
	        }

	        for (String word : s) {
	            System.out.println(word);
	        }	
	
		
	}

}
