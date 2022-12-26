package backjoon.answer_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1495 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int ti=0; ti<T; ti++) {
			int K = Integer.parseInt(br.readLine());
			int[] arr = new int[K+1];
			int[][] sum = new int[K+1][K+1];
			int[][] dp = new int[K+1][K+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=K; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			for(int i=1; i<=K; i++) {
				for(int j=i; j<=K; j++) {
					sum[i][j] = sum[i][j-1] + arr[j];
				}
			}
			
			for(int len = 2; len <= K; len++) {
				for(int i=1; i<= K - len + 1; i++) {
					int j = i + len - 1;
					dp[i][j] = Integer.MAX_VALUE;
					for(int k=i; k < j; k++) {
						dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sum[i][j]);
					}
				}
			}
			System.out.println(dp[1][K]);
		}
		br.close();
	}
}
