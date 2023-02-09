package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11404 {
	static final int max =10_000_001;
	static int n;
	static int[][] mat;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	
	private static void pro() {
		for(int m=0; m<n; m++) {
			for(int s =0; s<n; s++) {
				for(int e =0; e<n; e++) {
					if(mat[s][e] > mat[s][m] + mat[m][e]) {
						mat[s][e] = mat[s][m] + mat[m][e];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(mat[i][j]==max) {
					mat[i][j] = 0;
				}
				sb.append(mat[i][j] + " ");
			}sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		mat = new int[n][n];
		
		for(int i=0; i<n; i++) {
			Arrays.fill(mat[i], max);
			mat[i][i] = 0;
		}
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) -1;
			int b = Integer.parseInt(st.nextToken()) -1;
			int c = Integer.parseInt(st.nextToken());
			if(mat[a][b] > c)
				mat[a][b] = c;
		}
		br.close();
		
	}
}
