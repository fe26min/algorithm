package backjoon.answer_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14503 {
	static int N, M, r, c, d, answer, rcnt;
	static int[][] mat;
	static boolean[][] visit;
	
	static int dirx[] = {-1, 0, 1, 0};
	static int diry[] = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		input();
		pro();

	}

	private static void pro() {
		answer = 0;
		rcnt = 0;
		while(true) {
			// 현재 위치를 청소한다.
			clean();
			// 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
			if(!canGo()) {
				break;
			}
		}
		System.out.println(answer);
	}

	private static boolean canGo() {
		// 다음 방향 왼쪽으로 돌린다.
		int nd = (d + 3) % 4;
		int nx = r + dirx[nd];
		int ny = c + diry[nd];
		
		// 아직 청소하지 않은 공간이라면
		if(mat[nx][ny]==0 && !visit[nx][ny]) {
			// 방향을 바꿔준다.
			d = nd;
			// 한칸 전진한다.
			r = nx;
			c = ny;
			
			// 회전 수 초기화
			rcnt = 0;

			// 1번부터 진행한다.
			return true;
		}
		
		// 아직 4방향을 모두 탐색한게 아니라면 2-2번을 한다.
		if(rcnt<4) {
			d = nd;
			// 회전 수 증가
			rcnt++;
			// 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
			return canGo();
		}
		
		// 네 방향 모두 청소가 이미 되어있거나 벽인 경우
		// 뒤로 향한다.
		nd = (d + 2) % 4;
		nx = r + dirx[nd];
		ny = c + diry[nd];
		
		// 뒤에가 벽이 아닐 경우 후진하고 2번으로 돌아간다.
		if(mat[nx][ny]==0) {
			// 방향은 유지한다.
			r = nx;
			c = ny;
			rcnt = 0;
			return canGo();
		}
		
		return false;
	}
	
	//현재 위치를 청소한다.
	private static void clean() {
		if(visit[r][c])
			return;
		visit[r][c] = true;
		answer++;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		visit = new boolean[N][M];

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
	}
}