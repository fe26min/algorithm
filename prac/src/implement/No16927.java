package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16927 {

	static int N, M, R;
	static int[][] mat;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		// i, i 번째에서 돌기
		for (int i = 0; i < Math.min(N, M) / 2; i++) {
			circle(i);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void circle(int s) {

		int r = R % (2 * N + 2 * M - 8 * s - 4);

		for (int i = 0; i < r; i++) {
			int temp = mat[s][s];

			for (int j = s; j < M - s - 1; j++) {
				mat[s][j] = mat[s][j + 1];
			}
			
			// 오른변
			for(int j=s; j<N-s-1; j++) {
				mat[j][M-s-1] = mat[j+1][M-s-1];
			}
			// 아랫변
			for (int j=s; j < M-s-1; j++) {
				mat[N-s-1][M-j-1] = mat[N-s-1][M-j-2];
			}

			// 왼쪽변
			for (int j=s; j < N-s-1; j++) {
				mat[N-j-1][s] = mat[N-j-2][s];
			}
			mat[s+1][s] = temp;
		}

	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		mat = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();
	}
}
