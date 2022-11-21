package backjoon.fastcampus.ch02.완탐_기본;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복있는 N과 M
// dfs로 뽑기
public class No15651 {
	
	static int N, M;
	static int selected[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		dfs(1,0);
		System.out.println(sb);
		br.close();
	}
	private static void dfs(int start, int depth) {
		if(depth == M) {
			for(int i : selected) {
				sb.append(i).append(" ");
			}sb.append("\n");
			return;
		}
		for(int i=1; i<=N; i++) {
			selected[depth]=i;
			dfs(i, depth+1);
		}
	}
}
