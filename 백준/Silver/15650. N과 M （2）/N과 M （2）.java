import java.io.*;
import java.util.*;

public class Main{
	
	static void comb(int cnt,int start,int N, int R, int[] a, int[] b){
		if(cnt==R){
			for (int i = 0; i < b.length; i++) {
				System.out.print(b[i]+" ");
			}
			System.out.println();
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
		int N = sc.nextInt();
		int R = sc.nextInt();
		int[] a=new int[N], b=new int[R];
		for(int i = 0; i < N; i++) {
			a[i] = i+1;
		}
		comb(0,0,N,R,a,b);
		sc.close();
	}
}