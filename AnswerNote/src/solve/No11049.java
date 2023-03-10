package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11049 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][2];
		int[][] dp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int len = 1; len < N; len++) {
			for(int i = 0; i + len < N; i++) {
				int j = i + len;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j; k++) {
					int cost = dp[i][k] + dp[k+1][j] + map[i][0] * map[k][1] * map[j][1];
					dp[i][j] = Math.min(dp[i][j], cost);
				}
			}
		}
		System.out.println(dp[0][N-1]);
		br.close();
	}
}
