package ThisWeek38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1987 {
	static int R, C, max;
	static int[][] mat;
	static boolean[] visit = new boolean[26];
	
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		max = 0;
		visit[mat[0][0]] = true;
		dfs(0, 0, 1);
		
		System.out.println(max);
	}

	private static void dfs(int r, int c, int depth) {
		max = Math.max(max, depth);
		
		for(int di=0; di<4; di++) {
			int nx = r + dirx[di];
			int ny = c + diry[di];
			
			if(nx<0||ny<0||nx>=R||ny>=C)
				continue;
			if(visit[mat[nx][ny]])
				continue;
			visit[mat[nx][ny]] = true;
			dfs(nx, ny, depth +1);
			visit[mat[nx][ny]] = false;
		}
		
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		mat = new int[R][C];
		
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				mat[i][j] = line.charAt(j)-'A';
			}
		}
		br.close();		
	}
}
