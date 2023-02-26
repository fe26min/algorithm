package LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11438 {
	static int N, kmax;
	static ArrayList<Integer>[] list;
	static int[][] parent;
	static int[] depth;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		parent = new int[21][N+1];
		depth = new int[N+1];
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		int temp = 1;
		kmax = 0;
		
		while(temp <= N) {
			temp <<= 1;
			kmax++;
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
				parent[0][i] = cur[0];
				queue.add(new int[] {i, cur[1]+1});
			}
		}
		
		for(int k=1; k<=kmax; k++) {
			for(int n=1; n<=N; n++) {
				parent[k][n] = parent[k-1][parent[k-1][n]];
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
	}
	private static int func(int min, int max) {
		for(int k= kmax; k>=0; k--) {
			if(Math.pow(2, k) <= depth[max] - depth[min]) {
				max = parent[k][max];
			}
		}
		
		for(int k= kmax; k>=0; k--) {
			if(parent[k][max] != parent[k][min]) {
				min = parent[k][min];
				max = parent[k][max];
			}
		}
		
		int LCA = min;
		if(min !=max) {
			LCA = parent[0][LCA];
		}
		return LCA;
	}
}
