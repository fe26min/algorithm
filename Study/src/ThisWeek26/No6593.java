package ThisWeek26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No6593 {
	static int L, R, C, sl, sr, sc;
	static char[][][] mat;

	static int[] dirx = {-1, 0, 1, 0, 0, 0 };
	static int[] diry = {0, -1, 0, 1, 0, 0 };
	static int[] dirz = {0, 0, 0, 0, -1, 1 };

	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L==0 && R==0 && C==0) {
				break;
			}
			mat = new char[L][R][C];
			
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					String line = br.readLine();
					for(int k=0; k<C; k++) {
						mat[i][j][k] = line.charAt(k);
						if(mat[i][j][k]=='S') {
							sl = i;
							sr = j;
							sc = k;
						}
					}
				}
				br.readLine();
			}
			bfs();
		}
		System.out.println(sb);
		br.close();
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean visit[][][] = new boolean[L][R][C];
		queue.add(new int[] {sl, sr, sc, 0});
		visit[sl][sr][sc] = true;
		
		while(!queue.isEmpty()) {
			int l = queue.peek()[0];
			int r = queue.peek()[1];
			int c = queue.peek()[2];
			int d = queue.peek()[3];
			queue.poll();
			
			if(mat[l][r][c]=='E') {
				sb.append("Escaped in " + d + " minute(s).\n");
				return;
			}
			
			for(int di=0; di<6; di++) {
				int nl = l + dirz[di];
				int nr = r + dirx[di];
				int nc = c + diry[di];
				
				if(nl<0||nr<0||nc<0||nl>=L||nr>=R||nc>=C)
					continue;
				if(mat[nl][nr][nc]=='#')
					continue;
				if(visit[nl][nr][nc])
					continue;
				visit[nl][nr][nc] = true;
				queue.add(new int[] {nl, nr, nc, d+1});
			}
		}
		sb.append("Trapped!\n");
		return;
	}
}
