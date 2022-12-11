package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=2; i<=N; i++) {
			
			for(int j=1; j<=N/2; j++) {
				if(i > j) {
					arr[i] = Math.max(arr[i], arr[i-j] + arr[j]);
				}
			}
		}
		
		System.out.println(arr[N]);
		br.close();
	}
}
