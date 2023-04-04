package ThisWeek35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2343 {
	static int N, M, max, sum;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		// 이분 탐색
		int l = max;
		int r = sum;
		while(l <= r) {
			int mid = (l + r)/2;
			int m = check(mid);
//			System.out.println(l + " " + mid + " " + r + " " + m);
			if(m <= M) {
				r = mid - 1;
			}
			else {
				l = mid + 1;
			}
		}
		System.out.println(l);
	}
	
	private static int check(int mid) {
		int count = 0;
		int prev = 0;
		
		for(int i=0; i<N; i++) {
			if(arr[i] - prev > mid) {
				count++;
				prev = arr[i-1];
			}
		}
		if(arr[N-1] != prev)
			count++;
		return count;
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		max = 0;
		sum = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			max = Math.max(num, max);
			sum += num;
			arr[i] = sum;
//			System.out.print(arr[i] + " ");
		}
//		System.out.println();
		br.close();		
	}
}
