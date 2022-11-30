package backjoon.fastcampus.ch06.GS_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No2606 {
	
	static int N, count;
	static boolean[] visit;
	static HashMap<Integer, ArrayList<Integer>> hm;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N + 1];
		
		hm = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=1; i<=N; i++)
			hm.put(i, new ArrayList<Integer>());
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			hm.get(x).add(y);
			hm.get(y).add(x);
		}
		count = 0;
		dfs(1);
		System.out.println(count - 1);
		
		br.close();
	}
	private static void dfs(int num) {
		if(visit[num]) return;
		
		count++;
		visit[num] = true;
		
		for(int i: hm.get(num)) {
			if(visit[i]) continue;
			dfs(i);
		}
	}
}
