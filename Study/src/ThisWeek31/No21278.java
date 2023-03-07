package ThisWeek31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No21278 {
	static int N, M, ansSum;
	static int[] ans, select;
	static int[][] mat;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		floid();
		func();
	}
	private static void func() {
		int s1 = Integer.MAX_VALUE;
		int s2 = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				int dis = distance(i, j);
				
				if(min > dis) {
					s1 = i;
					s2 = j;
					min = dis;
				}
			}
		}
		System.out.println(s1 + " "+ s2 + " " + min * 2);
	}

	private static int distance(int x, int y) {
		int result = 0;
		for(int i=1; i<=N; i++) {
			result += Math.min(mat[x][i], mat[y][i]);
		}
		return result;
	}

	private static void floid() {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
				}
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mat = new int[N + 1][N + 1];
		
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N; j++) {
				if(i==j)
					continue;
				mat[i][j] = 10001;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			mat[s][e] = mat[e][s] = 1;
		}
		br.close();
	}
}
