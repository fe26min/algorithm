package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2447 {
	static int N;
	static char[][] mat;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		mat = new char[N][N];
		draw(0, 0, N, false);
		print();
	}
	private static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(mat[i][j]);
			}sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void draw(int x, int y, int size, boolean isBlank) {
		if(isBlank) {
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					mat[x + i][y + j] = ' ';
				}
			}
			return;
		}
		if(size == 1) {
			mat[x][y] = '*';
			return;
		}
		
		size /= 3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1 && j==1) {
					draw(x + size, y + size, size, true);
				}
				else {
					draw(x + size * i, y + size * j, size, false);
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