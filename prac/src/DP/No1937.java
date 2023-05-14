package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1937 {
	static int N, max;
	static int[][] mat, dp;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				max = Math.max(max, dfs(i, j));
			}
		}
		System.out.println(max);
	}
	private static int dfs(int x, int y) {
		if(dp[x][y] != 0)
			return dp[x][y];
		dp[x][y] = 1;
		
		for(int di=0; di<4; di++) {
			int nx = x + dirx[di];
			int ny = y + diry[di];
			
			if(nx<0 || ny<0 || nx>=N || ny>=N)
				continue;
			if(mat[x][y] < mat[nx][ny]) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
				dfs(nx, ny);
			}
		}
		return dp[x][y];
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();		
	}
}
