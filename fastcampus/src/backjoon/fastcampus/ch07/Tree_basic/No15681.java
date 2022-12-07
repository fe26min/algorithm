package backjoon.fastcampus.ch07.Tree_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No15681 {
	
	static ArrayList<Integer>[] graph;
	static int[] parent;
	static int[] childCnt;
	static int N, R, Q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		childCnt = new int[N + 1];
		
		graph = new ArrayList[N + 1];
		
		for(int i=1; i<=N; i++)
			graph[i] = new ArrayList<Integer>();
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			graph[U].add(V);
			graph[V].add(U);
		}
		
		parent[R] = -1;
		dfs(R);
//		System.out.println();
//		for(int i=0; i<=N; i++)
//			System.out.print(i + " ");
//		System.out.println();
//		
//		for(int i : parent)
//			System.out.print(i + " ");
//		System.out.println();
//		
//		for(int i : childCnt)
//			System.out.print(i + " ");
//		System.out.println();
		
		for(int i=0; i<Q; i++) {
			int U = Integer.parseInt(br.readLine());
			System.out.println(childCnt[U]);
		}
		
		br.close();
	}
	
	private static int dfs(int cur) {
		
		int count = 0;
		for(int i : graph[cur]) {
			if(parent[i]!=0) continue;
			parent[i] = cur;
			count += dfs(i);
		}
		count++;
		childCnt[cur] = count;
		return count;
	}
}
