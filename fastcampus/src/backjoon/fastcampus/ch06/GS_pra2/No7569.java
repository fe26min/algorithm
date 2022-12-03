package backjoon.fastcampus.ch06.GS_pra2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7569 {
	
	static int M, N, H;
	static int[][][] mat;
	
	static int[] dirx = {-1, 0, 0, 1, 0, 0};
	static int[] diry = {0, -1, 0, 0, 1, 0};
	static int[] dirz = {0, 0, -1, 0, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		mat = new int[H][N][M];
		
		Queue<int[]> tomato = new LinkedList<>();
		int num0 = 0;
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					mat[i][j][k] = Integer.parseInt(st.nextToken());
					if(mat[i][j][k]==1)
						tomato.add(new int[] {i, j, k, 1});
					else if(mat[i][j][k]==0)
						num0++;
				}
			}
		}
		
		int max = 0;
		int count = 0;
		while(!tomato.isEmpty()) {
			int cur[] = tomato.poll();
			max = Math.max(cur[3], max);
			
			for(int di=0; di<6; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				int nz = cur[2] + dirz[di];
				int nc = cur[3] + 1;
				
				if(nx<0||ny<0||nz<0||nx>=H||ny>=N||nz>=M) continue;
				if(mat[nx][ny][nz]!=0) continue;
				mat[nx][ny][nz] = nc;
				count++;
				tomato.add(new int[] {nx, ny, nz, nc});
			}
		}
		
		if(count!=num0) max = 0;
		System.out.println(max - 1);
		
		br.close();
	}
}
