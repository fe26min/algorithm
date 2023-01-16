package ThisWeek23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17404_1 {
	static int N;
	static int [][] cost, dp;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	// dp 문제
	private static void pro() {
		
		for(int i=0; i<9; i++) {
			dp[i][0] = cost[i/3][0];
		}
		
		for(int i=0; i<9; i++) {
			for(int j=1; j<N; j++) {
				dp[i][j] = 1_000 * 1_000 + 1;
			}
		}
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				dp[j][i] = Math.min(dp[j][i], dp[j%3 + 3][i-1] + cost[j/3][i]);
				dp[j][i] = Math.min(dp[j][i], dp[j%3 + 6][i-1] + cost[j/3][i]);
			}
			for(int j=3; j<6; j++) {
				dp[j][i] = Math.min(dp[j][i], dp[j%3][i-1] + cost[j/3][i]);
				dp[j][i] = Math.min(dp[j][i], dp[j%3 + 6][i-1] + cost[j/3][i]);
			}
			for(int j=6; j<9; j++) {
				dp[j][i] = Math.min(dp[j][i], dp[j%3][i-1] + cost[j/3][i]);
				dp[j][i] = Math.min(dp[j][i], dp[j%3 + 3][i-1] + cost[j/3][i]);
			}
		}
		
		int answer = Integer.MAX_VALUE;
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(dp[i][j] + " ");
			}System.out.println();
		}
		
		for(int i=0; i<9; i++) {
			if(i/3==i%3) continue;
			answer = Math.min(answer, dp[i][N-1]);
		}
		System.out.println(answer);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cost = new int[3][N];
		dp = new int[9][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				cost[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
}
