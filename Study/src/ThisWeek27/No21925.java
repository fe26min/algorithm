package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21925 {
	static int N;
	static int[] arr, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(evenPalindrome(0));
		
		br.close();
	}

	private static int evenPalindrome(int start) {
		// 넘어가면 return 0;
		if(start >= N) {
			return 0;
		}
		// dp 값이 0이 아니라면 이미 탐색한 곳이다.
		if(dp[start] != 0)
			return dp[start];
		
		// 결과값
		int result = -1;
		
		// 팰린드롬인지 확인하기
		for(int i=start + 1; i<N; i+=2) {
			boolean isPal = true;
			
			for(int j=0; j<=(i-start)/2; j++) {
				
				if(arr[start+j] != arr[i-j]) {
					isPal = false;
					break;
				}
			}
			
			if(isPal) {
				int value = evenPalindrome(i+1);
				if(value == -1)
					continue;
				result = Math.max(result, value + 1);
			}
		}
		return dp[start] = result;
	}
}
