package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1052 {
	static int N, K;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int answer = 0;
		while(Integer.bitCount(N) > K) {
			N++;
			answer++;
		}
		System.out.println(answer);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		br.close();
	}
}
