package backjoon.fastcampus.ch08.TopoSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1005 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int ti=0; ti<T; ti++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int [] cost = new int[N+1];
			int [] inCnt = new int[N+1];
			int [] sum = new int[N+1];
			
			ArrayList<Integer>[] list = new ArrayList[N+1];
			
			for(int i=0; i<=N; i++)
				list[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=N; i++)
				cost[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				list[X].add(Y);
				inCnt[Y]++;
			}
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			for(int i=1; i<=N; i++) {
				if(inCnt[i]==0) {
					queue.add(i);
					sum[i]=cost[i];	
				}
			}
			while (!queue.isEmpty()){
				int cur = queue.poll();
				
				for(int child : list[cur]) {
					inCnt[child]--;
					sum[child] = Math.max(sum[child], sum[cur] + cost[child]);
					
					if(inCnt[child]==0) {
						queue.add(child);
					}
				}
			}
//			for(int i : cost) {
//				System.out.print(i + " ");
//			}System.out.println();
//			
//			for(int i : sum) {
//				System.out.print(i + " ");
//			}System.out.println();
			
			int W = Integer.parseInt(br.readLine());
			sb.append(sum[W]+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
