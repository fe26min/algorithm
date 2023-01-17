package ThisWeek24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1987 {
	static int R, C, max;
	static char[][] mat;
	static boolean[] used;
	static boolean[][] visit;
	
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		max = 0;
		visit[0][0] = true;
		used[mat[0][0]-'A'] = true;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int x, int y, int depth) {
		max = Math.max(max, depth);
		
		for(int di=0; di<4; di++) {
			int nx = x + dirx[di];
			int ny = y + diry[di];
			
			if(nx<0 || ny<0 || nx>=R || ny>=C)
				continue;
			if(visit[nx][ny])
				continue;
			if(used[mat[nx][ny]-'A'])
				continue;

			visit[nx][ny] = true;
			used[mat[nx][ny] - 'A'] = true;
			dfs(nx, ny, depth+1);
			visit[nx][ny] = false;
			used[mat[nx][ny] - 'A'] = false;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visit = new boolean[R][C];
		used = new boolean[26];
		mat = new char[R][C];
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				mat[i][j] = line.charAt(j);
			}
		}
		
		br.close();
	}
}
