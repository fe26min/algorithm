package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int [][] mat = new int[N][3];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<3; i++) {
			mat[0][i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			mat[i][0] = Math.min(mat[i-1][1], mat[i-1][2]) + num;
			
			num = Integer.parseInt(st.nextToken());
			mat[i][1] = Math.min(mat[i-1][0], mat[i-1][2]) + num;
			
			num = Integer.parseInt(st.nextToken());
			mat[i][2] = Math.min(mat[i-1][0], mat[i-1][1]) + num;
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			min = Math.min(mat[N-1][i], min);
		}
		System.out.println(min);
		br.close();
	}
}
