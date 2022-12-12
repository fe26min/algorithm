package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No11057 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[11];
		Arrays.fill(arr, 1);
		
		arr[10] = 10;
		
		for(int n=1; n<N; n++) {
			int[] temp = new int[11];
			int max = 0;
			for(int i=9; i>=0; i--) {
				for(int j=9; j>=i; j--) {
					temp[i] = (temp[i] + arr[j]) % 10007;
					max = (max + arr[j]) % 10007;
				}
			}
			temp[10] = max;
			arr = temp.clone();
		}
		System.out.println(arr[10]);
		br.close();
	}
}
