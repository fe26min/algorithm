package Ch003_CodingTestPrac.Basic.BruteForce_NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15654 {
	static int N, M;
	static int[] arr, select;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		select = new int[M];
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if(depth == M) {
			for(int i : select) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visit[i])
				continue;
			visit[i] = true;
			select[depth] = arr[i];
			dfs(depth + 1);
			visit[i] = false;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		br.close();
	}
}
