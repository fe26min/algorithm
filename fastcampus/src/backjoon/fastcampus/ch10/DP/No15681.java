package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No15681 {
	static int N, R, Q;
	static int[] dp;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		
		for(int i = 1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			list[X].add(Y);
			list[Y].add(X);
		}
		dp = new int[N+1];
				
		dfs(R, -1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<= Q; i++) {
			int q = Integer.parseInt(br.readLine());
			sb.append(dp[q]).append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}

	private static void dfs(int x, int prev) {
		dp[x] = 1;
		for(int y : list[x]) {
			if(y == prev) continue;
			dfs(y, x);
			dp[x] += dp[y];
		}
	}
}
