package ThisWeek40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17836 {
	static int N, M, T, time;
	static int[][] mat;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		find();
		if(time <=T)
			System.out.println(time);
		else
			System.out.println("Fail");
	}
	private static void find() {
		boolean visit[][] = new boolean[N][M];
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		time = T + 1;
		visit[0][0] = true;
		queue.add(new int[] {0, 0, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			System.out.println(cur[0] + " " + cur[1] + " " + cur[2]);
			if(mat[cur[0]][cur[1]] == 2) {
				time = Math.min(time, cur[2] + Math.abs(N-1-cur[0]) + Math.abs(M-1-cur[1]));
				continue;
			}
			if(cur[0] == N-1 && cur[1] == M-1) {
				time = Math.min(time, cur[2]);
				break;
			}
			
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=M)
					continue;
				if(mat[nx][ny] == 1)
					continue;
				if(visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				queue.add(new int[] {nx, ny, cur[2] + 1});
			}
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
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
