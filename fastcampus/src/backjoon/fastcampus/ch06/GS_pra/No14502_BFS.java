package backjoon.fastcampus.ch06.GS_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 4방 탐색 + 벽 세우기
// 일단 백트래킹으로 벽을 세우고 그 세워진 경우 마다 바이러스 갯수를 세주기
// 벽 세우기
// 벽이 3개 세워지면 바이러스가 퍼짐
// 끝이 나면 숫자를 세준다.
// 최대 크기를 찾는다.

public class No14502_BFS {
	static int N, M, max=0;
	static int[][] mat, copied;
	static boolean[][] visit, isChecked;
	static LinkedList<int[]> virus;
	static Queue<int[]> queue;
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		visit = new boolean[N][M];
		virus = new LinkedList<int[]>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j] == 2)
					virus.add(new int[] {i, j});
			}
		}
		
		setWall(0);
		System.out.println(max);
		br.close();
	}
	
	private static void setWall(int depth) {
		if(depth == 3) {
			check();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(mat[i][j]!=0) continue;
				if(visit[i][j]) continue;
				visit[i][j] = true;
				mat[i][j]=1;
				
				setWall(depth + 1);
				
				mat[i][j]=0;
				visit[i][j] = false;
			}
		}
		
	}
	private static void check() {
		copied = new int[N][M];
		isChecked = new boolean[N][M];
		
		for(int i=0; i<N; i++)
			copied[i] = mat[i].clone();
		isChecked = new boolean[N][M];
		
		queue = new LinkedList<int[]>();
		queue.addAll(virus);
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(isChecked[cur[0]][cur[1]]) continue;
			isChecked[cur[0]][cur[1]] = true;
			
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				if(nx<0 || ny<0 || nx>=N|| ny>=M) continue;
				if(isChecked[nx][ny] || copied[nx][ny]==1) continue;
				copied[nx][ny] = 2;
				queue.add(new int[] {nx, ny});
			}
		}
		
		
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copied[i][j]==0)
					count++;
			}
		}

		max = Math.max(max, count);
		if(count==0) return;
	}

	private static void dfs(int i, int j) {
		if(isChecked[i][j]) return;
		isChecked[i][j] = true;
		
		for(int di=0; di<4; di++) {
			int nx = i+dirx[di];
			int ny = j+diry[di];
			if(nx<0 || ny <0 || nx>= N || ny >=M) continue;
			if(isChecked[nx][ny] || copied[nx][ny]==1) continue;
			copied[nx][ny] = 2;
			dfs(nx, ny);
		}
	}
}
