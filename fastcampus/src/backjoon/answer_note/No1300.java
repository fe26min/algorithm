package backjoon.answer_note;

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
		
		int l = 1;
		int r = K;
		
		while(l<r) {
			int mid = (l + r)/2;
			
			int count = 0;
			
			for(int i=1; i<=N; i++) {
				count += Math.min(mid/i, N);
			}
			
			if(count < K) {
				l = mid+1;
			}
			else {
				r = mid;
			}
		}
		System.out.println(l);
	}
}
