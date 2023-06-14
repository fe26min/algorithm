package ThisWeek45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1245 {
	static int N, M, min, cnt;
	static int[][] mat;
	static boolean[][] visit;

	static int[] dirx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] diry = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				// 이미 방문한 곳인지 보기
				if(visit[i][j])
					continue;
				bfs(i, j);
			}
		}
		System.out.println(cnt);
	}

	
	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean isPeak = true;
		queue.add(new int[] {i, j});
		visit[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int di=0; di<8; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=M)
					continue;
				if(mat[nx][ny] > mat[i][j])
					isPeak = false;
				else if(!visit[nx][ny] && mat[nx][ny] == mat[i][j]) {
					visit[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		if(isPeak && mat[i][j] > min) {
//			System.out.println(i + " " + j);
			cnt++;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mat = new int[N][M];
		visit = new boolean[N][M];
		
		min = 500;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, mat[i][j]);
			}
		}
		br.close();
	}
}
