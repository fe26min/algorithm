package ThisWeek31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1167 {
	static int V, max, node;
	static boolean[] visit;
	static ArrayList<int[]>[] list;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		max = 0;
		visit = new boolean[V + 1];
		dfs(1, 0);
		visit = new boolean[V + 1];
		dfs(node, 0);
		
		System.out.println(max);
	}
	
	private static void dfs(int idx, int sum) {
		if(sum > max) {
			max = sum;
			node = idx;
		}	
		visit[idx] = true;
		
		for(int[] i : list[idx]) {
			if(visit[i[0]]) continue;
			dfs(i[0], sum + i[1]);
			visit[i[0]] = true;
		}
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<int[]>();
		}
		for(int i=1; i<=V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int vIdx = Integer.parseInt(st.nextToken());
			
			int idx = Integer.parseInt(st.nextToken());
			while(idx != -1) {
				int weight = Integer.parseInt(st.nextToken());
				
				list[vIdx].add(new int[] {idx, weight});
				idx = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
}
