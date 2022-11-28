package backjoon.fastcampus.ch04.BS_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No7795_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int ti=0; ti<T; ti++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int A[] = new int[N];
			int B[] = new int[M];

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N ; i++)
				A[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M ; i++)
				B[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(B);
			int count = 0;
			
			for(int i : A) {
				count += check(B, 0, M-1, i);
			}
			System.out.println(count);
		}
		
		br.close();
	}

	private static int check(int[] arr, int l, int r, int target) {
		
		while(l<=r) {
			int mid = (l + r) / 2;
			
			if(arr[mid] < target) {
				l = mid + 1;
			}
			else {
				r = mid - 1;
			}
		}
		System.out.println(target + " " + l);
		return l;
	}
}
