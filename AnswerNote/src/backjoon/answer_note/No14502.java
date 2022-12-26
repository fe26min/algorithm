package backjoon.answer_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14502 {

	static int N, M, ans;
	static int[][] mat;
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		// 입력 받기
		input();
		pro();
	}
	
	private static void pro() {
		ans = 0;
		// dfs로 벽 세우기
		dfs(0,0,0);
		System.out.println(ans);
	}

	// 벽 세우기
	private static void dfs(int i, int j, int depth) {
		if(i>=N)
			return;
		// 벽이 3개 세워지면 체크한다.
		if(depth == 3) {
			check();
			return;
		}
		
		// 다음 행으로 넘어가기
		if(j==M) {
			dfs(i+1, 0, depth);
			return;
		}
		
		// 벽을 세울 수 있는 곳이면 벽을 세운다
		if(mat[i][j]==0) {
			mat[i][j]=1;
			dfs(i, j+1, depth+1);
			mat[i][j]=0;
		}
		
		// 벽을 세우지 않고 다음으로 넘어간다.
		dfs(i, j+1, depth);
	}

	// 이제 바이러스 퍼트리기 bfs로 풀기
	private static void check() {
		// 이렇게 벽이 세워진 경우에는 어떻게 퍼지는지를 세주기 위한 배열
		int[][] temp = new int[N][M];
		
		for(int i=0; i<N; i++)
			temp[i] = mat[i].clone();
		
		// 바이러스들을 큐에 넣기
		Queue<int[]> queue = new LinkedList<int[]>();
		
		// 왔던 곳인지 본다.
		boolean[][] visit = new boolean[N][M];
		
		// 바이러스를 큐에 넣기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(temp[i][j] == 2) {
					queue.add(new int[] {i, j});
					visit[i][j] = true;
				}
			}
		}
		
		// 큐에 바이러스들을 넣기
		while(!queue.isEmpty()) {
			// 앞에거 꺼내기
			int[] cur = queue.poll();
			
			// 4방 탐색
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				// 범위를 넘어가면 넘김
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				// 이미 왔던 곳이면 넘어간다.
				if(visit[nx][ny]) continue;
				// 전염이 되지 않는 곳이면 넘어간다.
				if(temp[nx][ny] != 0) continue;
				visit[nx][ny] = true;
				// 감염!
				temp[nx][ny] = 2;
				// 감염된 애를 큐에 넣어주기
				queue.add(new int[] {nx, ny});
			}
		}
		
		// 안전공간을 세주기
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(temp[i][j]==0)
					count++;
			}
		}
		// 가장 큰 안전공간을 저장해야 한다.
		ans = Math.max(ans, count);
	}

	// 입력
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
}
