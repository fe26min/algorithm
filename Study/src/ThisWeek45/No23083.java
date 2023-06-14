package ThisWeek45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No23083 {
	static int N, M;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		dp[1][1] = 1;
		System.out.println(find(N, M));
	}
	
	private static long find(int x, int y) {
		if(dp[x][y]!=-1)
			return dp[x][y];
		if(y%2==0)
			return dp[x][y] = (find(x-1, y) + find(x, y-1) + find(x+1, y-1)) % 1000000007;
		else
			return dp[x][y] = (find(x-1, y) + find(x-1, y-1) + find(x, y-1)) % 1000000007;
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new long[N+2][M+1];
		
		for(int i=0; i<N+2; i++) {
			Arrays.fill(dp[i], -1);
		}

		for(int i=1; i<=N; i++)
			dp[i][0] = 0;
		
		Arrays.fill(dp[0], 0);
		Arrays.fill(dp[N+1], 0);
		
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 구멍
			dp[x][y] = 0;
		}
		
		br.close();		
	}
}
