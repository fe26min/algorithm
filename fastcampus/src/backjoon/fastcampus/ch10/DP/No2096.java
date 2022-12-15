package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2096 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[5];
		int[] min = new int[5];
		int[] max = new int[5];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		min = arr.clone();
		min[0] = 11 * N;
		min[4] = 11 * N;
		
		max = arr.clone();
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int[] nextMax = new int[5];
			int[] nextMin = new int[5];
			nextMin[0] = 11 * N;
			nextMin[4] = 11 * N;
			
			for(int j=1; j<=3; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				
				int nmax = max[j];
				nmax = Math.max(max[j-1], nmax);
				nmax = Math.max(max[j+1], nmax);
				
				int nmin = min[j];
				nmin = Math.min(min[j-1], nmin);
				nmin = Math.min(min[j+1], nmin);
				
				nextMax[j] = arr[j] + nmax;
				nextMin[j] = arr[j] + nmin;
			}
			max = nextMax.clone();
			min = nextMin.clone();
		}
		int maxNumber = 0;
		for(int i : max) {
			maxNumber = Math.max(i, maxNumber);
		}

		int minNumber = 11 * N;
		for(int i : min) {
			minNumber = Math.min(i, minNumber);
		}
		System.out.println(maxNumber + " " + minNumber);
		br.close();
	}
}
