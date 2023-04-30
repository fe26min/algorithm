package ThisWeek38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2461 {
	static int N, M;
	static int[][] mat;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int[] idx = new int[N];
		int ans = Integer.MAX_VALUE;
		
		while(true) {
			int max = 0;
			int min = 1000000000;
			int minIdx = 0;
			
			for(int i=0; i<N; i++) {
				max = Math.max(max, mat[i][idx[i]]);
				if(min > mat[i][idx[i]]) {
					minIdx = i;
					min = mat[i][idx[i]];
				}
			}
			ans = Math.min(ans, max - min);
			
			idx[minIdx]++;
			if(idx[minIdx] == M)
				break;
		}
		System.out.println(ans);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(mat[i]);
		}
		
		br.close();		
	}
}
