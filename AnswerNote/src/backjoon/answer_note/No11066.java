package backjoon.answer_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11066 {
	
	static int K;
	static int[] arr;
	static int[][] dp, sum;
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ti=0; ti<T; ti++) {
			input();
			pro();
		}
		br.close();
	}

	private static void input() throws IOException {
		K = Integer.parseInt(br.readLine());
		arr = new int[K];
		sum = new int[K][K];
		dp = new int[K][K];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void pro() {
		for(int i=0; i<K; i++) {
			for(int j=i; j<K; j++) {
				sum[i][j] = arr[j];
				if(j-1>=0)
					sum[i][j] += sum[i][j-1];
			}
		}
		
		for(int len = 1; len<K; len++) {
			for(int i=0; i+len < K; i++) {
				int j = i + len;
				dp[i][j] = Integer.MAX_VALUE;
				
				for(int k=i; k<j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sum[i][j]);
				}
			}
		}
		System.out.println(dp[0][K-1]);
	}
}
