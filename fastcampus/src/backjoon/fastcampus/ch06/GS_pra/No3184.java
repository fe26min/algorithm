package backjoon.fastcampus.ch06.GS_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3184 {
	static int R, C, sheep, wolf, ts, tw;
	static char[][] mat;
	static boolean[][] visit;
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		mat = new char[R][C];
		visit = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			mat[i] = br.readLine().toCharArray();
		}
		
		ts = 0;
		tw = 0;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(visit[i][j] || mat[i][j]=='#') continue;
				sheep = 0;
				wolf = 0;
				visit[i][j] = true;
				dfs(i, j);
				
				if(wolf<sheep) wolf=0;
				else sheep = 0;
//				System.out.println(wolf + " " + sheep);
				ts+=sheep;
				tw+=wolf;
			}
		}
		System.out.println(ts + " " + tw);
		br.close();
	}

	private static void dfs(int x, int y) {
		if(mat[x][y]=='v') wolf++;
		else if(mat[x][y]=='o') sheep++;
		
		for(int di=0; di<4; di++) {
			int nx = x + dirx[di];
			int ny = y + diry[di];
			
			if(nx<0 || ny<0 || nx>=R || ny>=C)continue;
			if(visit[nx][ny] || mat[nx][ny]=='#') continue;
			visit[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}
