package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// dp 문제
public class No21923 {
	static int N, M;
	static int[][] mat, up, down;
	
	static int[] dirx = {-1,0};
	static int[] diry = {0,1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		up = dp(N-1, 0, 1);
		down = dp(N-1, M-1, -1);
		
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ans = Math.max(ans, up[i][j] + down[i][j]);
			}
		}
		System.out.println(ans);
	}

	private static int[][] dp(int sx, int sy, int flag) {
		int[][] temp = new int[N][M];
		for(int[] i : temp) 
			Arrays.fill(i, Integer.MIN_VALUE);
		temp[sx][sy] = mat[sx][sy];
		
		int[] dirx = {-1, 0};
		int[] diry = {0, 1};
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {sx, sy});
		
		while(!queue.isEmpty()) {
			int cx = queue.peek()[0];
			int cy = queue.peek()[1];
			queue.poll();
			
			for(int i=0; i<2; i++) {
				int nx = cx + dirx[i];
				int ny = cy + diry[i] * flag;
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(temp[nx][ny] < temp[cx][cy] + mat[nx][ny]) {
					temp[nx][ny] = temp[cx][cy] + mat[nx][ny];
					queue.add(new int[] {nx, ny});
				}
			}
		}
		
		return temp;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
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
