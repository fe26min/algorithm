package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] zeroArr = new int[41];
		int[] oneArr = new int[41];
		
		zeroArr[0] = 1;
		oneArr[1] = 1;
		
		for(int i=2; i<=40; i++) {
			zeroArr[i] = zeroArr[i-1] + zeroArr[i-2];
			oneArr[i] = oneArr[i-1] + oneArr[i-2];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(zeroArr[N] + " " + oneArr[N] + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}
