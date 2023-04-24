package ThisWeek36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13305 {
	static int N;
	static int[] dist;
	static int[] cost;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		long sum = 0L;
		
		for(int i=0; i<N; i++) {
			sum += (long) dist[i] * cost[i];
		}
		System.out.println(sum);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dist = new int[N];
		cost = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int min = 1_000_000_000;
		for(int i=0; i<N; i++) {
			int oil = Integer.parseInt(st.nextToken());
			min = Math.min(min, oil);
			cost[i] = min;
		}
		
		br.close();		
	}
}
