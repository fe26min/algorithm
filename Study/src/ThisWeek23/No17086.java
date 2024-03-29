package ThisWeek23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17086 {
	
	static int N, M, max;
	static int[][] mat;
	static Queue<int[]> queue;

	static int[] dirx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] diry = {-1, 0, 1, -1, 1, -1, 0, 1 };
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		max = 0;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int di=0; di<8; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				int nd = cur[2] + 1;
				
				if(nx<0 || ny<0 || nx>=N|| ny>=M)
					continue;
				if(mat[nx][ny] <= nd)
					continue;
				
				max = Math.max(max, nd);
				mat[nx][ny] = nd;
				queue.add(new int[] {nx, ny, nd});
			}
		}
		System.out.println(max);
//		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(mat[i][j] + " ");
//			}System.out.println();
//		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		for(int i=0; i<N; i++) {
			Arrays.fill(mat[i], Integer.MAX_VALUE);
		}

		queue = new LinkedList<int[]>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					queue.add(new int[] {i, j, 0});
					mat[i][j] = 0;
				}
			}
		}
		br.close();
	}
}
