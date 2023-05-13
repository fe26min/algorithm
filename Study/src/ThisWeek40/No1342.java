package ThisWeek40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1342 {
	static int N, ans;
	static int[] alpa = new int[26];
	static int[] select;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		ans = 0;
		select = new int[N];
		
		for(int i=0; i<26; i++) {
			if(alpa[i] != 0) {
				alpa[i]--;
				select[0] = i;
				dfs(1);
				alpa[i]++;
			}
		}
		System.out.println(ans);
	}
	private static void dfs(int depth) {
		if(depth == N) {
			ans++;
			return;
		}
		
		for(int i=0; i<26; i++) {
			if(alpa[i] == 0)
				continue;
			if(select[depth - 1] == i)
				continue;
			alpa[i]--;
			select[depth] = i;
			dfs(depth + 1);
			alpa[i]++;
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N = input.length();
		for(char c : input.toCharArray()) {
			alpa[c-'a']++;
		}
		br.close();
	}
}
