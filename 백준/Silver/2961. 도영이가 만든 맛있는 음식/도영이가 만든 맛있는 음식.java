import java.io.*;
import java.util.*;

public class Main{
	static int n;
	static int[][] a;
	static long min = 1000000000;
	
	static void subs(int cnt, int s, int b){
		if(cnt==n){
			if (s == 1) return;
			if(Math.abs(s-b)<min) min =Math. abs(s-b);
			return;
		}
		subs(cnt+1,s*a[cnt][0],b+a[cnt][1]);//선택
		subs(cnt+1,s,b);//비선택
		}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a= new int [n][2];
		for (int i = 0; i<n; i++) {
			for(int j = 0; j<2; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		subs(0,1,0);
		System.out.println(min);
		sc.close();
	}
}