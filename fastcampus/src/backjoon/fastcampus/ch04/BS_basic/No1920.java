package backjoon.fastcampus.ch04.BS_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1920 {
	
	static int N, M;
	static int[] A, B;
	
	// 기본적인 이분탐색
	public static void main(String[] args) throws IOException {
		input();
		
		for(int i : B) {
			System.out.println(find(i));
		}
	}


	private static int find(int target) {
		int l = 0;
		int r = N-1;
		
		while(l <= r) {
			int mid = (l+r)/2;
			
			if(A[mid] > target) {
				r = mid-1;
			}
			else if(A[mid] < target) {
				l = mid+1;
			}
			else {
				l = mid;
				r = mid;
				break;
			}
		}
//		System.out.println(target + " " + l + " " + r);
		if(l == r)
			return 1;
		return 0;
		
	}


	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		M = Integer.parseInt(br.readLine());
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}
