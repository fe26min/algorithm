package backjoon.fastcampus.ch07.Tree_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1240 {
	static ArrayList<int[]>[] Tree;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Tree = new ArrayList[N+1];
		
		for(int i =1; i<N+1; i++) {
			Tree[i] = new ArrayList<int[]>();
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			Tree[a].add(new int[] {b, c});
			Tree[b].add(new int[] {a, c});
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Queue<int[]> queue = new LinkedList<int[]>();
			visit = new boolean[N+1];
			
			queue.add(new int[] {a, 0});
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				if(visit[cur[0]]) continue;
				visit[cur[0]] = true;
				
				if(cur[0]==b) {
					sb.append(cur[1]+"\n");
					break;
				}
				
				for(int[] next : Tree[cur[0]]) {
					queue.add(new int[] {next[0], cur[1]+next[1]});
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
}
