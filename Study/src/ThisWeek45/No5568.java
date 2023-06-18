package ThisWeek45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class No5568 {
	static int N, K;
	static String[] inputs;
	static HashSet<String> hs;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		hs = new HashSet<>();
		visited = new boolean[N];
		
		dfs(0, "");
		System.out.println(hs.size());
	}
	private static void dfs(int depth, String s) {
		if(depth == K) {
			hs.add(s);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			dfs(depth + 1, s + inputs[i]);
			visited[i] = false;
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inputs= new String[N];
		
		K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			inputs[i] = br.readLine();
		}
		
		br.close();
	}
}
