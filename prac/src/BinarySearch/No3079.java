package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3079 {
	static int N, M, max;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		long left = 0L;
		long right = max * 1000000000L;
		
		long ans = 0L;
		while(left <= right) {
			long mid = (left + right) / 2L;
			long cnt = 0L;
			
			for(int i : arr) {
				cnt += mid / i;
			}
			
			if(cnt < M) {
				left = mid + 1;
			}
			else if(cnt >= M) {
				ans = mid;
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}	
		br.close();
	}
}
