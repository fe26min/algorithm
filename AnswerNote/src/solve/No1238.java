package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1238 {
	
	static int N, M, X, max;
	static int[] dist, rdist;
	static ArrayList<ArrayList<Node>> list, rlist;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		dist = new int[N+1];
		rdist = new int[N+1];

		Arrays.fill(dist, 1000000000);
		Arrays.fill(rdist, 1000000000);
		
		dijkstra(list, dist, X);
		dijkstra(rlist, rdist, X);
		
		int ans = -1;
		for(int i=1; i<=N; i++) {
			ans = Math.max(ans, dist[i] + rdist[i]);
		}
		System.out.println(ans);
	}

	private static void dijkstra(ArrayList<ArrayList<Node>> list, int[] distance, int start) {
		boolean[] visit = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			int idx = pq.poll().idx;
			
			if(visit[idx])
				continue;
			visit[idx] = true;
			
			for(Node node : list.get(idx)) {
				if(distance[node.idx] > distance[idx] + node.dis) {
					distance[node.idx] = distance[idx] + node.dis;
					pq.add(new Node(node.idx, distance[node.idx]));
				}
 			}
			
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		rlist = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<Node>());
			rlist.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(u).add(new Node(v, w));
			rlist.get(v).add(new Node(u, w));
		}
		br.close();
	}
}

class Node implements Comparable<Node>{
	int idx;
	int dis;
	
	public Node(int idx, int dis) {
		this.idx = idx;
		this.dis = dis;
	}

	@Override
	public int compareTo(Node o) {
		return this.dis - o.dis;
	}
}