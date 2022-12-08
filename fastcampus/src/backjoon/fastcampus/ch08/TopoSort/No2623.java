package backjoon.fastcampus.ch08.TopoSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2623 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int inCnt[] = new int[N+1];
		
		for(int i=0; i<=N; i++)
			list.add(new ArrayList<Integer>());
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			int before = Integer.parseInt(st.nextToken());
			
			for(int i=1; i<num; i++) {
				int after = Integer.parseInt(st.nextToken());
				inCnt[after]++;
				list.get(before).add(after);
				before = after;
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(inCnt[i]==0) {
				queue.add(i);
			}
		}
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			count++;
			sb.append(cur+"\n");
			for(int i : list.get(cur)) {
				inCnt[i]--;
				if(inCnt[i]==0) {
					queue.add(i);
				}
			}
		}
		
		if(count==N) {
			System.out.println(sb);
		}
		else {
			System.out.println(0);
		}
	}
}