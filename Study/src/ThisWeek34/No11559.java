package ThisWeek34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No11559 {
	// BFS로 찾는 문제
	static int count;
	static ArrayList<int[]> list;
	static char[][] mat;
	static boolean[][] visit;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int cnt = 0;
		// 세주기
		while(check()) {
			cnt++;
			move();
		}
		System.out.println(cnt);
	}

	private static void move() {
		for(int i=0; i<6; i++) {
			int idx = 11;
			for(int j=11; j>=0; j--) {
				if(mat[j][i] != '.') {
					char imsi = mat[j][i];
					mat[j][i] = '.';
					mat[idx--][i] = imsi;
				}
			}
		}
	}

	private static boolean check() {
		Queue<int[]> queue = new LinkedList<>();
		visit = new boolean[12][6];
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				if(mat[i][j]=='.')
					continue;
				if(visit[i][j])
					continue;
				visit[i][j] = true;
				list = new ArrayList<>();
				list.add(new int[] {i, j});
				count=1;
				dfs(i, j);
				if(count>=4) {
					for(int[] node : list)
						queue.add(node);
				}
			}
		}
		if(queue.isEmpty()) {
			return false;
		}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			mat[cur[0]][cur[1]] = '.';
		}
		
		return true;
	}

	private static void dfs(int x, int y) {
		for(int di=0; di<4; di++) {
			int nx = x + dirx[di];
			int ny = y + diry[di];
			
			if(nx<0||ny<0||nx>=12||ny>=6)
				continue;
			if(visit[nx][ny])
				continue;
			if(mat[x][y] != mat[nx][ny])
				continue;
			visit[nx][ny] = true;
			count++;
			list.add(new int[] {nx, ny});
			dfs(nx, ny);
		}
	}

	private static void input() throws IOException {
		mat = new char[12][6];
		visit = new boolean[12][6];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<12; i++) {
			mat[i] = br.readLine().toCharArray();
		}
		br.close();
	}
}
