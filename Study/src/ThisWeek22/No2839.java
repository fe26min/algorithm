package ThisWeek22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2839 {
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		if(N >= 3)
			dp[3] = 1;
		if(N >= 5)
			dp[5] = 1;
		
		for(int i=6; i<=N; i++) {
			if(dp[i-3] != Integer.MAX_VALUE)
				dp[i] = Math.min(dp[i], dp[i-3] + 1);

			if(dp[i-5] != Integer.MAX_VALUE)
				dp[i] = Math.min(dp[i], dp[i-5] + 1);
		}
		if(dp[N] == Integer.MAX_VALUE)
			dp[N] = -1;
		System.out.println(dp[N]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		br.close();
	}
}
