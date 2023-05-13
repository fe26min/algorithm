package ThisWeek40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2872 {
	static int N;
	static int[] arr;
	static boolean[] used;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		used = new boolean[N+1];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		int min = N;
		for(int i=N-1; i>=0; i--) {
			if(arr[i] == min) {
				cnt++;
				min--;
			}
		}
		
		System.out.println(N - cnt);
		br.close();
	}
}
