package backjoon.fastcampus.ch05.TP_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11728 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int A[] = new int[N];
		int B[] = new int[M];		
		int C[] = new int[N + M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int sa=0;
		int sb=0;
		
		while(sa + sb < N+M) {
			if(arr[sa] < arr[sb]) {
				sa++;
				arr[]
			}
		}
		
		br.close();
	}
}
