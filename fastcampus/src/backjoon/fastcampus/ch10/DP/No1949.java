package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1949 {
	
	static int[] arr;
	static int[][] dp;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N + 1];
		dp = new int[N + 1][2];
		list = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			list[X].add(Y);
			list[Y].add(X);
		}
		
		dfs(1, -1);
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
		
		br.close();
	}
	private static void dfs(int x, int prev) {
		dp[x][0] = 0;
		dp[x][1] = arr[x];
		
		for(int y : list[x]) {
			if(y == prev) continue;
			dfs(y, x);
			dp[x][0] += Math.max(dp[y][0], dp[y][1]);
			dp[x][1] += dp[y][0];
		}
	}
}
