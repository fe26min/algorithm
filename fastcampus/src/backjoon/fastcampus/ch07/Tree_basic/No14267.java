package backjoon.fastcampus.ch07.Tree_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14267 {
	
	static int N, M;
	static int[] compliment, parent;
	static ArrayList<Integer>[] child;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		child = new ArrayList[N+1];

		compliment = new int[N+1];
		
		for(int i=1; i<=N; i++)
			child[i] = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int p = Integer.parseInt(st.nextToken());
			parent[i] = p;
			if(p==-1) continue;
			child[p].add(i);
		}
		
		for(int idx=0; idx<M; idx++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			compliment[i] += w;
		}
		
		// 부모 부터 차근 차근 넘겨 주기
		dfs(1);
		
		for(int i = 1; i<=N; i++)
			System.out.print(compliment[i] + " ");
		br.close();
	}
	
	private static void dfs(int idx) {
		for(int c : child[idx]) {
			compliment[c] += compliment[idx];
			dfs(c);
		}
	}
}
