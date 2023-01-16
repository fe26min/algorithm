package ThisWeek24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No15683 {
	
	static int N, M, wcnt, size, min;
	static ArrayList<int[]> cctvs;
	static int[] dir;
	static int[][] mat;
	static boolean[][] watched;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		min = N * M + 1;
		dfs(0);
		System.out.println(min - wcnt);
	}

	private static void dfs(int depth) {
		if(depth==size) {
			check();
			return;
		}
		int type = cctvs.get(depth)[2];
		
		if(type == 5) {
			dir[depth] = 0;
			dfs(depth + 1);
		}
		else if(type == 2){
			dir[depth] = 0;
			dfs(depth + 1);
			dir[depth] = 1;
			dfs(depth + 1);
		}
		else {
			for(int di=0; di<4; di++) {
				dir[depth] = di;
				dfs(depth + 1);
			}
		}
	}

	private static void check() {
		watched = new boolean[N][M];
		
		for(int i=0; i<size; i++) {
			int cx = cctvs.get(i)[0];
			int cy = cctvs.get(i)[1];
			int type = cctvs.get(i)[2];
			int cdir = dir[i];

			watch(cx, cy, cdir);
			switch(type) {
			case 1:
				break;
			case 2:
				watch(cx, cy, (cdir + 2) % 4);
				break;
			case 3:
				watch(cx, cy, (cdir + 1) % 4);
				break;
			case 4:
				watch(cx, cy, (cdir + 1) % 4);
				watch(cx, cy, (cdir + 2) % 4);
				break;
			case 5:
				watch(cx, cy, (cdir + 1) % 4);
				watch(cx, cy, (cdir + 2) % 4);
				watch(cx, cy, (cdir + 3) % 4);
				break;
			}
		}
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!watched[i][j]) {
//					System.out.print("0 ");
					count++;
				}
				else {
//					System.out.print("# ");
				}
			}
//			System.out.println();
		}
//		System.out.println();
		min = Math.min(min, count);
	}

	private static void watch(int x, int y, int dir) {
		if(dir==0) {
			for(int i=x; i>=0; i--) {
				if(mat[i][y]==6) break;
				watched[i][y] = true;
			}
		}
		else if(dir==1) {
			for(int i=y; i<M; i++) {
				if(mat[x][i]==6) break;
				watched[x][i] = true;
			}
		}
		else if(dir==2) {
			for(int i=x; i<N; i++) {
				if(mat[i][y]==6) break;
				watched[i][y] = true;
			}
		}
		else if(dir==3) {
			for(int i=y; i>=0; i--) {
				if(mat[x][i]==6) break;
				watched[x][i] = true;
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		cctvs = new ArrayList<int[]>();
		
		wcnt = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j]!=0) {
					if(mat[i][j]==6) {
						wcnt++;
						continue;
					}
					cctvs.add(new int[] {i, j, mat[i][j]});
				}
			}
		}
		size = cctvs.size();
		dir = new int[size];
		
		br.close();
	}
}
