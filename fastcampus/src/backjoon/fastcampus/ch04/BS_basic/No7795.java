package backjoon.fastcampus.ch04.BS_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No7795 {
	
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int a[] = new int[N + 1];
			int b[] = new int[M + 1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++)
				a[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++)
				b[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(b, 1, M+1);
			
			int ans = 0;
			for(int i=1; i<=N; i++) {
				ans += solution(b, 1, M, a[i]);
			}
			System.out.println(ans);
		}
		br.close();
	}
	private static int solution(int[] arr, int l, int r, int target) {
		int res = l - 1;
		
		while(l <= r) {
			int mid = (l + r) /2;
			if( arr[mid] < target) {
				res = mid;
				l = mid + 1;
			}
			else  {
				r = mid - 1;
			}
		}
		return res;
	}
}