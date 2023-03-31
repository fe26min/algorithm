package ThisWeek34;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class No1325 {
	static int N;
	static boolean[] visit;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int max = 0;
		int[] result = new int[N + 1];
		for(int i=1; i<=N; i++) {
			visit = new boolean[N+1];
			int count = bfs(i);
			result[i] = count;
			max = Math.max(max, count);
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			if(result[i] == max) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
	}

	private static int bfs(int i) {
		int count = 0;
		Queue<Integer> que = new LinkedList<>();
		que.add(i);
		boolean[] visit = new boolean[N+1];
		visit[i] = true;
		while(!que.isEmpty()) {
			int cur = que.poll();
			for(int child : list[cur]) {
				if(visit[child])
					continue;
				que.add(child);
				visit[child] = true;
				count++;
			}
		}
		
		return count;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++)
			list[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[B].add(A);
		}
		br.close();
	}
}
