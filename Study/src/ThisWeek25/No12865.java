package ThisWeek25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No12865 {
	
	static int N, K;
	static int[] w, v;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - w[i] < 0)
					continue;
				dp[i][j] = dp[i][j] > dp[i-1][j-w[i]] + v[i] 
						? dp[i][j] : dp[i-1][j-w[i]]+v[i];
			}
		}
		System.out.println(dp[N][K]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		w = new int[N+1];
		v = new int[N+1];
		dp = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}