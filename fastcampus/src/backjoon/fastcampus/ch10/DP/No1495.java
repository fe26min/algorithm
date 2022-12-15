package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No1495 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] Dy = new boolean[N+1][M+1];
		int[] V = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) 
			V[i] = Integer.parseInt(st.nextToken());
		br.close();
		
		Dy[0][S] = true;
		
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			boolean flag = false;
			ans = 0;
			for(int prev = 0; prev <= M; prev++) {
				if(!Dy[i-1][prev]) continue;
				for(int cur : new int[] {prev - V[i], prev + V[i]}) {
					if(cur< 0 || cur > M) continue;
					ans = Math.max(ans, cur);
					Dy[i][cur] = true;
					flag = true;
				}
			}
			if(!flag) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(ans);
	}
}
