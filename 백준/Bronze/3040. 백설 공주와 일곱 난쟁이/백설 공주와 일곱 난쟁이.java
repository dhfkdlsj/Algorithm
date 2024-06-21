import java.io.*;
import java.util.*;

public class Main{
	
	static void comb(int cnt,int start,int N, int R, int[] a, int[] b){
		int sum = 0;
		if(cnt==R){
			for (int i = 0; i < b.length; i++) {
				sum += b[i];
			}
			if (sum == 100)
				for(int j = 0; j < b.length; j++) {
					System.out.println(b[j]);
				}
			return;
		}
		for(int i=start; i<N; i++){
			//if(v[i]) continue;//
			//v[i]=true;//
			b[cnt]=a[i];
			comb(cnt+1,i+1,N,R,a,b); //4C3
			//comb(cnt+1,i); -> 20개 4H3 중복 포함
			//v[i]=false;//
		}
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = 9;
		int R = 7;
		int[] a=new int[N], b=new int[R];
		for(int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		comb(0,0,N,R,a,b);
		sc.close();
	}
}