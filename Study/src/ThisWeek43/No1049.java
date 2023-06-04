package ThisWeek43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1049 {
	static int N, min6, min1;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int cost = 0;
		
		// 낱개로만 사는 경우
		cost = N * min1;
		
		// 세트 + 낱개
		cost = Math.min(cost, (N/6) * min6 + (N%6) * min1);
		
		// 세트로만 구매
		cost = Math.min(cost, (N/6 + 1) * min6);
		System.out.println(cost);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		min6 = 1001;
		min1 = 1001;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int cost6 = Integer.parseInt(st.nextToken());
			int cost1 = Integer.parseInt(st.nextToken());
			min6 = Integer.min(min6, cost6);
			min1 = Integer.min(min1, cost1);
		}
		
		br.close();
	}
}
