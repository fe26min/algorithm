package ThisWeek23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No11779 {
	
	static int N, start, end;
	static ArrayList<int[]>[] list;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		
		int[] dist = new int[N+1];
		int[] route = new int[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		
		pq.add(new int[] {start, 0});
		dist[start] = 0;
		route[start] = 0;
		
		while(!pq.isEmpty()) {
			
			int[] cur = pq.poll();
			int goal = cur[0];
			int weight = cur[1];
			
			if(dist[goal] < weight) 
				continue;
			
			dist[goal] = weight;
			
			for(int[] next : list[goal]) {
				
				if(dist[next[0]] > next[1] + weight) {
					pq.add(new int[] {next[0], next[1] + weight});
					route[next[0]] = goal;
				}
			}
		}
		System.out.println(dist[end]);
		
		LinkedList<Integer> routes = new LinkedList<>();
		int idx = end;
		
		while(idx != 0) {
			routes.addFirst(idx);
			idx = route[idx];
		}
		System.out.println(routes.size());
		for(int i : routes) {
			System.out.print(i + " ");
		}System.out.println();
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<int[]>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			list[s].add(new int[] {e, g});
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		br.close();
	}
}

