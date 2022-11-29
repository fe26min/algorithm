package backjoon.fastcampus.ch05.TP_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1253 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int count = 0;
		for(int i=0; i<N; i++) {
			if(check(i)) count++;
		}
		System.out.println(count);
		br.close();
	}
	private static boolean check(int i) {
		int s = 0;
		int e = N-1;
		
		while(s<e) {
			if(s==i) s++;
			if(e==i) e--;
			if(s==e) break;
			int sum = arr[s] + arr[e];
			
			if(sum < arr[i]) {
				s++;
			}
			else if(sum > arr[i]) {
				e--;
			}
			else {
//				System.out.println(i + " " + s + " " + e);
				return true;
			}
		}
		return false;
	}
}