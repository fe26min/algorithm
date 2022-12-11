package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] amount = new int[N+1][4];
		
		int max = 0;
		
		amount[1][1] = Integer.parseInt(br.readLine());
		amount[1][3] = amount[1][1];
		
		for(int i=2; i<=N; i++) {
			max = 0;
			int num = Integer.parseInt(br.readLine());
			amount[i][0] = amount[i-1][1] + num;
			max = Math.max(amount[i][0], max);
			amount[i][1] = amount[i-2][3] + num;
			max = Math.max(amount[i][1], max);
			amount[i][2] = amount[i-1][3];
			max = Math.max(amount[i][2], max);
			amount[i][3] = max;
		}
//		for(int i=1; i<=N; i++) {
//			System.out.print(amount[i][0] + " ");
//		}System.out.println();
//		for(int i=1; i<=N; i++) {
//			System.out.print(amount[i][1] + " ");
//		}System.out.println();
//		for(int i=1; i<=N; i++) {
//			System.out.print(amount[i][2] + " ");
//		}System.out.println();
//		for(int i=1; i<=N; i++) {
//			System.out.print(amount[i][3] + " ");
//		}System.out.println();
		System.out.println(amount[N][3]);
		br.close();
	}
}
