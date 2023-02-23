package ThisWeek29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6236 {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int max = 0;
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		br.close();
		
		int left = max;
		int right = 10000 * 100000;
		int result = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			int cnt = 1;
			int money = mid;
			
			for(int i : arr) {
				if(money < i) {
					money = mid;
					cnt++;
				}
				money -= i;
			}
			
			if(cnt <= M) {
				result = mid;
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		System.out.println(result);
	}
}
