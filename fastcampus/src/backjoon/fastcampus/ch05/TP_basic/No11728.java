package backjoon.fastcampus.ch05.TP_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11728 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		int[] B = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sa = 0;
		int sb = 0;
		int idx = 0;

		StringBuilder sbuilder = new StringBuilder();
		
		while(sa<N && sb<M) {
			if(A[sa]<B[sb]) {
				sbuilder.append(A[sa++] + " ");
			}
			else
				sbuilder.append(B[sb++] + " ");
		}
		
		if(sa==N) {
			for(int i=sb; i<M; i++) {
				sbuilder.append(B[i] + " ");
			}
		}
		else {
			for(int i=sa; i<N; i++) {
				sbuilder.append(A[i] + " ");
			}
		}
		System.out.println(sbuilder);
		br.close();
	}
}
