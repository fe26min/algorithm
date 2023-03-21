package ThisWeek32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No14945 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][N+1];
		
		dp[2][1] = 2;
		
		for(int i=3; i<=N; i++) {
			for(int j=1; j<i; j++) {
				dp[i][j] = 2 * dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j+1];
				dp[i][j] %= 10_007;
			}
		}
		int sum = 0;
		for(int i : dp[N]) {
			sum += i;
			sum %= 10_007;
		}
		
		System.out.println(sum);
		br.close();
	}
}
