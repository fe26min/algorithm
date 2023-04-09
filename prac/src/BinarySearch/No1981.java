package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1981 {
	static int N, min, max;
	static int[][] mat;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int l = 0;
		int r = max - min;
		int ans = -1;

		while(l <= r) {
			int mid = (l + r) /2;
			// 만약 도달한다면 
			if(bfs(mid)) {
				ans = mid;
				r = mid - 1;
			}
			// 도달이 불가능하다면
			else {
				l = mid + 1;
			}
		}
		System.out.println(ans);
	}
	private static boolean bfs(int mid) {
		for(int i=min; i+mid <= max; i++) {
			int s = i;
			int e = s+mid;
			
			if(s> mat[0][0] || mat[0][0] > e) {
				continue;
			}
			
			boolean[][] visit = new boolean[N][N];
			
			Queue<int[]> queue = new LinkedList<int[]>();
			// 현재 x, 현재 y
			queue.add(new int[] {0, 0});
			
			visit[0][0] = true;
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				
				// 도착하였다.
				if(cur[0]==N-1 && cur[1]==N-1)
					return true;
				
				for(int di=0; di<4; di++) {
					int nx = cur[0] + dirx[di];
					int ny = cur[1] + diry[di];
					
					if(nx<0||ny<0||nx>=N||ny>=N)
						continue;
					if(visit[nx][ny])
						continue;
					if(mat[nx][ny] < s || mat[nx][ny] > e)
						continue;
					visit[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		return false;
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		min = 200;
		max = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, mat[i][j]);
				min = Math.min(min, mat[i][j]);
			}
		}
		br.close();		
	}
}
