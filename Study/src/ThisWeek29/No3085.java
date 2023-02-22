package ThisWeek29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No3085 {
	static int N, max;
	static char[][] mat;
	public static void main(String[] args) throws IOException {
		input();
		pro();

	}
	private static void pro() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(j+1 < N) {
					swap(i, j, i, j+1);
					chkRow(i);
					chkCol(j);
					chkCol(j+1);
					swap(i, j, i, j+1);
				}
				if(i+1 < N) {
					swap(i, j, i+1, j);
					chkRow(i);
					chkRow(i+1);
					chkCol(j);
					swap(i, j, i+1, j);
				}
			}
		}
		System.out.println(max);
	}
	
	private static void swap(int x1, int y1, int x2, int y2) {
		char tmp = mat[x1][y1];
		mat[x1][y1] = mat[x2][y2];
		mat[x2][y2] = tmp;
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		mat = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				mat[i][j] = line.charAt(j);
			}
			chkRow(i);
		}
		
		for(int j=0; j<N; j++) {
			chkCol(j);
		}
		
		br.close();
	}
	
	private static void chkCol(int j) {
		int cnt = 1;
		for(int i=1; i<N; i++) {
			if(mat[i-1][j] == mat[i][j])
				cnt++;
			else 
				cnt = 1;
			max = Math.max(max, cnt);
		}
	}
	private static void chkRow(int i) {
		int cnt = 1;
		for(int j=1; j<N; j++) {
			if(mat[i][j-1] == mat[i][j])
				cnt++;
			else {
				cnt = 1;
			}
			max = Math.max(max, cnt);
		}
	}
}
