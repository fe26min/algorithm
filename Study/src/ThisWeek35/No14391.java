package ThisWeek35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14391 {
	static int N, M, max;
	static int[][] mat;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				mat[i][j] = line.charAt(j)-'0';
			}
		}
		br.close();
	}
	private static void pro() {
		max = 0;
		for(int i=0; i< (1<<(N*M)); i++) {
			check(i);
		}
		System.out.println(max);
	}
	private static void check(int num) {
		int sum = 0;
		// 가로 찾기
		for(int i=0; i<N; i++) {
			int cur = 0;
			for(int j=0; j<M; j++) {
				int k = i * M + j;
				if((num & (1<<k)) == 0) {
					cur *= 10;
					cur += mat[i][j];
				}else {
					sum += cur;
					cur = 0;
				}
			}
			sum += cur;
		}
		// 세로 찾기
		for(int j=0; j<M; j++) {
			int cur = 0;
			for(int i=0; i<N; i++) {
				int k = i*M + j;
				if((num & (1<<k)) != 0) {
					cur *= 10;
					cur += mat[i][j];
				}else {
					sum += cur;
					cur = 0;
				}
			}
			sum += cur;
		}
		max = Math.max(max, sum);
	}
}
