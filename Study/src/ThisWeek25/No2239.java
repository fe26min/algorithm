package ThisWeek25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2239 {
	static int zeroCnt;
	static int[] arr;
	static int[][] mat = new int[9][9];
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		arr = new int[zeroCnt];
		
		dfs(0);
	}



	private static void dfs(int depth) {
		if(depth == zeroCnt) {
			for(int i : arr) {
				System.out.print(i);
			}System.out.println();
			return;
		}
		
		for(int i=1; i<=9; i++) {
			arr[depth] = i;
			dfs(depth + 1);
			arr[depth] = 0;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		zeroCnt = 0;
		for(int i=0; i<9; i++) {
			String input = br.readLine();
			for(int j=0; j<9; j++) {
				mat[i][j] = input.charAt(j)-'0';
				if(mat[i][j] == 0)
					zeroCnt++;
			}
		}
		br.close();
	}
}
