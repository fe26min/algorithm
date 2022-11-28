package backjoon.fastcampus.ch05.TP_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15565 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num == 1 ? 1 : 0;
		}
		
		int count = 0;
		if(arr[0] == 1) count++;
		int s = 0;
		int e = 0;
		int min = N+1;
		
		while(true) {
			if(count < K) {
				e++;
				if(e==N) break;
				count+=arr[e];
			}
			else if(count == K) {
				min = Math.min(min, e-s+1);
				count-=arr[s];
				s++;
			}
		}
		if(min == N+1) min = -1;
		System.out.println(min);
		br.close();
	}
}
