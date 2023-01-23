import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No16234 {
	// bfs로 돌면서 어레이 리스트에 넣어주기
	static int N, L, R, sum;
	static int[][] mat;
	static ArrayList<int[]> list;
	static boolean[][] visit;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int count = 0;
		while(true) {
			boolean check = false;
			visit = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visit[i][j]) continue;
					list = new ArrayList<int[]>();
					sum = 0;
					dfs(i, j);
					if(list.size() > 1)
						check = true;
					for(int[] area : list) {
						mat[area[0]][area[1]] = sum/list.size();
					}
				}
			}
			if(!check)
				break;
			count++;
		}
		System.out.println(count);
	}

	private static void dfs(int i, int j) {
		sum += mat[i][j];
		visit[i][j] = true;
		list.add(new int[] {i, j});
		
		for(int di = 0; di<4; di++) {
			int nx = i + dirx[di];
			int ny = j + diry[di];
			
			if(nx<0 || ny<0 || nx>=N || ny>=N)
				continue;
			if(visit[nx][ny])
				continue;
			if(Math.abs(mat[i][j]-mat[nx][ny]) < L)
				continue;
			if(Math.abs(mat[i][j]-mat[nx][ny]) > R)
				continue;
			dfs(nx, ny);
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		mat = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
	}
}
