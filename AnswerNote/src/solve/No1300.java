package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1300
public class No1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		br.close();
		
		long l = 1;
		long r = (long)N * N;
		
		while(l < r) {
			long mid = (l + r) / 2;
			long count = 0;
			
			for(int i=1; i<=N; i++) {
				count += Math.min(mid/i, N);
			}
//			System.out.println(mid + " " + l + " " + r + " " + count);
			if(count < K) {
				l = mid + 1;
			}
			else {
				r = mid;
			}
		}
		System.out.println(l);
	}
}
