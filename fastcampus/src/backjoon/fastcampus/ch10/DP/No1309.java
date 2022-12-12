package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1309 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[4];
		Arrays.fill(arr, 1);
		
		arr[3] = 3;
		
		for(int i=1; i<N; i++) {
			int[] temp = new int[4];
			
			int max = 0;
			
			temp[0] = (arr[1] + arr[2]) % 9901;
			max = (max + temp[0]) % 9901;
			temp[1] = (arr[0] + arr[2]) % 9901;
			max = (max + temp[1]) % 9901;
			temp[2] = arr[3];
			max = (max + temp[2]) % 9901;
			temp[3] = max;
			arr = temp.clone();
			
//			for(int j : temp) {
//				System.out.print(j + " ");
//			}System.out.println();
		}
		System.out.println(arr[3]);
		br.close();
	}
}
