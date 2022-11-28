package backjoon.fastcampus.ch04.BS_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int min = 0, max = 0;
		int best = 2000000000;
		int sum = 2000000000;
		int l = 0;
		int r = N-1;
		
		while(l<r) {
			
			sum = arr[l] + arr[r];
			if(Math.abs(best) > Math.abs(sum)) {
				best = sum;
				min = arr[l];
				max = arr[r];
			}
			if(sum <0) {
				l++;
			}
			else if(sum > 0) {
				r--;
			}
			else
				break;
		}
		System.out.println(min + " " + max);
		br.close();
	}
}
