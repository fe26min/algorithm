package ThisWeek22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2447 {
	static int N;
	static int[][] mat;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		StringBuilder sb = new StringBuilder();
		
		func(0, 0, N, false);
		
	}

	private static void func(int x, int y, int N, boolean blank) {
		
		if(blank) {
			for(int i=x; i<x; i++) {
				for(int j=y; j<y + N; j++) {
					mat[i][j] = ' ';
				}
			}
			return;
		}
		
		if(N==1) {
			mat[x][y] = '*';
			return;
		}
		
		int size = N / 3;
		int count = 0;
		
		for(int i = x; i < x + N; i += size) {
			for(int j = y; j < y + N; j += size) {
				count++;
				if(count == 5) {
					func(i, j, size, true);
				} else {
					func(i, j, size, false);
				}
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();
	}
}
