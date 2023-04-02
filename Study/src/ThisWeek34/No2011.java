package ThisWeek34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2011 {
	static int len;
	static int[][] dp;
	static String password;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		dp = new int[len][2];
		
		dp[0][0] = 1;
		
		for(int i=1; i<len; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 1000000;
			
			int num = (password.charAt(i-1) - '0') * 10 + (password.charAt(i) - '0');
			if(num <=26) {
				dp[i][1] = dp[i-1][0];
			}
		}
		System.out.println((dp[len-1][0] + dp[len-1][1]) % 1000000);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		password = br.readLine();
		len = password.length();
		br.close();
	}
}
