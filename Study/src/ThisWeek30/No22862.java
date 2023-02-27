package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No22862 {
	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();

	}

	private static void pro() {
		// 연속하는 부분 수열의 가장 긴 길이
		int max = 0;

		int s = 0;
		int e = 0;
		// 지운 홀수의 갯수
		int k = arr[s] % 2;
		
		while (true) {
			// 끝에 달할 때까지
			while (e < N - 1) {
				if(arr[e + 1] % 2 == 1) {
					if(k < K) k++;
					else break;
				}
				e++;
			}
			if(s>=N || e >= N) break;
			max = Math.max(max, e-s+1-k);
			
			if(arr[s]%2==1)
				k--;
			s++;
		}
		System.out.println(max);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}
