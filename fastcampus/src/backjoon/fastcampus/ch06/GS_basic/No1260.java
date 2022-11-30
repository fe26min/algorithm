package backjoon.fastcampus.ch06.GS_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1260 {
	
	static int N, M, V;
	static boolean[] visit;
	static HashMap<Integer, ArrayList<Integer>> hm;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visit = new boolean[N + 1];
		hm = new HashMap<>();
		sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			hm.put(i, new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			hm.get(a).add(b);
			hm.get(b).add(a);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(hm.get(i));
		}
		
		visit[V] = true;
		dfs(V);
		sb.append("\n");
		visit = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
		br.close();
	}
	
	private static void bfs(int where) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(where);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(visit[cur]) continue;
			visit[cur] = true;
			sb.append(cur + " ");
			
			for(int i:hm.get(cur)) {
				if(visit[i]) continue;
				queue.add(i);
			}
		}
		
	}
	private static void dfs(int where) {
		sb.append(where + " ");
		for(int i: hm.get(where)) {
			if(visit[i]) continue;
			visit[i] = true;
			dfs(i);
		}
	}
}
