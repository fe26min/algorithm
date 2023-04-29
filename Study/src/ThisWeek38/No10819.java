package ThisWeek38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10819 {
	static int N, max = 0;
	static int[] arr, select; 
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		dfs(0);
		System.out.println(max);
	}
	private static void dfs(int depth) {
		if(depth == N) {
			max = Math.max(max, check());
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
	private static int check() {
		int sum  = 0;
		
		for(int i=0; i<N-1; i++)
			sum += Math.abs(select[i] - select[i+1]);
		
		return sum;
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		select = new int[N];
		visit = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}
