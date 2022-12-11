package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15991 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] ans = new int[1000001];
		
		ans[0]=1;
		ans[1]=1;
		ans[2]=1;
		ans[3]=1;
		
		for(int i=2; i<=1000000; i++) {
			if(i>=2) {
				ans[i] += ans[i-2];
				ans[i] %= 1000000009;
			}
			if(i>=4) {
				ans[i] += ans[i-4];
				ans[i] %= 1000000009;
			}
			if(i>=6) {
				ans[i] += ans[i-6];
				ans[i] %= 1000000009;
			}
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
