import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3190 {
	// 뱀을 stack으로 표현하자.
	// Queue<int[]>
	// 현재 상태를 mat에 표현하기
	
	static int N, hx, hy;
	static int[][] mat;
	static int[] cmds;
	static Queue<int[]> snake;
	
	// 북, 서, 남, 동
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		snake = new LinkedList<int[]>();
		
		// 최초에는 동쪽을 가르키고 있다.
		int dir = 3;
		// 머리의 좌표
		hx = 1;
		hy = 1;
		mat[hx][hy] = 2;
		snake.add(new int[] {1, 1});
		
//		for(int i=1; i<N+1; i++) {
//			for(int j=1; j<N+1; j++) {
//				System.out.print(mat[i][j] + " ");
//			}System.out.println();
//		}
//		System.out.println();

		int count = 0;
		
		while(true) {
			dir = (dir + cmds[count]) % 4;

			count++;
			if(!move(dir))
				break;

		}
		System.out.println(count);

	}

	// 방향대로 이동한다.
	private static boolean move(int dir) {
		int nx = hx + dirx[dir];
		int ny = hy + diry[dir];
		
		// 벽에 닿거나 자기 몸에 닿았을 경우 게임 끝
		if(mat[nx][ny] == -1 || mat[nx][ny] == 2) {
			return false;
		}
		
		if(mat[nx][ny] != 1) {
			int[] tail = snake.poll();
			mat[tail[0]][tail[1]] = 0;
		}
		
		mat[nx][ny] = 2;
		snake.add(new int[] {nx, ny});
		
		hx = nx;
		hy = ny;
		
//		for(int i=1; i<N+1; i++) {
//			for(int j=1; j<N+1; j++) {
//				System.out.print(mat[i][j] + " ");
//			}System.out.println();
//		}
//		System.out.println();
		
		return true;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		mat = new int[N+2][N+2];
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// -1은 벽,
			// 0은 아무것도 없는 공간,
			// 1은 사과가 있는 공간,
			// 2는 뱀에 몸이 있는 공간
			mat[x][y] = 1;
		}
		
		for(int i=0; i<=N+1; i++) {
			mat[i][0] = -1;
			mat[i][N+1] = -1;
			mat[0][i] = -1;
			mat[N+1][i] = -1;
		}
		
		int L = Integer.parseInt(br.readLine());
		cmds = new int[10001];
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			char cmd = st.nextToken().charAt(0);
			if(cmd == 'D') {
				cmds[num] = 3;
			}
			else {
				cmds[num] = 1;
			}
		}
		
		br.close();
	}
}