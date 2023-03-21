package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2146 {
	static int N, idx;
	static int[][] mat;
	static Queue<int[]> bridge;
	static int[] dirx = { -1, 0, 1, 0 };
	static int[] diry = { 0, -1, 0, 1 };
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}	
	private static void pro() {
		boolean[][][] visit = new boolean[N][N][idx-1];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(mat[i][j] + " ");
			}System.out.println();
		}
		
		
		while(!bridge.isEmpty()) {
			int[] cur = bridge.poll();
//			System.out.println(cur[0] + " " + cur[1] + " " +cur[2] + " " + cur[3] );
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=N)
					continue;
				if(mat[nx][ny]==0) {
					if(visit[nx][ny][cur[2]])
						continue;
					visit[nx][ny][cur[2]] = true;
					bridge.add(new int[] {nx, ny, cur[2], cur[3] + 1});
				}
				else {
					if(mat[nx][ny] - 2 != cur[2]) {
						System.out.println(cur[3]);
						return;
					}
				}
			}
		}
		
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		Queue<int[]> queue = new LinkedList<int[]>();

		mat = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if (mat[i][j] == 1)
					queue.add(new int[] { i, j });
			}
		}
		br.close();

		idx = 1;
		bridge = new LinkedList<>();
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(mat[cur[0]][cur[1]] == 1) {
				idx++;
				mat[cur[0]][cur[1]] = idx;
				dfs(cur[0], cur[1]);
			}
			
		}
	}
	private static void dfs(int x, int y) {
		boolean isBeach = false;
		for(int di=0; di<4; di++) {
			int nx = x + dirx[di];
			int ny = y + diry[di];
			
			if(nx<0||ny<0||nx>=N||ny>=N)
				continue;
			if(mat[nx][ny]==1) {
				mat[nx][ny] = idx;
				dfs(nx, ny);
				continue;
			}
			if(mat[nx][ny]==0) {
				isBeach = true;
			}
		}
		if(isBeach)
			bridge.add(new int[] {x, y, idx - 2, 0});
	}
}

