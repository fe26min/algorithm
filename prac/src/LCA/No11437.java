package LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11437 {
	static int N;
	static ArrayList<Integer>[] list;
	static int[] parent;
	static int[] depth;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		parent = new int[N+1];
		depth = new int[N+1];
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[] visit = new boolean[N+1];
		
		queue.add(new int[] {1, 0});
		visit[1] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			depth[cur[0]] = cur[1];
			
			for(int i: list[cur[0]]) {
				if(visit[i])
					continue;
				visit[i] = true;
				parent[i] = cur[0];
				queue.add(new int[] {i, cur[1]+1});
			}
		}
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int min = depth[a]<depth[b] ? a : b;
			int max = depth[a]<depth[b] ? b : a;
			sb.append(func(min, max) + "\n");
		}
		System.out.println(sb);
		br.close();
	}
	private static int func(int a, int b) {
		if(a==b) {
			return a;
		}
		if(depth[a] < depth[b]) {
			return func(a, parent[b]);
		}
		return func(parent[a], parent[b]);
	}
}
