package backjoon.fastcampus.ch06.GS_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		boolean[] visit = new boolean[N+1];
		HashMap<Integer, ArrayList<Integer>> list = new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();
		
		for(int i=1; i<=N; i++) {
			list.put(i, new ArrayList<>());
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {1, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int c = cur[0];
			int p = cur[1];
			if(visit[c]) continue;
			visit[c] = true;
			parent.put(c, p);
			
			for(int i: list.get(c)) {
				if(visit[i]) continue;
				queue.add(new int[] {i, c});
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=N; i++) {
			sb.append(parent.get(i)+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
