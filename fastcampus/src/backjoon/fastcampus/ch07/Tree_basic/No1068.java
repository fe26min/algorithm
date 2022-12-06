package backjoon.fastcampus.ch07.Tree_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1068 {
	
	static int N;
	static int[] Tree;
	static HashSet<Integer>[] child;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		Tree = new int[N];
		child = new HashSet[N];
		
		for(int i=0; i<N; i++)
			child[i] = new HashSet<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			Integer p = Integer.parseInt(st.nextToken());
			if(p==-1) continue;
			Tree[i] = p;
			child[p].add(i);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		int delIdx = Integer.parseInt(br.readLine());
		queue.add(delIdx);
		child[Tree[delIdx]].remove(delIdx);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i : child[cur]) {
				queue.add(i);
			}
			Tree[cur] = -2;
		}
		int count=0;
		for(int i=0; i<N; i++) {
			if(Tree[i] == -2) continue;
			if(child[i].size() == 0) count++;
		}
		
		System.out.println(count);
		br.close();
	}
}
