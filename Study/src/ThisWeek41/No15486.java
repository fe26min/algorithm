package ThisWeek41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15486 {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int max = 0;
		int[] dp = new int[N+2];
		
		for(int i=1; i<=N+1; i++) {
			if(max < dp[i])
				max = dp[i];
			
			if(arr[i][0] <= N + 1) {
				dp[arr[i][0]] = Math.max(dp[arr[i][0]], max + arr[i][1]);
			}
		}
		System.out.println(max);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+2][2];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(st.nextToken()) + i;
			int P = Integer.parseInt(st.nextToken());
			
			arr[i][0] = T;
			arr[i][1] = P;
		}
		br.close();		
	}
}