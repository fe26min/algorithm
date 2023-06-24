package ThisWeek46;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17484 {
	static int N, M;
	static int[][] mat;
	static int[][][] dp;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isValid(i - 1, j + 1))
					dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + mat[i][j];

				if (isValid(i - 1, j))
					dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + mat[i][j];

				if (isValid(i - 1, j - 1))
					dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + mat[i][j];
			}
		}
		int minCost = Integer.MAX_VALUE;
		for (int j = 0; j < M; j++) {
			for (int k = 0; k < 3; k++) {
				if (minCost > dp[N-1][j][k])
					minCost = dp[N-1][j][k];
			}
		}
		System.out.println(minCost);
	}
	private static boolean isValid(int y, int x) {
		return (0 <= y && y < N) && (0 <= x && x < M);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		dp = new int[N][M][3];
		
		st = new StringTokenizer(br.readLine());
		
		for(int j=0; j<M; j++) {
			mat[0][j] = Integer.parseInt(st.nextToken());
			dp[0][j][0] = mat[0][j];
			dp[0][j][1] = mat[0][j];
			dp[0][j][2] = mat[0][j];
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
			dp[i][0][2] = Integer.MAX_VALUE;
			dp[i][M-1][0] = Integer.MAX_VALUE; 
		}
		br.close();		
	}
}
