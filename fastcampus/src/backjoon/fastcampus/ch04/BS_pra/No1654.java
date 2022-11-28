package backjoon.fastcampus.ch04.BS_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1654 {
	
	static int K, N;
	static long arr[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		long max = 0;
		arr = new long[K];
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		long l = 0L;
		long r = max;
		
		while(l <= r) {
			long mid = (l + r) / 2;
			long result = check(mid);
//			System.out.println(mid + " " + result);
			if(result >= N)
				l = mid + 1;
			else
				r = mid - 1;
		}
		System.out.println(r);
		br.close();
	}
	private static long check(long mid) {
		if(mid==0) return 1000001L;
		long count=0;
		for(long i : arr) {
			count += i/mid;
		}
		return count;
	}
}
