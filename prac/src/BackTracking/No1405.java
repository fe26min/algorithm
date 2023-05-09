package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1405 {
	static int N;
	static double sumPer;
	static double[] per;
	
	
	static boolean[][] visit;
	
	// 동 서 남 북
	static int[] dirx = {0, 0, 1, -1};
	static int[] diry = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		sumPer = 0.0;
		visit = new boolean[29][29];
		
		// 0, 0은 이미 방문
		visit[14][14] = true;
		
		dfs(0, 14, 14, 1.0);
//		System.out.printf("%.10f\n", sumPer);
		System.out.println(sumPer);
	}
	private static void dfs(int depth, int x, int y, double curPer) {
		if(depth == N) {
			sumPer += curPer;
			return;
		}
		
		for(int di=0; di<4; di++) {
			if(per[di] == 0.0)
				continue;
			int nx = x + dirx[di];
			int ny = y + diry[di];
			
			if(visit[nx][ny])
				continue;
			visit[nx][ny] = true;
			dfs(depth + 1, nx, ny, curPer * per[di]);
			visit[nx][ny] = false;
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		per = new double[4];
		
		for(int i=0; i<4; i++) {
			per[i] = Double.parseDouble(st.nextToken()) / 100.0;
		}
		
		br.close();		
	}
}
