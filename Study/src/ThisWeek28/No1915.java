package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1915 {
	static int N, M;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int[][] dp = new int[N][M];
		int max = 0;
		for(int i=0; i<N; i++) {
			dp[i][0] = arr[i][0];
			max = Math.max(dp[i][0], max);
		}
		
		for(int j=0; j<M; j++) {
			dp[0][j] = arr[0][j];
			max = Math.max(dp[0][j], max);
		}
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<M; j++) {
				if(arr[i][j] == 0) continue;
				dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
				max = Math.max(dp[i][j], max);
			}
		}
		
		System.out.println(max * max);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String line =br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = line.charAt(j) -'0';
			}
		}
		br.close();
	}
}