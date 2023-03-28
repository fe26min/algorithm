package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10653 {
	static int N, K;
	static int[][] mat;
	static int[][] dp, dist;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		dp[0][0] = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				dist[i][j] = dist(i, j);
				dist[j][i] = dist(i, j);
			}
		}
		
		System.out.println(dfs(N-1, K));
	}

	private static int dfs(int idx, int k) {
		if(idx == 0) return 0;
		if(dp[idx][k] != -1) return dp[idx][k];
		
		int d = Integer.MAX_VALUE;
		
		for(int i=0; i<=k; i++) {
			if(idx-i-1 < 0) break;
			d = Math.min(dfs(idx-i-1, k-i) + dist[idx-i-1][idx], d);
		}
		return dp[idx][k] = d;
	}

	private static int dist(int i, int j) {
		return Math.abs(mat[i][0] - mat[j][0]) + Math.abs(mat[i][1] - mat[j][1]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		mat = new int[N][2];
		dist = new int[N][N];
		
		dp = new int[N][K + 1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<=K; j++) {
				dp[i][j] = -1;
			}
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			mat[i][0] = Integer.parseInt(st.nextToken());
			mat[i][1] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}
