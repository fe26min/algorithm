package BOJ.samsung_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17070 {
	static int N;
	static int[][] mat;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		// dfs로 한다.
		// 맨처음에는 (1, 1) (1, 2)에 있다. 버전은 0이다.
		// 0은 가로, 1은 세로, 2는 대각선
		
		dp[1][2][0] = 1;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(mat[i][j] == 1) continue;
				if(mat[i][j-1] != 1) {
					dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
				}
				if(mat[i-1][j] != 1)
					dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
				if(mat[i-1][j-1] != 1 && mat[i][j-1] != 1 && mat[i-1][j] != 1) {
					dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				}
			}
		}
		
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		mat = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
}
