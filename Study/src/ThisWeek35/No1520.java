package ThisWeek35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1520 {
	static int M, N;
	static int[][] mat, dp;
	
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		System.out.println(dfs(0, 0));
	}
	private static int dfs(int x, int y) {
		if(x==M-1 && y == N-1) {
			return 1;
		}
		
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		for(int di=0; di<4; di++) {
			int nx = x + dirx[di];
			int ny = y + diry[di];
			if(nx < 0 || ny < 0 || nx>=M || ny>=N )
				continue;
			
			if(mat[x][y] > mat[nx][ny]) {
				dp[x][y] += dfs(nx, ny);
			}
		}
		return dp[x][y];
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		mat = new int[M][N];
		dp = new int[M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
	}
}