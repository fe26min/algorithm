package backjoon.fastcampus.ch02.완탐_기본;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 언제 시작했는지를 기록 할것
// 중복 가능
public class No15650 {
	static int N, M;
	static int arr[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		sb = new StringBuilder();
		
		dfs(0, 1);
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int depth, int start) {
		if(depth == M) {
			for(int i: arr) {
				sb.append(i + " ");
			}sb.append("\n");
			return;
		}
		
		for(int i=start; i<=N; i++) {
			arr[depth]=i;
			dfs(depth+1, i+1);
		}
	}
}
