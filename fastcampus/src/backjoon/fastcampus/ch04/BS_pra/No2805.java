package backjoon.fastcampus.ch04.BS_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2805 {
	static int N, M, max = 0;
	static int arr[];
	public static void main(String[] args) throws IOException {
		input();
		int l = 0;
		int r = max;
		
		while(l<=r) {
			int mid = (l + r) / 2;
			
			long result = check(mid);
			
			if(result < M) {
				r= mid - 1;
			}
			else if(result > M) {
				l= mid + 1;
			}
			else {
				l = mid;
				r = mid;
				break;
			}
		}
		System.out.println(r);
	}

	private static long check(int idx) {
		long sum = 0;
		for(int i: arr) {
			sum += i > idx ? i-idx : 0;
		}
		return sum;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}
		br.close();		
	}
}
