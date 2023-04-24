package ThisWeek37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No2917 {
	static int N, M, vx, vy;
	static char[][] mat;
	static int[][] dist;
	
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[2]-o1[2];
			}
		});
		boolean[][] visit = new boolean[N][M];
		visit[vx][vy] = true;
		pq.add(new int[] {vx,vy, dist[vx][vy]});
				
				
		while(true) {
			int[] cur = pq.poll();
			if(mat[cur[0]][cur[1]] =='J') {
				System.out.println(cur[2]);
				return;
			}
			
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=M)
					continue;
				if(visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				pq.add(new int[] {nx, ny, Math.min(cur[2], dist[nx][ny])});
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new char[N][M];
		dist = new int[N][M];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], 1001);
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				mat[i][j] = line.charAt(j);
				if(mat[i][j] == 'V') {
					vx = i;
					vy = j;
				}
				else if(mat[i][j]=='+') {
					dist[i][j] = 0;
					pq.add(new int[] {i,j,0});
				}
			}
		}
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(dist[cur[0]][cur[1]] < cur[2])
				continue;
			
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=M)
					continue;
				if(dist[nx][ny] < cur[2] + 1)
					continue;
				dist[nx][ny] = cur[2]+1;
				pq.add(new int[] {nx, ny, cur[2] + 1});
			}
		}
		
		
		br.close();		
	}
}
