package backjoon.fastcampus.ch04.BS_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2110 {
	
	static int N, C, max=0;
	static int home[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		home = new int[N];
		max = 0;
		for(int i=0; i<N; i++) {
			home[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, home[i]);
		}
		Arrays.sort(home);

		int l = 1;
		int r = max - home[0];
		
		while(l<=r) {
//			System.out.println(l + " " + r);
			// 길이
			int mid = (l + r) / 2;
			int result = check(mid);
			
			if(result < C)
				r = mid-1;
			else
				l = mid+1;
		}
//		System.out.println(l +" " + r + " " + check(l) + " " + check(r));
		System.out.println(r);
		br.close();
	}
	
	private static int check(int mid) {
		int count = 1;
		
		// 0번째 부터 시작
		int idx = 0;
//		System.out.print(mid + " : ");
		while(idx < N) {
			int next = home[idx] + mid;
//			System.out.print("(" + idx + " " + next + ") ");
			if(next > max) break;
			idx = find(next);
			count++;
		}
//		System.out.println(count);
		return count;
	}
	
	// 포함되는 idx구하기 만약 없다면 가장 가까운 큰 수
	private static int find(int target) {
		int l=0;
		int r=N-1;
		
		while(l<=r) {
			int mid = (l+r)/2;
			if(home[mid] < target) {
				l = mid+1;
			}
			else 
				r = mid-1;
		}
//		System.out.println(target + " " + l + " " + r);
		return l;
	}
}
