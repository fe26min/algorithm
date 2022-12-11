package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] score = new int[N+1];
		int[][] sumScore = new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			int sc = Integer.parseInt(br.readLine());
			
			score[i] = sc;
		}
		
		sumScore[1][0] = score[1];
		sumScore[1][1] = score[1];
		
		for(int i=2; i<=N; i++) {
			sumScore[i][0] = sumScore[i-1][1] + score[i];
			sumScore[i][1] = Math.max(sumScore[i-2][0], sumScore[i-2][1]) + score[i];
		}
		
		System.out.println(Math.max(sumScore[N][0], sumScore[N][1]));
		
		br.close();
	}
}
