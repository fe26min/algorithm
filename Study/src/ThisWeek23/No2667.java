package ThisWeek23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2667 {
	
	// DFS 문제
	static int N, area;
	static int[] areaCnt;
	static int[][] mat, check;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		area = 0;
		areaCnt = new int[N * N + 1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(mat[i][j]==1 && check[i][j]==0) {
					area++;
					areaCnt[area]++;
					dfs(i, j, area);
				}
			}
		}
		System.out.println(area);
		Arrays.sort(areaCnt);
		for(int i : areaCnt) {
			if(i==0) continue;
			System.out.println(i);
		}
	}

	// x, y에서 영역 찾기
	private static void dfs(int x, int y, int count) {
		check[x][y] = count;
		
		for(int di=0; di<4; di++) {
			int nx = x + dirx[di];
			int ny = y + diry[di];
			
			if(nx<0||ny<0||nx>=N||ny>=N)
				continue;
			if(mat[nx][ny]==0 || check[nx][ny]!=0)
				continue;
			check[nx][ny] = count;
			areaCnt[count]++;
			dfs(nx, ny, count);
		}
		
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		mat = new int[N][N];
		check = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				mat[i][j] = line.charAt(j) - '0';
			}
		}
		
		br.close();
	}
}
