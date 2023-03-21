package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2206 {
	static int N, M;
	static int[][] mat;
	static boolean[][][] visit;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {0, 0, 0, 1});
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			
			if(cur[0]==N-1 && cur[1] == M-1) {
				System.out.println(cur[3]);
				return;
			}
			
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=M)
					continue;
				if(visit[nx][ny][cur[2]])
					continue;
				if(mat[nx][ny] == 1) {
					if(cur[2]==1)
						continue;
					visit[nx][ny][1] = true;
					queue.add(new int[] {nx, ny, 1, cur[3] + 1});
					continue;
				}
				visit[nx][ny][cur[2]] = true;
				queue.add(new int[] {nx, ny, cur[2], cur[3] + 1});
			}
		}
		System.out.println(-1);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int [N][M];
		visit = new boolean[N][M][2];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				mat[i][j] = line.charAt(j) - '0';
			}
		}
		
		br.close();
	}
}
