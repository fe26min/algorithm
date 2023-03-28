package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1248 {
	static int N;
	static int[] mat;
	static char[][] signs;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		dfs(0);
	}

	private static void dfs(int depth) {
		if(depth == N) {
			for(int i : mat) {
				System.out.print(i + " ");
			}System.out.println();
			System.exit(0);
		}
		
		for(int i=-10; i<=10; i++) {
			mat[depth] = i;
			if(check(depth + 1))
				dfs(depth + 1);
		}
	}

	private static boolean check(int depth) {
		for(int i = 0; i<depth; i++) {
			int sum = 0;
			for(int j=i; j<depth; j++) {
				sum += mat[j];
				if(signs[i][j] != (sum == 0 ? '0' : (sum < 0 ? '-' : '+'))) {
					return false;
				}
			}
		}
		return true;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N];
		signs = new char[N][N];
		String line = br.readLine();
		
		int idx = 0;
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				signs[i][j] = line.charAt(idx++);
			}
		}
		
		br.close();		
	}
}
