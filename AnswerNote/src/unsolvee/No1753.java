package unsolvee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1753 {
	
	static int V, start;
	static ArrayList<int[]>[] list;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
		
		pq.add(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int goal = cur[0];
			int weight = cur[1];
			
			if(dist[goal] <  weight)
				continue;
			dist[goal] = weight;
			
			for(int[] next: list[goal]) {
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
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++)
			list[i] = new ArrayList<>();
		
		start = Integer.parseInt(br.readLine());
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
		
			list[u].add(new int[] {v, w});
		}
		
		br.close();
	}
}