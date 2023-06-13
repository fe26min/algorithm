package ThisWeek45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class No19699 {
	static int N, M;
	static int[] H;
	static boolean[] isPrime;
	static TreeSet<Integer> set;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		Arrays.sort(H);
		
		eratores();
		
		
		set = new TreeSet();
		dfs(0, 0, 0);

		StringBuffer sb = new StringBuffer();
		for(int i : set) {
			sb.append(i + " ");
		}
		if(sb.length()==0)
			sb.append("-1");
		System.out.println(sb.toString());
	}
	private static void dfs(int depth, int sum, int start) {
		if(depth == M) {
			if(isPrime[sum])
				set.add(sum);
			return;
		}
		
		for(int i=start; i<N; i++) {
			dfs(depth + 1, sum + H[i], i+1);
		}
	}
	private static void eratores() {
		isPrime = new boolean[9001];
		boolean[] visit = new boolean[9001];
		
		for(int i=2; i<9001; i++) {
			if(!visit[i] && !isPrime[i]) {
				isPrime[i] = true;
				for(int j=i; j<9001; j+=i) {
					visit[j] = true;
				}
			}
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		H = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			H[i] = Integer.parseInt(st.nextToken());
		}
		br.close();		
	}
}
