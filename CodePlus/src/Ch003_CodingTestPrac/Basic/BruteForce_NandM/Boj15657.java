package Ch003_CodingTestPrac.Basic.BruteForce_NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15657 {
	static int N, M;
	static int[] arr, select;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		select = new int[M];
		dfs(0, 0);
		System.out.println(sb);
	}

	private static void dfs( int start, int depth) {
		if(depth == M) {
			for(int i : select) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			select[depth] = arr[i];
			dfs(i, depth + 1);
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		br.close();
	}
}
