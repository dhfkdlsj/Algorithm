import java.io.*;
import java.util.*;

public class Main {
	static String T;
	static String P;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		P = br.readLine();
		int[] F=new int[P.length()];
		
		for(int t=1, p=0; t<P.length(); t++) {
			while(p>0 && P.charAt(t)!=P.charAt(p)) p=F[p-1];
			if(P.charAt(t)==P.charAt(p)) F[t]=++p;
		}
		
		List<Integer> ans = new ArrayList<>();
		
		for(int t=0, p=0; t<T.length(); t++) {
			while(p>0 && T.charAt(t)!=P.charAt(p)) p=F[p-1];
			if(T.charAt(t)==P.charAt(p)) {
				if(p==P.length()-1) {
					ans.add(t-p);
					p=F[p];
				}else {
					++p;
				}
			}
		}
		
		System.out.println(ans.size());
		for(int i=0; i<ans.size(); i++)
			System.out.print(ans.get(i)+1+" ");
		
	}
}
