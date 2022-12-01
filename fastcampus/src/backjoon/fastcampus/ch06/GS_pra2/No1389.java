package backjoon.fastcampus.ch06.GS_pra2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1389 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int mat[][] = new int[N][N];
		
		for(int i=0; i<N; i++)
			Arrays.fill(mat[i], N+1);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			int c2 = Integer.parseInt(st.nextToken()) - 1;
			
			mat[c1][c2] = 1;
			mat[c2][c1] = 1;
		}

		for(int k=0; k<N; k++) {
			for(int s=0; s<N; s++) {
				for(int e=0; e<N; e++) {
					if(mat[s][k] + mat[k][e] < mat[s][e]) {
						mat[s][e] = mat[s][k] + mat[k][e];
					}
				}
			}
		}
		int minCount = 10000;
		int minidx = -1;
		
		for(int i=0; i<N; i++) {
			int count=0;
			for(int j=0; j<N; j++) {
				count+= mat[i][j];
			}
			if(minCount > count) {
				minCount = count;
				minidx = i;
			}
		}
		System.out.println(minidx + 1);
		br.close();
	}
}
