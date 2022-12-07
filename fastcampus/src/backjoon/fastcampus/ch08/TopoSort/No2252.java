package backjoon.fastcampus.ch08.TopoSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2252 {
	
	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] inCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		inCnt = new int[N + 1];
		
		for(int i=0; i<=N; i++)
			graph[i] = new ArrayList<Integer>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			inCnt[B]++;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(inCnt[i]==0)
				queue.add(i);
		}
		StringBuilder sb = new StringBuilder();
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur + " ");
			for(int i : graph[cur]) {
				inCnt[i]--;
				if(inCnt[i] == 0)
					queue.add(i);
			}
		}
		System.out.println(sb);
		br.close();
	}
	
}
