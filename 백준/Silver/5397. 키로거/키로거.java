import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 LinkedList<Character> left = new LinkedList<>();
		 LinkedList<Character> right = new LinkedList<>();
		 
		 StringBuilder sb = new StringBuilder();
		 for(int i=0; i<N; i++) {
			 String s = br.readLine();
			 for (char c : s.toCharArray()) {
				 switch (c) {
				 case '<':
					 if (!left.isEmpty()) {
						 right.addFirst(left.removeLast());
					 }
					 break;
				 case '>':
					 if (!right.isEmpty()) {
						 left.addLast(right.removeFirst());
					 }
					 break;
				 case '-':
					 if (!left.isEmpty()) {
						 left.removeLast();
					 }
					 break;
				 default:
					 left.addLast(c);
					 break;
				 }
			 }
		        while (!left.isEmpty()) {
		            sb.append(left.removeFirst());
		        }
		        while (!right.isEmpty()) {
		            sb.append(right.removeFirst());
		        }
		        sb.append("\n");
		 }
		 System.out.println(sb);
	}
}
