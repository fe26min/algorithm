package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2467 {
	
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int answer = 2_000_000_000;
		
		// 최소 최대
		int lidx = 0;
		int ridx = N-1;
		
		int l = 0;
		int r = 0;
		while(lidx < ridx) {
			
			if(Math.abs(answer) > Math.abs(arr[lidx] + arr[ridx])) {
				answer = arr[lidx] + arr[ridx];
				l = arr[lidx];
				r = arr[ridx];
			}
			if(Math.abs(arr[lidx]) < Math.abs(arr[ridx])){
				ridx--;
			}
			else {
				lidx++;
			}
		}
		System.out.println(l + " " + r);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}
