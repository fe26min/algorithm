package ThisWeek35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15661 {
	static int N, min;
	static int[][] mat;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int [N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
	private static void pro() {
		min = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(min);
	}
	private static void dfs(int start, int bit) {
		// 현재 선택된 애들이 기록된 bit를 가지고 
		// Start와 Link팀의 점수를 계산
		check(bit);
		
		for(int i=start; i<N; i++) {
			bit += (1<<i);
			dfs(i+1, bit);
			bit -= (1<<i);
		}
	}
	private static void check(int bit) {
		int start = 0, link = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(((1 <<i) & bit) > 0 && ((1<<j) & bit) > 0) {
					start += mat[i][j];
				}else if(((1<<i) & bit) <= 0 && ((1<<j) & bit) <= 0) {
					link += mat[i][j];
				}
			}
		}
		min = Math.min(min, Math.abs(start - link));
	}
}
