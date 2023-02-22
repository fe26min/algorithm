package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No7579 {
	static int N, M;
	static int[] m, c;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		int ans = 100001;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=10000; j++) {
				if(j>=c[i]) {
					dp[i][j] = Math.max(dp[i-1][j-c[i]] + m[i], dp[i-1][j]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
				if(dp[i][j] >= M) ans = Math.min(ans, j);
			}
		}
		System.out.println(ans);
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		m = new int[N+1];
		c = new int[N+1];
		dp = new int[N+1][100001];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}
