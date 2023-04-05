package ThisWeek35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1561 {
	static int N, M, max;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		if(N <= M) {
			System.out.println(N);
			return;
		}
		
		long time = bsearch();
//		System.out.println(time);
		long cnt = M;
		
		for(int i : arr)
			cnt += (time-1)/i;
		
		for(int i=0; i<M; i++) {
			if(time % arr[i]==0) {
				cnt++;
				if(cnt == N) {
					System.out.println(i + 1);
					return;
				}
			}
		}
	}
	private static long bsearch() {
		long L = 0L;
		long R = (long)max * N;
		long result = -1;
		while(L <= R) {
			long mid = (L + R) / 2;
			long child = 0;
			
			for(int i : arr) {
				child += mid / i;
			    child += 1;
            }
			
			if(child >= N) {
				result = mid;
				R = mid - 1;
			}
			else {
				L = mid + 1;
			}
		}
		return result;
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}
		
		br.close();		
	}
}