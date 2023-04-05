package ThisWeek34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2011 {
	static int len;
	static int[] dp;
	static String password;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		if(password.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		
		dp = new int[len + 1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		int prev = password.charAt(0) - '0';
		for(int i=2; i<= len; i++) {
			int num = password.charAt(i-1) - '0';
			if(num != 0) {
				dp[i] = dp[i-1];
			}
			if(prev != 0 && prev * 10 + num <= 26) {
				dp[i] += dp[i-2];
			}
			dp[i] %= 1000000;
			prev = num;
		}
		
		System.out.println(dp[len]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		password = br.readLine();
		br.close();
		len = password.length();
	}
}
