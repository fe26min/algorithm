package ThisWeek31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9592 {
	static String a, b;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int alen = a.length();
		int blen = b.length();
		
		dp = new int[alen+1][blen+1];
		
		for(int i=1; i<=alen; i++) {
			for(int j=1; j<=blen; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
				}
			}
		}
		
		String answer = "";
		int i= alen;
		int j = blen;
		
		while(i != 0 && j != 0) {
			if(dp[i][j] == dp[i-1][j]) {
				i--;
			}
			else if(dp[i][j] == dp[i][j-1]) {
				j--;
			}
			else {
				answer = a.charAt(i-1) + answer;
				i--;
				j--;
			}
		}
		System.out.println(dp[alen][blen]);
		System.out.println(answer);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b = br.readLine();
		br.close();
	}
}
