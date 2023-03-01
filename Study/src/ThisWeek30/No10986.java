package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10986 {
	static int N, M;
	static int[] arr, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cnt = new int[M];
		
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			sum += Integer.parseInt(st.nextToken()) % M;
			cnt[(sum % M)]++;
		}

		long ans = cnt[0];
		for(int i=0; i<M; i++) {
			ans += (long)cnt[i] * (cnt[i] - 1) /2;
		}
		
		System.out.println(ans);
		br.close();
	}
}
