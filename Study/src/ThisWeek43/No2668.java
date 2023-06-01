package ThisWeek43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2668 {
	static int N, count;
	static int[] parent;
	static boolean[] visit, finish, isCycle;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		count = 0;
		visit = new boolean[N];
		finish = new boolean[N];
		isCycle = new boolean[N];
		
		for(int i=0; i<N; i++)
			dfs(i);
		
		System.out.println(count);
		for(int i=0; i<N; i++) {
			if(isCycle[i])
				System.out.println(i + 1);
		}
	}

	private static void dfs(int cur) {
		if(visit[cur])
			return;
		
		visit[cur] = true;
		int next = parent[cur];
		
		if(!visit[next])
			dfs(next);
		if(visit[next] && !finish[next]) {
			isCycle[cur] = true;
			count++;
			
			for(int i=next; i != cur; i = parent[i]) {
				isCycle[i] = true;
				count++;
			}
		}
		
		dfs(next);
		finish[cur] = true;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		
		for(int i=0; i<N; i++)
			parent[i] = Integer.parseInt(br.readLine()) - 1;
		br.close();		
	}
}
