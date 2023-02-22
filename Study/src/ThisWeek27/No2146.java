package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2146 {
	
	// 영역 칠하기
	// 영역에서 출발하기
	// 다른 영역 도달시 끝
	
	static int N, cnt;
	static int[][] mat;
	
	static Queue<int[]> bridgeQueue;

	static int[] dirx = {-1,0,1,0};
	static int[] diry = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		cnt -= 1;
		boolean[][][] visit = new boolean[N][N][cnt];
		
		while(!bridgeQueue.isEmpty()) {
			int[] cur = bridgeQueue.poll();
			
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=N)
					continue;
				if(mat[nx][ny] == cur[2])
					continue;
				
				if(mat[nx][ny] == 0) {
					if(visit[nx][ny][cur[2] - 2])
						continue;
					visit[nx][ny][cur[2] - 2] = true;
					bridgeQueue.add(new int[] {nx, ny, cur[2], cur[3] + 1});
				}
				else {
					System.out.println(cur[3]);
					return;
				}
			}
		}
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 영역은 2부터 세준다. 0은 바다, 1은 아직 안 가본 곳
		cnt = 1;
		
		Queue<int[]> drawQueue;
		bridgeQueue = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(mat[i][j] == 1) {
//					System.out.println(i + " " + j);
					cnt++;
					queue.add(new int[] {i, j});
					mat[i][j] = cnt;
					
					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						boolean isBeach = false;
						
						for(int di=0; di<4; di++) {
							int nx = cur[0] + dirx[di];
							int ny = cur[1] + diry[di];
							
							if(nx<0||ny<0||nx>=N||ny>=N)
								continue;
							if(mat[nx][ny] == 0) {
								isBeach = true;
								continue;
							}
							if(mat[nx][ny] != 1)
								continue;
							mat[nx][ny] = cnt;
							queue.add(new int[] {nx, ny});
						}
						if(isBeach) {
							bridgeQueue.add(new int[] {cur[0], cur[1], cnt, 0});
						}
					}
				}
			}
		}
		
		br.close();
	}
}
