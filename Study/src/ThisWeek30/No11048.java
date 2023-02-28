package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11048 {
	static int N, M;
	static int[][] mat;
	static int[][] dp;
	
	static int[] dirx = {-1, 0, -1};
	static int[] diry = {0, -1, -1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {	
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int di=0; di<3; di++) {
					int px = i + dirx[di];
					int py = j + diry[di];
					
					if(px<0 || py<0)
						continue;
					dp[i][j] = Math.max(dp[i][j], dp[px][py] + mat[i][j]);
				}
			}
		}
		System.out.println(dp[N-1][M-1]);
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		dp = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = mat[i][j];
			}
		}
		br.close();
	}
}
