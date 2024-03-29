package ThisWeek23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17404 {
	static int N;
	static int[][] mat, dp;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<9; j++) {
				dp[j][i] = 1_000 * 1_000 + 1;
			}
		}
		
		for(int i=0; i<3; i++) {
			dp[i*3 + i][0] = mat[i][0];
		}
		
		// dp[j][i] = Math.min(dp[j][i-1] , ... )
		for(int i=1; i<N; i++) {
			for(int j=0; j<9; j++) {
				// j == 0 이면 0/, 3, 6;
				// j == 1 이면 1/, 4, 7;
				// j == 2 이면 2/, 5, 8;
				// j == 3 이면 0, 3/, 6;
				// j == 4 이면 1, 4/, 7
				// j == 5 이면 2, 5/, 8;
				
				for(int k=0; k<3; k++) {
					int next = j % 3 + 3 * k;
					if(j==next) continue;
					dp[j][i] = Math.min(dp[j][i], dp[next][i-1] + mat[j/3][i]);
				}
			}
		}
		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<9; j++) {
//				System.out.print(dp[j][i] +" ");
//			}System.out.println();
//		}
		int min = 1_000 * 1_000 + 1;
		for(int i=0; i<9; i++) {
			if(i%3 == i/3) continue;
			min = Math.min(dp[i][N-1], min);
		}
		System.out.println(min);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		mat = new int[3][N];
		dp = new int[9][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++)
				mat[j][i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}