package ThisWeek37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2533 {
	static int N;
	static ArrayList<Integer>[] tree;
	static int[][] dp;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][0]));
	}

	private static void dfs(int idx) {
		visit[idx] = true;
		dp[idx][0] = 0;
		dp[idx][1] = 1;

		for (int c : tree[idx]) {
			if (!visit[c]) {
				dfs(c);
				dp[idx][0] += dp[c][1];
				dp[idx][1] += Math.min(dp[c][0], dp[c][1]);
			}
		}
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		dp = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		visit = new boolean[N + 1];

		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			tree[p].add(c);
			tree[c].add(p);
		}
		br.close();
	}
}