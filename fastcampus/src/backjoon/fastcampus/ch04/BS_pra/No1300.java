package backjoon.fastcampus.ch04.BS_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1300 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		long l = 1;
		long r = N*N;
		
		while(l < r) {
			long mid = (l + r)/2;
			long count = 0;
			
			for(int i=1; i<=N; i++) {
				count += Math.min(mid/i, N);
			}

			if(K <= count) {
				r = mid;
			}
			else {
				l = mid +1;
			}
		}
		System.out.println(l);
		br.close();
	}
}