package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No6087 {
	static int W, H;
	static int[][] point;
	static int[][] dist;
	static boolean[][] mat; 
	static boolean[][][] visit;
	
	static int[] dir = {0, 1, 3};
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		dist = new int[H][W];
		visit = new boolean[H][W][4];
		for(int i=0; i<H; i++) {
			Arrays.fill(dist[i], 10001);
		}
		int[] start = point[0];
		int[] end = point[1];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[2]));
		pq.add(new int[] {start[0], start[1], 0, 0});
		pq.add(new int[] {start[0], start[1], 0, 1});
		pq.add(new int[] {start[0], start[1], 0, 2});
		pq.add(new int[] {start[0], start[1], 0, 3});
		
		for(int di=0; di<4; di++) {
			visit[start[0]][start[1]][di] = true;
		}
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if(dist[cur[0]][cur[1]] < cur[2])
				continue;
			visit[cur[0]][cur[1]][cur[3]] = true;
			dist[cur[0]][cur[1]] = cur[2];
			
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0|| nx>=H||ny>=W)
					continue;
				if(mat[nx][ny])
					continue;
				if(visit[nx][ny][di])
					continue;
				
				if(di == cur[3]) {
					if(dist[nx][ny] < cur[2])
						continue;
					pq.add(new int[] {nx, ny, cur[2], di});
				}
				else {
					if(dist[nx][ny] < cur[2] + 1)
						continue;
					pq.add(new int[] {nx, ny, cur[2] + 1, di});
				}
			}
		}
		System.out.println(dist[end[0]][end[1]]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		mat = new boolean[H][W];
		point = new int[2][2];
		
		int idx = 0;
		
		for(int i=0; i<H; i++) {
			String line = br.readLine();
			for(int j=0; j<W; j++) {
				if(line.charAt(j) == '*')
					mat[i][j] = true;
				else if(line.charAt(j) == 'C'){
					point[idx][0] = i;
					point[idx++][1] = j;
				}
			}
		}
		br.close();
	}
}
