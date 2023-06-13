package ThisWeek45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2607 {
	static int N;
	static int[][] mat;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int cnt = 0;
		
		for(int i=1; i<N; i++) {
			if(check(i)) {
				System.out.println(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static boolean check(int idx) {
		if(Math.abs(mat[0][26] - mat[idx][26]) > 1)
			return false;
		
		int cnt = 0;
		for(int i=0; i<26; i++) {
			cnt += Math.abs(mat[0][i] - mat[idx][i]);
			if(cnt > 2)
				return false;
		}
		return true;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N][27];
		
		for(int i=0; i<N; i++) {
			for(char c : br.readLine().toCharArray()) {
				mat[i][c-'A']++;
				mat[i][26]++;
			}
		}
		br.close();		
	}
}
