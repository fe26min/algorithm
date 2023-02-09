import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17779 {
	static int N, answer;
	static int[][] mat, area;
	static boolean[][] visit;
	static int[] dirx = { -1, 0, 1, 0 };
	static int[] diry = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		input();
		pro();

	}

	private static void pro() {
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < N - 1; j++) {
				for (int d1 = 1; j - d1 >= 0; d1++) {
					for (int d2 = 1; j + d2 < N; d2++) {
						if (i + d1 + d2 >= N)
							continue;
						func(i, j, d1, d2);
					}
				}
			}
		}
		System.out.println(answer);
	}

	// 4꼭지점을 마크 해주기
	// i, j
	// i+d1, j-d1;
	// i+d2, j+d2;
	// i+d1+d2, j-d1+d2;
	private static void func(int i, int j, int d1, int d2) {
		System.out.println(i + " " + j + " " + d1 + " " + d2);
		area = new int[N][N];
		visit = new boolean[N][N];
		// 5영역 4변 처리
		for (int a = 0; a <= d1; a++) {
			area[i + a][j - a] = 5;
		}
		for (int a = 1; a <= d2; a++) {
			area[i + a][j + a] = 5;
		}
		for (int a = 1; a <= d2; a++) {
			area[i + d1 + a][j - d1 + a] = 5;
		}
		for (int a = 1; a <= d1; a++) {
			area[i + d2 + a][j + d2 - a] = 5;
		}
		// 1꼭지점 처리
		for (int x = 0; x < i; x++) {
			area[x][j] = 1;
			visit[x][j] = true;
		}
		// 3꼭지점 처리
		for (int y = 0; y < j - d1; y++) {
			area[i + d1][y] = 3;
			visit[i + d1][j] = true;
		}
		// 2꼭지점 처리
		for (int y = j + d2 + 1; y < N; y++) {
			area[i + d2][y] = 2;
			visit[i + d2][j] = true;
		}
		// 4꼭지점 처리
		for (int x = i + d1 + d2 + 1; x < N; x++) {
			area[x][j - d1 + d2] = 4;
			visit[x][j - d1 + d2] = true;
		}
//		for (int x = 0; x < N; x++) {
//			for (int y = 0; y < N; y++) {
//				System.out.print(area[x][y] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		bfs(i, j);
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				System.out.print(area[x][y] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void bfs(int i, int j) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 1});
		bfsFunc(queue);
		queue.add(new int[] {0, N-1, 2});
		bfsFunc(queue);
		queue.add(new int[] {N-1, 0, 3});
		bfsFunc(queue);
		queue.add(new int[] {N-1, N-1, 4});
		bfsFunc(queue);
		queue.add(new int[] {i+1, j, 5});
		bfsFunc(queue);
	}

	private static void bfsFunc(Queue<int[]> queue) {
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			area[cur[0]][cur[1]] = cur[2];
			for(int di = 0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(visit[nx][ny]) continue;
				if(area[nx][ny]!=0 && area[nx][ny]!=cur[2]) continue;
				visit[nx][ny] = true;
				queue.add(new int[] {nx, ny, cur[2]});
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
}
