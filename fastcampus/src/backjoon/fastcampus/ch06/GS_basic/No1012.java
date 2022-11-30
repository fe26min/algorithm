package backjoon.fastcampus.ch06.GS_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1012 {
	
	static int N,M,K;
	static int[][] mat;
	static boolean[][] visit;
	static int dirx[] = {-1,0,1,0};
	static int diry[] = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int ti=0; ti<T; ti++) {
			ArrayList<int[]> list = new ArrayList<int[]>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			mat = new int[N][M];
			visit = new boolean[N][M];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[] {x,y});
				mat[x][y] = 1;
			}
			int count = 0;
			for(int[] i : list) {
				int x = i[0];
				int y = i[1];
				
				if(visit[x][y]) continue;
				count++;
				visit[x][y] = true;
				dfs(x, y);
			}
			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					if(visit[i][j] || mat[i][j]==0) continue;
//					
//					count++;
//					visit[i][j] = true;
//					dfs(i, j);
//				}
//			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
		
		br.close();
	}

	private static void dfs(int x, int y) {
		for(int di=0; di<4; di++) {
			int nx = x+ dirx[di];
			int ny = y+ diry[di];
			
			if(nx<0 || ny<0 || nx>=N||ny>=M) continue;
			if(visit[nx][ny] || mat[nx][ny] == 0) continue;
			
			visit[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}
