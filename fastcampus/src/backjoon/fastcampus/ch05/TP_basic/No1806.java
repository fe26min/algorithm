package backjoon.fastcampus.ch05.TP_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());

		int s=0;
		int e=0;
		int sum = arr[s];
		int len = N+1;
		
		while(true) {
			if(sum < S) {
				e++;
				if(e==N) break;
				sum += arr[e];
			}
			else if(sum >= S) {
				len = Math.min(len, e-s+1);
				sum -= arr[s];
				s++;
			}
		}
		if(len == N+1) len = 0;
		
		System.out.println(len);
		
		br.close();
	}
}
