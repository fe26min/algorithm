package backjoon.fastcampus.ch09.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<int[]>[] list = new ArrayList[N+1];
		
		int dist[] = new int[N+1];

		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<int[]>();
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[s].add(new int[] {e, w});
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		
		pq.add(new int[] {start, 0});
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int goal = cur[0];
			int weight = cur[1];
			
			if(dist[goal] < weight) continue;
			dist[goal] = weight;
			
			for(int[] next : list[goal]) {
				if(dist[next[0]] > weight + next[1])
					pq.add(new int[] {next[0], weight + next[1]});
			}
		}
		System.out.println(dist[end]);
		br.close();
	}
}
