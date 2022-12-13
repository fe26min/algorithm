package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15990 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] arr = new long[100_001][4];
		
		arr[1][1] = 1;
		arr[2][2] = 1;
		arr[3][3] = 1;
		
		for(int i=3; i<=100_000; i++) {
			arr[i][1] = (arr[i][1] + (arr[i-1][2] + arr[i-1][3]) % 1_000_000_009) % 1_000_000_009;
			arr[i][2] = (arr[i][2] + (arr[i-2][1] + arr[i-2][3]) % 1_000_000_009) % 1_000_000_009;
			arr[i][3] = (arr[i][3] + (arr[i-3][1] + arr[i-3][2]) % 1_000_000_009) % 1_000_000_009;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(arr[num][1] + arr[num][2] + arr[num][3] % 1_000_000_009);
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
