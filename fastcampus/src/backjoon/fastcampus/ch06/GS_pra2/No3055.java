package backjoon.fastcampus.ch06.GS_pra2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3055 {
	static int R, C;
	static int[] S, D;
	static char[][] mat;
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		S = new int[2];
		D = new int[2];
		mat = new char[R][C];
		
		Queue<int[]> water = new LinkedList<int[]>();
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				mat[i][j] = line.charAt(j);
				if(mat[i][j]=='S') {
					S[0] = i;
					S[1] = j;
					mat[i][j] = '0';
					queue.add(new int[] {i, j, 0});
				}
				else if(mat[i][j]=='D') {
					D[0] = i;
					D[1] = j;
				}
				else if(mat[i][j]=='*') {
					water.add(new int[] {i, j});
				}
			}
		}
		
		while(true) {
			Queue<int[]> nextQueue = new LinkedList<>();
			Queue<int[]> nextWater = new LinkedList<>();
			
			while(!water.isEmpty()) {
				int[] curW = water.poll();
				
				for(int di=0; di<4; di++) {
					int nx = curW[0] + dirx[di];
					int ny = curW[1] + diry[di];
					
					if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
					if(mat[nx][ny]=='X'|| mat[nx][ny]=='*'||mat[nx][ny]=='D') continue;
					mat[nx][ny] = '*';
					nextWater.add(new int[] {nx, ny});
				}
			}
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				if(cur[0]==D[0] && cur[1]==D[1]) {
					System.out.println(cur[2]);
					return;
				}
				for(int di=0; di<4; di++) {
					int nx = cur[0] + dirx[di];
					int ny = cur[1] + diry[di];
					
					if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
					if(mat[nx][ny]=='.'||mat[nx][ny]=='D') {
						mat[nx][ny] = (char) ('0' + cur[2]+1);
						nextQueue.add(new int[] {nx, ny, cur[2]+1});
					}
				}
			}
			
			water = nextWater;
			queue = nextQueue;
			if(queue.isEmpty()) break;
//			if(water.isEmpty()) break;
			
		}
		System.out.println("KAKTUS");
		br.close();
	}
}
