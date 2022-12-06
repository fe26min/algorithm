package backjoon.fastcampus.ch07.Tree_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14267 {
	static int N, M;
	static int[] count, Tree;
	static HashSet<Integer>[] child;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		count = new int[N];
		Tree = new int[N];
		child = new HashSet[N];
		
		for(int i=0; i<N; i++)
			child[i] = new HashSet<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int p = Integer.parseInt(st.nextToken())-1;
			if(p<0) continue;
			Tree[i] = p;
			child[p].add(i);
		}
		
		for(int idx=0; idx<M; idx++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(i);
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				count[cur] += w;
				for(int num : child[cur]) {
					queue.add(num);
				}
			}
		}
		for(int i: count) {
			System.out.print(i + " ");
		}
		
		br.close();
	}
}
