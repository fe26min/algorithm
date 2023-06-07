package ThisWeek44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2138 {
	static int N, answer = Integer.MAX_VALUE;
	static char[] now, expect;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		boolean[] arr_1 = new boolean[N];
		boolean[] arr_2 = new boolean[N];
		boolean[] expect_arr = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr_1[i] = now[i] == '1';
			arr_2[i] = now[i] == '1';
			expect_arr[i] = expect[i] == '1';
		}
		arr_1[0] = !arr_1[0];
		arr_1[1] = !arr_1[1];
		
		int ans1 = 1;
		int ans2 = 0;
		for(int i=1; i<N; i++) {
			if(arr_1[i-1] != expect_arr[i-1]) {
				arr_1[i-1] = !arr_1[i-1];
				arr_1[i] = !arr_1[i];
				ans1++;
				if(i != N-1)
					arr_1[i+1] = !arr_1[i+1];
			}
			if(arr_2[i-1] != expect_arr[i-1]) {
				arr_2[i-1] = !arr_2[i-1];
				arr_2[i] = !arr_2[i];
				ans2++;
				if(i != N-1)
					arr_2[i+1] = !arr_2[i+1];
			}
		}
		if(arr_1[N-1] != expect_arr[N-1]) ans1 = Integer.MAX_VALUE;
		if(arr_2[N-1] != expect_arr[N-1]) ans2 = Integer.MAX_VALUE;
	
		if(ans1 == Integer.MAX_VALUE && ans2 == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(Math.min(ans1, ans2));
	}


	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		now = br.readLine().toCharArray();
		expect = br.readLine().toCharArray();
		br.close();		
	}
}
