package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No3687 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] minDp = new long[101];
		Arrays.fill(minDp, Long.MAX_VALUE);
		
		minDp[2] = 1;
		minDp[3] = 7;
		minDp[4] = 4;
		minDp[5] = 2;
		minDp[6] = 6;
		minDp[7] = 8;
		minDp[8] = 10;
		
		String[] numToMatch = {"1", "7", "4", "2", "0", "8"};
		
		for(int i=9; i<=100; i++) {
			for(int j=2; j<8; j++) {
				String num = "" + minDp[i-j] + numToMatch[j-2];
				minDp[i] = Math.min(minDp[i], Long.parseLong(num));
			}
		}
		
		String[] maxDp = new String[101];
		maxDp[2] = "1";
		maxDp[3] = "7";
		
		for(int i=4; i<101; i++) {
			maxDp[i] = maxDp[i-2] + "1";
		}
	
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int ti=0; ti<T; ti++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(minDp[N] + " " + maxDp[N] +"\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}
}