package backjoon.fastcampus.ch05.TP_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());		
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = -10000000;
		int sum = 0;
		for(int i=0; i<K; i++) {
			sum += arr[i];
		}
		max = Math.max(max, sum);
		
		int s = 0;
		int e = K-1;
		
		while(true) {
			sum -= arr[s];
			s++;
			e++;
			if(e==N) break;
			sum += arr[e];
			
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
		br.close();
	}
}
