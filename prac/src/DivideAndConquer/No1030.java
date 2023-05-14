package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1030 {
	static int s, n, k, r1, r2, c1, c2;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		if(s == 0) {
			System.out.println(0);
			return;
		}
		
		int len = 1;
		for(int i=0; i<s; i++) {
			len *= n;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=r1; i<=r2; i++) {
			for(int j=c1; j<=c2; j++) {
				sb.append(func(len, i, j));
			}sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static int func(int len, int x, int y) {
		if(len == 1) {
			return 0;
		}
		int border = len / n;
		if(x>= border * (n-k) / 2 && x < border * (n + k) / 2
			&& y>= border * (n-k) / 2 && y < border * (n + k) /2) {
			return 1;
		}
		return func(border, x % border, y % border);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		r1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		br.close();		
	}
}
