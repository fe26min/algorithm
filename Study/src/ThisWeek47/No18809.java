package ThisWeek47;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No18809 {
	static int N, M, G, R, canSize, ans;
	static int[][] mat, arr;
	static boolean[] visit;
	static LinkedList<Integer> green, red;
	static ArrayList<int[]> areas;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		visit = new boolean[10];
		green = new LinkedList<>();
		red = new LinkedList<>();
		
		go(0, 0, 0, 0);
		
		System.out.println(ans);
	}
	

	private static void go(int s, int cnt, int g, int r) {
		if(cnt > canSize)
			return;
		if(g>G)
			return;
		if(r>R)
			return;
		if(g==G && r==R)
			ans = Math.max(ans, bfs());
		for(int i=s; i<canSize; i++) {
			if(visit[i])
				continue;
			visit[i] = true;
			green.addLast(i);
			go(i + 1, cnt+1, g+1, r);
			green.pollLast();
			
			red.addLast(i);
			go(i + 1, cnt+1, g, r+1);
			red.pollLast();
			visit[i] = false;
		}
	}

	private static int bfs() {
		
		int res = 0;
		int[][] color = new int[N][M];
		int[][] time = new int[N][M];
		
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i : green) {
			int[] g = areas.get(i);
			queue.add(new int[] {g[0], g[1], 1, 0});
			color[g[0]][g[1]] = 1;
		}
		for(int i : red) {
			int[] r = areas.get(i);
			queue.add(new int[] {r[0], r[1], 2, 0});
			color[r[0]][r[1]] = 2;
		}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if(color[cur[0]][cur[1]] == 3)
				continue;
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=M)
					continue;
				if(mat[nx][ny] == 0)
					continue;
				if(color[nx][ny] == 0) {
					color[nx][ny] = cur[2];
					time[nx][ny] = cur[3] + 1;
					queue.add(new int[] {nx, ny, cur[2], cur[3] + 1});
				}
				else if(color[nx][ny] != 3) {
					if(color[nx][ny] != cur[2] && time[nx][ny] == cur[3] + 1){
						color[nx][ny] = 3;
						res++;
					}
				}
			}
		}
		return res;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		areas = new ArrayList<>();
		int idx = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j] == 2) {
					areas.add(new int[] {i, j});
				}
			}
		}
		canSize = areas.size();
		br.close();		
	}
}
