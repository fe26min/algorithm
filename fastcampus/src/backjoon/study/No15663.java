package backjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class No15663 {
	
	static int N, M;
	static int arr[];
	static int checked[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	static LinkedHashSet<String> lhs = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException {
		input();
		dfs(0);
		
		for(String i : lhs) {
			sb.append(i+"\n");
		}
		
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if(depth == M) {
			check();
			return;
		}
		for(int i=0; i<N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			checked[depth] = i;
			dfs(depth+1);
			visit[i] = false;
		}
	}

	private static void check() {
		String line = "";
		for(int i : checked) {
			line += (arr[i] + " ");
		}
		lhs.add(line);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new boolean[N];
		checked = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		br.close();
	}
}
