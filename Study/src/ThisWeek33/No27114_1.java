package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// dp로 문제 풀어보기
public class No27114_1 {
	static int K;
	static int[] cost = new int[3];
	static int[] dir = {3, 1, 2};
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		dp = new int[K+1][4];
		
		for(int i=0; i<=K; i++) {
			Arrays.fill(dp[i], 1_000_001);
		}
		
		dp[0][0] = 0;
		for(int i=0; i<=K; i++) {
			for(int j=0; j<4; j++) {
				if(dp[i][j] == 1000001)
					continue;
				for(int c=0; c<3; c++) {
					if(i+cost[c] > K)
						continue;
					dp[i + cost[c]][(j + dir[c]) % 4] = Math.min(dp[i + cost[c]][(j + dir[c]) % 4], dp[i][j] + 1); 
				}
			}
		}
		
		if(dp[K][0] == 1000001)
			dp[K][0] = -1;
		System.out.println(dp[K][0]);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cost[0] = Integer.parseInt(st.nextToken());
		cost[1] = Integer.parseInt(st.nextToken());
		cost[2] = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		br.close();
	}
}
