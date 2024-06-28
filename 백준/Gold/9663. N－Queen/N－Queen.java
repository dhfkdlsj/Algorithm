import java.io.*;
import java.util.*;

public class Main {
	static int N,ans,col[];  //index = i축, 안의 값, j축
	
	static boolean isAvailable(int rowNo) {
		for(int j = 0; j<rowNo; j++) {
			if(col[rowNo] == col[j] || 
					Math.abs(col[rowNo] - col[j]) == rowNo-j) return false;
		}
		return true;
	}
	
	static void nqueen(int rowNo) {
		if(!isAvailable(rowNo-1)){
			// 가지치기
			return;
		}
		if(rowNo==N) {
			ans++;
			return;
		}
		for(int i=0; i<N; i++) {
			col[rowNo]=i;
//			if(isAvailable(rowNo)) nqueen(rowNo+1);
			nqueen(rowNo+1);
		}
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];
		ans =0;
		nqueen(0);
		
		
		System.out.println(ans);
		
		sc.close();
	}

}
