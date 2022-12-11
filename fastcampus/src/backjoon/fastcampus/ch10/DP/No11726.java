package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i=2; i<=n; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 10007;
		}
		System.out.println(arr[n]);
		br.close();
	}
}
