package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int ti=0; ti<T; ti++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N+1][4];
			int[][] score = new int[N+1][2];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				score[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				score[i][1] = Integer.parseInt(st.nextToken());
			}
			
			arr[1][0] = score[1][0];
			arr[1][1] = score[1][1];
			arr[1][3] = Math.max(arr[1][0], arr[1][1]);
			
			for(int i=2; i<=N; i++) {
				int max = 0;
				arr[i][0] = Math.max(arr[i-1][1], arr[i-1][2]) + score[i][0];
				max = Math.max(max, arr[i][0]);
				arr[i][1] = Math.max(arr[i-1][0], arr[i-1][2]) + score[i][1];
				max = Math.max(max, arr[i][1]);
				arr[i][2] = arr[i-1][3];
				max = Math.max(max, arr[i][2]);
				arr[i][3] = max;
			}
//			for(int i=1; i<=N; i++) {
//				System.out.print(arr[i][0] + " ");
//			}System.out.println();
//			for(int i=1; i<=N; i++) {
//				System.out.print(arr[i][1] + " ");
//			}System.out.println();
//			for(int i=1; i<=N; i++) {
//				System.out.print(arr[i][2] + " ");
//			}System.out.println();
//			for(int i=1; i<=N; i++) {
//				System.out.print(arr[i][3] + " ");
//			}System.out.println();
			sb.append(arr[N][3]+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
