package ThisWeek35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11066 {
	static BufferedReader br;
	static int N; 
	static int[] arr;
	static int[][] sum, dp;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		for(int ti=0; ti<T; ti++) {
			input();
			pro();
		}
		System.out.println(sb);
		br.close();
	}

	private static void pro() {
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				sum[i][j] = arr[j];
				if(j==0)
					continue;
				sum[i][j] += sum[i][j-1];
			}
		}
		
		for(int len = 1; len < N; len++) {
			for(int i=0; i+len < N; i++) {
				int j = i + len;
				dp[i][j] = Integer.MAX_VALUE;
				
				for(int k=i; k<j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sum[i][j]);
				}
			}
		}
		sb.append(dp[0][N-1]+"\n");
	}

	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		sum = new int[N][N];
		dp = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}
