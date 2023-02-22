package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1300 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		br.close();
		
		long l = 1L;
		long r = (long)N * N;
		
		while(l < r) {
			long mid = (l + r) / 2;
			long count = 0;
			
			for(int i=1; i<=N; i++) {
				count += Math.min(mid/i, N);
			}
			
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
