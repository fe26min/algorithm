package backjoon.fastcampus.ch09.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		ArrayList<int[]>[] list = new ArrayList[V+1];
		for(int i=0; i<=V; i++) {
			list[i] = new ArrayList<int[]>();
		}
		
		int start = Integer.parseInt(br.readLine());
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); 
			int v = Integer.parseInt(st.nextToken()); 
			int w = Integer.parseInt(st.nextToken()); 
			list[u].add(new int[] {v, w});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		
		pq.add(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int goal = cur[0];
			int weight = cur[1];
			if(dist[goal] < weight) continue;
			dist[goal] = weight;
			
			for(int[] next : list[goal]) {
				if(dist[next[0]] > next[1] + weight) {
					pq.add(new int[] {next[0], next[1] + weight});
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else
				System.out.println(dist[i]);
		}
		
		br.close();
	}
}
