package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2293 {
	static int n, k;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		System.out.println(dp[k]);
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dp = new int[100_001];
		for(int i=0; i<n; i++) {
			int coin = Integer.parseInt(br.readLine());
			
			if(coin <= k) {
				dp[coin] = dp[coin] + 1;
			}
			
			for(int j=coin; j<=k; j++) {
				dp[j] = dp[j-coin] + dp[j];
			}
		}
		br.close();
	}
}
