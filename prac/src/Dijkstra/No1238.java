package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1238 {
	static int N, M, X;
	static int[] ItoX, XtoI;
	
	static ArrayList<int[]>[] list, revList;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		ItoX = new int[N+1];
		XtoI = new int[N+1];
		
		Arrays.fill(ItoX, Integer.MAX_VALUE);
		Arrays.fill(XtoI, Integer.MAX_VALUE);
		
		dijkstra();
	}
	private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
		pq.add(new int[] {X, 0});
		XtoI[X] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(XtoI[cur[0]] < cur[1])
				continue;
			
			for(int[] road : list[cur[0]]) {
				int next = road[0];
				int nextT = cur[1] + road[1];
				
				if(XtoI[next] < nextT)
					continue;
				XtoI[next] = nextT;
				pq.add(new int[] {next, nextT});
			}
		}
//		for(int i =1; i<=N; i++) {
//			System.out.print(XtoI[i] + " ");
//		}System.out.println();
		
		pq = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
		pq.add(new int[] {X, 0});
		ItoX[X] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(cur[1] < cur[1])
				continue;
			
			for(int[] road : revList[cur[0]]) {
				int next = road[0];
				int nextT = cur[1] + road[1];
				
				if(ItoX[next] < nextT)
					continue;
				ItoX[next] = nextT;
				pq.add(new int[] {next, nextT});
			}
		}
		
//		for(int i =1; i<=N; i++) {
//			System.out.print(ItoX[i] + " ");
//		}System.out.println();

		int max = 0;
		
		for(int i=1; i<=N; i++) {
			max = Math.max(max, XtoI[i] + ItoX[i]);
		}
		System.out.println(max);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		revList = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			revList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			list[s].add(new int[] {e, t});
			revList[e].add(new int[] {s, t});
		}
		br.close();
	}
}
