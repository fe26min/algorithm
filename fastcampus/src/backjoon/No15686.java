package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15686 {
	// 브루투포스
	
	// 완전 탐색
	
	static int N, M;
	static int arr[][];
	
	public static void main(String[] args) throws IOException {
		input();
		dfs(0);
		
	}

	private static void dfs(int depth) {
		if(depth == M) {
			check();
			return;
		}
		
	}

	private static void check() {
		// TODO Auto-generated method stub
		
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		br.close();
	}
}
