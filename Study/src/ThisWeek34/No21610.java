package ThisWeek34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No21610 {
	static int N, M;
	static int[][] mat, move;
	static boolean[][] visit;
	static Queue<int[]> cloud, bugs;
	
	static int[] dirx;
	static int[] diry;
	
	static int[] bugDirx = {-1, -1, 1, 1};
	static int[] bugDiry = {-1, 1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		cloud = new LinkedList<int[]>();
		bugs = new LinkedList<int[]>();
		
		cloud.add(new int[] {N-1, 0});
		cloud.add(new int[] {N-1, 1});
		cloud.add(new int[] {N-2, 0});
		cloud.add(new int[] {N-2, 1});
		
		for(int i=0; i<M; i++) {
//			check();
			cloudMove(move[i][0], move[i][1]);
//			check();
			cloudBug();
			makeCloud();
//			check();
//			System.out.println("--------------");
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				cnt += mat[i][j];
			}
		}
		System.out.println(cnt);
	}
	
	private static void check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(mat[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}

	// 구름 생성
	private static void makeCloud() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j])
					continue;
				if(mat[i][j] >= 2) {
					cloud.add(new int[] {i, j});
					mat[i][j] -= 2;
				}
			}
		}
	}

	// 물복사 버그
	private static void cloudBug() {
		while(!bugs.isEmpty()) {
			int[] cur = bugs.poll();
			int count = 0;
			for(int di=0; di<4; di++) {
				int nx = cur[0] + bugDirx[di];
				int ny = cur[1] + bugDiry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=N)
					continue;
				if(mat[nx][ny]>0)
					count++;
			}
			mat[cur[0]][cur[1]] += count;
		}
	}

	// 구름 이동, 비내리기
	private static void cloudMove(int d, int s) {
		visit = new boolean[N][N];
		while(!cloud.isEmpty()) {
			int[] cur = cloud.poll();
			
			int nx = (cur[0] + s * dirx[d]) % N; 
			int ny = (cur[1] + s * diry[d]) % N;
			visit[nx][ny] = true;
			mat[nx][ny]++;
			bugs.add(new int[] {nx, ny});
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][N];
		move = new int[M][2];
		
		dirx = new int[] {0, N-1, N-1, N-1, 0, 1, 1, 1};
		diry = new int[] {N-1, N-1, 0, 1, 1, 1, 0, N-1};
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			move[i][0] = Integer.parseInt(st.nextToken()) - 1;
			move[i][1] = Integer.parseInt(st.nextToken()) % N;
		}
		br.close();
	}
}
