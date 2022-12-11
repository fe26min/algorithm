package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		int N = line.length();

		int[] arr = new int[N];

		if (line.charAt(0) != '0')
			arr[0] = 1;
		if (N > 1) {
			if (line.charAt(1) != '0')
				arr[1] = 1;
			if (Integer.parseInt((line.substring(0, 2))) <= 26) {
				arr[1] += arr[0];
			}
		}

		for (int i = 2; i < N; i++) {
			if(line.charAt(i-1)==0 && line.charAt(i)==0) {
				arr[N-1] = 0;
				break;
			}
			
			if (line.charAt(i) != '0') {
				arr[i] += arr[i - 1];
				arr[i] %= 1000000;
			}
			if(line.charAt(i-1)=='0')
				continue;
			
			if (Integer.parseInt((line.substring(i - 1, i + 1))) <= 26) {
				arr[i] += arr[i - 2];
				arr[i] %= 1000000;
			}
		}
		System.out.println(arr[N - 1]);
		br.close();
	}
}
