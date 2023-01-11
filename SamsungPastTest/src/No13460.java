
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 삼성 SW 역량 테스트 기출 문제
// 구슬 탈출 2
public class No13460 {
	static int N, M, rx, ry, bx, by;
	static char[][] mat;
	static boolean[][][][] visit;
	
	static int dirx[] = {-1, 0, 1, 0};
	static int diry[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		// bfs 문제
		Queue<int[]> queue = new LinkedList<int[]>();
		
		// red x좌표, red y좌표, blue x좌표, blue y좌표, 깊이
		queue.add(new int[] {rx, ry, bx, by, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
//			System.out.println(cur[0] + " " + cur[1] + " " + cur[2] + " " + cur[3] + " " + cur[4]);
			// 파란 공이 나갔다면 pass
			if(mat[cur[2]][cur[3]] == 'O')
				continue;
			// 10번 이하가 아니라면 나간다.
			if(cur[4] == 11)
				continue;
			
			// 빨간 공이 나갔다면 pass
			// 이미 파란 공이 나가지 않았다는 것을 위에 체크
			if(mat[cur[0]][cur[1]] == 'O') {
				System.out.println(cur[4]);
				return;
			}
			
			for(int di=0; di<4; di++) {
				int[] next = move(cur, di);
				// 이미 탐	색한 곳이라면 PASS
				if(visit[next[0]][next[1]][next[2]][next[3]])
					continue;
				visit[next[0]][next[1]][next[2]][next[3]] = true;
				queue.add(next);
			}
		}
		System.out.println(-1);
	}
	
	// di 방향으로 이동해준다.
	private static int[] move(int[] cur, int di) {
		int[] next = new int[5];
		int nrx = cur[0];
		int nry = cur[1];
		int nbx = cur[2];
		int nby = cur[3];
		
		next[4] = cur[4] + 1;
		
		// r이동
		while(mat[nrx][nry]=='.') {
			nrx += dirx[di];
			nry += diry[di];
			if(nrx==nbx && nry==nby) break;
		}
		if(mat[nrx][nry] != 'O') {
			nrx -= dirx[di];
			nry -= diry[di];
		}
		next[0] = nrx;
		next[1] = nry;
		
		// b이동
		while(mat[nbx][nby]=='.') {
			nbx += dirx[di];
			nby += diry[di];
			if(nrx==nbx && nry==nby) break;
		}
		if(mat[nbx][nby] != 'O') {
			nbx -= dirx[di];
			nby -= diry[di];
		}
		next[2] = nbx;
		next[3] = nby;
		
		// r이동
		while(mat[nrx][nry]=='.') {
			nrx += dirx[di];
			nry += diry[di];
			if(nrx==nbx && nry==nby) break;
		}
		if(mat[nrx][nry] != 'O') {
			nrx -= dirx[di];
			nry -= diry[di];
		}
		next[0] = nrx;
		next[1] = nry;
		
		// b이동
		while(mat[nbx][nby]=='.') {
			nbx += dirx[di];
			nby += diry[di];
			if(nrx==nbx && nry==nby) break;
		}
		if(mat[nbx][nby] != 'O') {
			nbx -= dirx[di];
			nby -= diry[di];
		}
		next[2] = nbx;
		next[3] = nby;
		
		return next;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new char[N][M];
		visit = new boolean[N][M][N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				mat[i][j] = line.charAt(j);
				if(mat[i][j] == 'R') {
					rx = i;
					ry = j;
					mat[i][j] = '.';
				}
				else if(mat[i][j] == 'B') {
					bx = i;
					by = j;
					mat[i][j] = '.';
				}
			}
		}
		
		br.close();
	}
}