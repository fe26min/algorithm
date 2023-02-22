package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No3020 {
	static int N, H;
	static int[] up, down;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		int min = Integer.MAX_VALUE;
		int cnt = 1;
		
		// 높이에 대해서 찾는다.
		for(int i=1; i<=H; i++) {
			int downCrush = binarySearch(0, N/2-1, i, down);
			int upCrush = binarySearch(0, N/2-1, H-i+1, up);
			
			if(min> downCrush + upCrush) {
				min = downCrush + upCrush;
				cnt = 1;
			}
			else if(min == downCrush + upCrush) {
				cnt++;
			}
		}
		System.out.println(min + " " + cnt);
	}
	
	private static int binarySearch(int left, int right, int height, int[] arr) {
		int min = Integer.MAX_VALUE;
		while(left<=right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] >= height) {
				min = Math.min(min, mid);
				right = mid-1;
			}
			else 
				left = mid+1;
		}
		return min == Integer.MAX_VALUE ? 0: (N/2) - min;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		down = new int[N/2];
		up = new int[N/2];
		int di = 0;
		int ui = 0;
		
		for(int i=0; i<N; i++) {
			if(i%2==0) {
				down[di++] = Integer.parseInt(br.readLine());
			}
			else {
				up[ui++] = Integer.parseInt(br.readLine());
			}
		}
		
		// 정렬을 한다.
		Arrays.sort(up);
		Arrays.sort(down);
		br.close();
	}
}
