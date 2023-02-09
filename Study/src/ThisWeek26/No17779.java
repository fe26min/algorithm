package ThisWeek26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17779 {
	
	static int N, answer;
	static int[][] mat, area;
	static boolean[][] visit;
	
	static int[] dirx = {-1, 0, 1, 0};	
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		answer = Integer.MAX_VALUE;
		for(int i=0; i<N-2; i++) {
			for(int j=1; j<N-1; j++) {
				for(int d1=1; j-d1 >= 0; d1++) {
					for(int d2=1; j+d2<N; d2++) {
						if(i+d1+d2 >= N) continue;
						check(i, j, d1, d2);
					}
				}
			}
		}
		System.out.println(answer);
	}


	private static void check(int i, int j, int d1, int d2) {
//		System.out.println(i+" "+j+" "+d1+" "+d2);
		area = new int[N][N];
		visit = new boolean[N][N];
		
		// 1, 2, 3, 4 테두리
		for(int x=0; x<i; x++) {
			area[x][j] = 1;
			visit[x][j] = true;
		}
		for(int y=0; y<j-d1; y++) {
			area[i+d1][y] = 3;
			visit[i+d1][y] = true;
		}
		for(int y=j+d2+1; y<N; y++) {
			area[i+d2][y] = 2;
			visit[i+d2][y] = true;
		}
		for(int x=i+d1+d2+1; x<N; x++) {
			area[x][j-d1+d2] = 4;
			visit[x][j-d1+d2] = true;
		}
		
		// 5 테두리
		for(int z=0; z<d1; z++)
			area[i+z][j-z] = 5;
		for(int z=0; z<d2; z++)
			area[i+z][j+z] = 5;
		for(int z=0; z<d2; z++)
			area[i+d1+z][j-d1+z] = 5;
		for(int z=0; z<=d1; z++)
			area[i+d2+z][j+d2-z] = 5;
		
//		bfs(0,0,1);
//		bfs(N-1,0,3);
//		bfs(0,N-1,2);
//		bfs(N-1,N-1,4);
//		bfs(i,j,5);
		
		for(int x=0; x<N; x++) {
			for(int y=0; y<N; y++) {
				System.out.print(area[x][y] + " ");
			}System.out.println();
		}System.out.println();
//		int[] sum = new int[6];
//		
//		for(int x=0; x<N; x++) {
//			for(int y=0; y<N; y++) {
//				sum[area[x][y]] += mat[x][y];
//			}
//		}
//		
//		int max = 0;
//		int min = Integer.MAX_VALUE;
//		
//		for(int idx=1; idx<=5; idx++) {
//			max = Math.max(sum[idx], max);
//			min = Math.min(sum[idx], min);
//		}
////		System.out.println(sum[1] + " " + sum[2] + " "+ sum[3] + " " + sum[4] + " " + sum[5] + " " + (max - min));
//		
//		answer = Math.min(answer, max - min);
	}

	private static void bfs(int i, int j, int k) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {i, j});
		
		while(!queue.isEmpty()) {
			int[] cur =queue.poll();
			area[cur[0]][cur[1]] = k;
			
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=N)
					continue;
				if(visit[nx][ny])
					continue;
				if(area[nx][ny] !=0 && area[nx][ny]!=k)
					continue;
				visit[nx][ny] = true;
				queue.add(new int[] {nx, ny});
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		mat = new int[N][N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
	}
}
