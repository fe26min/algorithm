package unsolvee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1030 {
	static int s, N, K, R1, R2, C1, C2;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		if(s == 0) {
			System.out.println(0);
			return;
		}
		StringBuilder sb= new StringBuilder();
		
		int len = 1;
		for(int i=0; i<s; i++) {
			len *= N;
		}
		
		for(int i=R1; i<=R2; i++) {
			for(int j=C1; j<=C2; j++) {
				sb.append(func(len, i, j));
			}sb.append("\n");
		}
		
		
		System.out.println(sb.toString());
	}
	private static int func(int len, int x, int y) {
		if(len == 1) {
			return 0;
		}
		int border = len / N;
		
		if(x>= (N-K) / 2 * border && x< (N+K)/2 * border
				&& y>= (N-K) / 2 * border && y< (N+K)/2 * border)
			return 1;
		
		return func(border, x%border, y%border);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R1 = Integer.parseInt(st.nextToken());
		R2 = Integer.parseInt(st.nextToken());
		C1 = Integer.parseInt(st.nextToken());
		C2 = Integer.parseInt(st.nextToken());
		
		br.close();
	}
}
