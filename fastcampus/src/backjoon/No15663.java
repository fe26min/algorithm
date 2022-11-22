package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No15663 {
	
	static int N, M;
	static int arr[];
	static int checked[];
	static HashSet<String> hs;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		input();
		
		dfs(0);
		
		Object[] answer= hs.toArray();
		Arrays.sort(answer);
		
		for(Object i : answer) {
			sb.append(((String)i).trim() +"\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if(depth == M) {
			check();
			return;
		}
		
		for(int i=0; i<N; i++) {
			checked[depth]= arr[i];
			dfs(depth+1);
		}
	}

	private static void check() {
		String a = "";
		
		for(int i : checked) {
			a += i;
			a += " ";
		}
		
		hs.add(a);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		hs = new HashSet<>();
		arr = new int[N];
		checked = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		br.close();
	}
}
