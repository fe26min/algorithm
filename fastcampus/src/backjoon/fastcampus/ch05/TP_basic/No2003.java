package backjoon.fastcampus.ch05.TP_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = 0;
		int sum = arr[s];
		int count = 0;
		
		while(true) {
			if(sum < M) {
				e++;
				if(e==N) break;
				sum += arr[e];
			}
			else if(sum >= M) {
				if(sum==M)count++;
				sum -= arr[s];
				s++;
			}
		}
		System.out.println(count);
		
		br.close();
	}
}
