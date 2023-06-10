package ThisWeek42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2118 {
	static int N, sum;
	static int[] dist, sum1, sum2;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
        int s=0;
        int e=0;

        int ans=0;

        int now=dist[s];

		while (s <= e && e < N) {
			int minNow = Integer.min(now, sum - now);
			ans = Integer.max(ans, minNow);
			if (now == minNow) {
				e++;
				now += dist[e];
			} else {
				now -= dist[s];
				s++;
			}
		}
		System.out.println(ans);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dist = new int[N + 1];
		sum = 0;
		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.parseInt(br.readLine());
			sum += dist[i];
		}
		br.close();
	}
}
