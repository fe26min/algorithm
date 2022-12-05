package backjoon.fastcampus.ch07.Tree_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No15900 {
	// 리프 노드의 깊이들의 합이 홀수면 Yes, 짝수면 No
	static int N;
	static int[] depth;
	static ArrayList<Integer> adj[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		depth = new int[N + 1];
		adj = new ArrayList[N + 1];
		
		for(int i=0; i<=N; i++)
			adj[i] = new ArrayList<Integer>();
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}
		
		dfs(1, 0, 0);
		
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(adj[i].size()==1) {
				count += depth[i];
			}
		}
		if(count % 2==0) {
			System.out.println("No");
		}
		else {
			System.out.println("Yes");
		}
		br.close();
	}

	private static void dfs(int idx, int pa, int dp) {
		depth[idx] = dp;
		
		for(int i : adj[idx]) {
			if(i==pa) continue;
			dfs(i, idx, dp+1);
		}
	}
}
