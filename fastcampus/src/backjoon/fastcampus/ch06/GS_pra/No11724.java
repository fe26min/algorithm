package backjoon.fastcampus.ch06.GS_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11724 {
	static int N, M;
	static boolean[][] mat;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat= new boolean[N][N];
		visit = new boolean[N]; 

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			mat[x][y] = true;
			mat[y][x] = true;
		}
		
		int count = 0;
		for(int i=0; i<N; i++) {
			if(visit[i]) continue;
			count++;
			visit[i] = true;
			dfs(i);
		}
		System.out.println(count);
		
		br.close();
	}

	private static void dfs(int where) {
		for(int i=0; i<N; i++) {
			if(visit[i] || !mat[where][i]) continue;
			visit[i] = true;
			dfs(i);
		}
	}
}
