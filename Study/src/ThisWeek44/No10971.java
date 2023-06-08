package ThisWeek44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10971 {
	static int N, ans, last, start, sum;
	static int[][] W;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		ans = 10000000;
		
		for(int i=0; i<N; i++) {
			start = i;
			visit = new boolean[N];
			visit[start] = true;
			sum = 0;
			dfs(1, i);
		}
		
		System.out.println(ans);
	}
	private static void dfs(int depth, int cur) {
		if(depth == N) {
			if(W[cur][start] != 0)
				ans = Math.min(ans, sum + W[cur][start]);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visit[i])
				continue;
			if(W[cur][i] == 0)
				continue;
			visit[i] = true;
			sum += W[cur][i];
			dfs(depth +1, i);
			visit[i] = false;
			sum -= W[cur][i];
		}
		
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		W = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();		
	}
}
