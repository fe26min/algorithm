package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9095 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] ans = new int[11];
		
		ans[0]=0;
		ans[1]=1;
		ans[2]=2;
		ans[3]=4;
		
		for(int i=4; i<=10; i++) {
			ans[i] = ans[i-1] + ans[i-2] + ans[i-3];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(ans[n] + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}
