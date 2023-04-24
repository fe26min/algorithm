package ThisWeek36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No8980 {
	static int N, M, C;
	static int[] mat;
	static Node8980[] list;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		Arrays.sort(list);
		
		int ans = 0;
		for(int i=0; i<M; i++) {
			Node8980 cur = list[i];
			
			int max = Integer.MAX_VALUE;
			
			for(int j=cur.s; j<cur.e; j++) {
				max = Math.min(max, mat[j]);
			}
			
			if(max >= cur.w) {
				for(int j=cur.s; j<cur.e; j++) {
					mat[j] -= cur.w;
				}
				ans += cur.w;
			} else {
				for(int j=cur.s; j<cur.e; j++) {
					mat[j] -= max;
				}
				ans += max;
			}
		}
		System.out.println(ans);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		mat = new int[N + 1];
		
		for(int i=1; i<=N; i++)
			mat[i] = C;
		
		M = Integer.parseInt(br.readLine());
		list = new Node8980[M];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[i] = new Node8980(s, e, w);
		}
		br.close();
	}
}

class Node8980 implements Comparable<Node8980> {
	int s, e, w;
	public Node8980(int s, int e, int w) {
		this.s = s;
		this.e = e;
		this.w = w;
	}
	
	@Override
	public int compareTo(Node8980 o) {
		if(this.e == o.e)
			return this.s - o.s;
		return this.e - o.e;
	}
}