package ThisWeek31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2805 {
	static int N, M, max;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int left = 0;
		int right = max;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			long height = func(mid);
			if(height < M) {
				right = mid - 1;
			}
			else if(height > M) {
				left = mid + 1;
			}
			else {
				left = mid;
				right = mid;
				break;
			}
		}
		System.out.println(right);
	}
	private static long func(int mid) {
		long sum = 0;
		
		for(int i : arr) {
			sum += i < mid ? 0 : i - mid;
		}
		
		return sum;
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 0;
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max= Math.max(max, arr[i]);
		}
		
		br.close();
	}
}
