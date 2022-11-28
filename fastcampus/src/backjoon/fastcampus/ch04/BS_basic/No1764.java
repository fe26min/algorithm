package backjoon.fastcampus.ch04.BS_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1764 {
	// 1차 풀이는 이분 탐색으로
	// 2차 풀이는 hashSet으로 한번 해보기
	
	static int N, M;
	static String[] A, B;
	public static void main(String[] args) throws IOException {
		input();
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for(String s : A) {
			if(check(s)) {
				count++;
				sb.append(s + "\n");
			}
		}
		System.out.println(count);
		System.out.println(sb);
		
	}
	// 이분 탐색
	private static boolean check(String s) {
		
		int l = 0;
		int r = M-1;
		
		while(l<=r) {
			int mid = (l + r) /2;
//			System.out.println(s + " " + B[mid] + " " + B[mid].compareTo(s));
			if(B[mid].compareTo(s) < 0) {
				l = mid + 1;
			}
			else if(B[mid].compareTo(s) > 0 ) {
				r = mid - 1;
			}
			else 
				return true;
		}
		return false;
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new String[N];
		B = new String[M];
		
		for(int i=0; i<N; i++) {
			A[i] = br.readLine();
		}
		
		for(int i=0; i<M; i++) {
			B[i] = br.readLine();
		}
		Arrays.sort(A);
		Arrays.sort(B);
		br.close();
	}
}
