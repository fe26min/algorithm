package backjoon.fastcampus.ch06.GS_pra2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No18404 {
	static int N, M, sx, sy, ex, ey;
	static int[][] mat;
	static StringBuilder sb;
	
	static int[] dirx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] diry = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {sx, sy, 0});
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			
			for(int di=0; di<8; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				int nc = cur[2] + 1;
				
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(mat[nx][ny]!=0)continue;
				mat[nx][ny] = nc;
				queue.add(new int[] {nx, ny, nc});
			}
		}
		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(mat[i][j] + " ");
//			}System.out.println();
//		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken()) - 1;
			ey = Integer.parseInt(st.nextToken()) - 1;
			
			sb.append(mat[ex][ey] + " ");
		}
		System.out.println(sb);
		br.close();
	}
}
