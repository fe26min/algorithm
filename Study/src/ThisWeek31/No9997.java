package ThisWeek31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9997 {
	static int N, cnt = 0, max = conv("abcdefghijklmnopqrstuvwxyz");
	static int[] arr;
	static boolean[] select;
	// 모든 문장들을 2진수로 표현하기
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		select = new boolean[N];
		
		// 조합
		dfs(0);
		System.out.println(cnt);
	}
	
	private static void dfs(int start) {
		check();
//		for(int i: arr) {
//			System.out.print(i + " ");
//		}System.out.println();
		
		for(int i=start; i<N; i++) {
			select[i] = true;
			dfs(i + 1);
			select[i] = false;
		}
	}

	private static void check() {
//		for(int i=0; i<N; i++) {
//			if(select[i]) {
//				System.out.print(i + " ");
//			}
//		}System.out.println();
		int ans = 0;
		for(int i=0; i<N; i++) {
			if(select[i]) {
				ans |= arr[i];
			}
		}
		if(ans == max) {
			cnt++;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			arr[i] = conv(word);
		}
		br.close();
	}
	
	private static int conv(String word) {
//		System.out.print(word + " : ");
		int ans = 0;
		for(char c : word.toCharArray()) {
//			System.out.print((int)(c-'a' + 1) + " ");
			ans |= ((1 << (c - 'a') + 1) );
		}
//		System.out.println();
		return ans;
	}
}
