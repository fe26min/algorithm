package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2166 {
	// https://ko.wikipedia.org/wiki/%EC%8B%A0%EB%B0%9C%EB%81%88_%EA%B3%B5%EC%8B%9D\

	static int N;
	static long[][] points;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		//  1/2 * Math.abs( (시그마(i=1 -> N-1) X(i)y(i+1)) + X(n)Y(1) - (시그마(i=1 -> N-1) X(i+1)Y(i) -X(1)Y(n));
		long answer = 0L;
		for(int i=0; i<N-1; i++) {
			answer += points[i][0] * points[i+1][1];
			answer -= points[i+1][0] * points[i][1];
		}
		// N 0
		answer += points[N-1][0] * points[0][1];
		answer -= points[0][0] * points[N-1][1];
		System.out.println(String.format("%.1f", (Math.abs(answer) / 2.0)));
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		points = new long[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Long.parseLong(st.nextToken());
			points[i][1] = Long.parseLong(st.nextToken());
		}
		br.close();
	}
}
