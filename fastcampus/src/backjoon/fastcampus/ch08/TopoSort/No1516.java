package backjoon.fastcampus.ch08.TopoSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1516 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		int cost[] = new int[N+1];
		int inCnt[] = new int[N+1];
		int sum[] = new int[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			
			while(true) {
				int parent = Integer.parseInt(st.nextToken());
				if(parent == -1)
					break;
				list[parent].add(i);
				inCnt[i]++;
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>(); 
		
		for(int i=1; i<=N; i++) {
			if(inCnt[i]==0) {
				queue.add(i);
				sum[i] = cost[i];
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int child : list[cur]) {
				inCnt[child]--;
				sum[child] = Math.max(sum[child], sum[cur] + cost[child]);
				
				if(inCnt[child]==0) {
					queue.add(child);
				}
			}
		}
		
		for(int i=1; i<=N; i++)
			System.out.println(sum[i]);
		
		br.close();
	}
}
