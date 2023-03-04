package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1107 {
	static int N, len, M, min;
	static boolean[] broken;
	public static void main(String[] args) throws IOException {
		input();
		pro();
		
	}
	private static void pro() {
		min = Math.abs(N - 100);
		dfs(0, 0);
		System.out.println(min);
	}
	private static void dfs(int depth, int sum) {
		if(depth > len + 1)
			return;
		if(depth != 0)
			min = Math.min(min, Math.abs(N - sum) + depth);
		
		for(int i=0; i<10; i++) {
			if(broken[i])
				continue;
			dfs(depth + 1, sum * 10 + i);
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		N = Integer.parseInt(s);
		len = s.length();
		
		M  = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		StringTokenizer st = null;
		if(M != 0)
			st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			broken[Integer.parseInt(st.nextToken())] = true;
		}
		br.close();
	}
}
