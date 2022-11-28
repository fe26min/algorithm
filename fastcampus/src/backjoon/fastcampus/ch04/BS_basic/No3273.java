package backjoon.fastcampus.ch04.BS_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No3273 {
	
	static int n, x;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		x = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for(int i=0; i<n; i++) {
			if(arr[i]> x/2) break;
			if(check(x-arr[i], i))
				count++;
		}
		
		System.out.println(count);
		
		br.close();
	}

	private static boolean check(int target, int num) {
		int l=0;
		int r=n-1;
		
		while(l <= r) {
			int mid = (l + r) / 2;
			
			if(arr[mid] < target) {
				l = mid + 1;
			}
			else if(arr[mid] > target) {
				r = mid - 1;
			}
			else {
				if(mid == num) return false;
				return true;
			}
		}
		
		return false;
	}
}
