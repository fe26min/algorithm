package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1079 {
	static int N, max, enjin;
	static int[] guilty;
	static int[][] R;

	static boolean[] isDead;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		isDead = new boolean[N];
		max = 0;
		dfs(0, N);
		System.out.println(max);
	}

	private static void dfs(int depth, int num) {
		if (num == 1 || isDead[enjin]) {
			max = Math.max(max, depth);
			return;
		}

		// 밤
		if (num % 2 == 0) {
			for(int i = 0; i < N; i++) {
				if (i == enjin || isDead[i])
					continue;

				isDead[i] = true;
				for (int j = 0; j < N; j++)
					guilty[j] += R[i][j];
				dfs(depth + 1, num - 1);
				isDead[i] = false;
				for (int j = 0; j < N; j++)
					guilty[j] -= R[i][j];
			}
		}
		// 낮
		else {
			int susNum = -1;
			int susIdx = -1;
			
			for(int i=0; i<N; i++) {
				if(!isDead[i] && susNum < guilty[i]) {
					susNum = guilty[i];
					susIdx = i;
				}
			}
			
			isDead[susIdx] = true;
			dfs(depth, num-1);
			isDead[susIdx] = false;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		guilty = new int[N];
		R = new int[N][N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			guilty[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		enjin = Integer.parseInt(br.readLine());
		br.close();
	}
}
