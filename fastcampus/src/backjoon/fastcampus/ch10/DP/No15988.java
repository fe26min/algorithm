package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15988 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] ans = new int[1000001];
		
		ans[0]=0;
		ans[1]=1;
		ans[2]=2;
		ans[3]=4;
		for(int i=4; i<=1000000; i++)
			ans[i] = ((ans[i-1] + ans[i-2])% 1000000009 + ans[i-3]) % 1000000009;
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(ans[n] + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}
