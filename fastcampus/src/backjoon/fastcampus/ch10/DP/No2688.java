package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2688 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] arr = new long[65][11];
		Arrays.fill(arr[1], 1);
		
		arr[1][10] = 10;

		for(int i=2; i<=64; i++) {
			long max = 0;
			for(int j=9; j>=0; j--) {
				for(int k=9; k>=j; k--) {
					arr[i][j] += arr[i-1][k];
					max += arr[i-1][k];
				}
			}
			arr[i][10] = max;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(arr[n][10] + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}
