package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2156 {
	
	static int n;
	static int[] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int max = 0;
		for(int i=0; i<n;i++) {
			max = Math.max(max,dp[i][3]);
		}
		System.out.println(max);
	}	

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n][4];
		
		arr[0] = Integer.parseInt(br.readLine());
		dp[0][1] = arr[0];
		dp[0][3] = arr[0];
		
		for(int i=1; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			int max = dp[i-1][3];
			dp[i][0] = max;
			dp[i][1] = dp[i-1][0] + arr[i];
			max = Math.max(dp[i][1], max);
			dp[i][2] = dp[i-1][1] + arr[i];
			max = Math.max(dp[i][2], max);
			dp[i][3] = max;
		}
		br.close();
	}
}
