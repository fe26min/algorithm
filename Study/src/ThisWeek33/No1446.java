package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1446 {
	static int N, D;
	static int[] dp;
	static PriorityQueue<Path> paths;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		for(int i=0; i<D; i++) {
			while(!paths.isEmpty() && paths.peek().s == i) {
				Path p = paths.poll();
//				System.out.println(p.s + " " + p.d + " " + p.c);
				dp[p.d] = Math.min(dp[p.d], dp[i] + p.c);
			}
			dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
		}
//		
//		for(int i=0; i<=D; i++) {
//			System.out.print(i + " ");
//		}System.out.println();
//		
//		for(int i=0; i<=D; i++) {
//			System.out.print(dp[i] + " ");
//		}System.out.println();
//		
		System.out.println(dp[D]);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		dp = new int[D + 1];
		
		for(int i=0; i<=D; i++)
			dp[i] = i;
		
		paths = new PriorityQueue();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(d > D || (d-s) <= c)
				continue;
			paths.add(new Path(s, d, c));
		}
		br.close();
	}
}

class Path implements Comparable<Path>{
	int s, d, c;
	public Path(int s, int d, int c) {
		this.s = s;
		this.d = d;
		this.c = c;
	}
	@Override
	public int compareTo(Path o) {
		if(this.s == o.s) {
			return this.d - o.d;
		}
		return this.s - o.s;
	}
}
