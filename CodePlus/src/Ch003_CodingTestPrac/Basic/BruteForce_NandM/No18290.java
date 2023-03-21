package Ch003_CodingTestPrac.Basic.BruteForce_NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No18290 {
	static int max = -1_000_000;
	static int N, M, K;
	static int[][] mat;
	static boolean[][] visit;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		dfs(0, 0, 0, 0);
		System.out.println(max);
	}

	private static void dfs(int x, int y, int depth, int sum) {
		if(depth == K) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int j=y; j<M; j++) {
			if(check(x, j)) {
				visit[x][j] = true;
				dfs(x, j+1, depth+1, sum + mat[x][j]);
				visit[x][j] = false;
			}
		}
		
		for(int i=x+1; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(check(i, j)) {
					visit[i][j] = true;
					dfs(i, j + 1, depth+1, sum + mat[i][j]);
					visit[i][j] = false;
				}
			}
		}
	}

	private static boolean check(int x, int y) {
		for(int di=0; di<4; di++) {
			int nx = x + dirx[di];
			int ny = y + diry[di];
			
			if(nx<0||ny<0||nx>=N||ny>=M)
				continue;
			if(visit[nx][ny])
				return false;
		}
		return true;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
	}
}
