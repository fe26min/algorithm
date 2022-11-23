package backjoon.fastcampus.ch02.ES_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1182 {
	
	
	static int N, S, count;
	static int arr[];
	public static void main(String[] args) throws IOException {
		input();
		count = 0;
		dfs(0, 0, 0);
		System.out.println(count);
	}
	
	private static void dfs(int depth, int start, int sum) {
		if(depth>N) return;
		if(depth !=0 && sum == S)
			count++;
		
		for(int i=start; i<N; i++) {
			dfs(depth+1, i+1, sum + arr[i]);
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}
