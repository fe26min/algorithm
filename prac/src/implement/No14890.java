package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14890 {
	static int N, L;
	static int[][] mat;
	static boolean[][] used;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int count = 0;
		used = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			count += check(i, 0, 0);
		}

		used = new boolean[N][N];
		for (int j = 0; j < N; j++) {
			count += check(0, j, 1);
		}

		System.out.println(count);
	}

	

	private static int check(int x, int y, int d) {
		int[] height = new int[N];
		boolean[] used = new boolean[N];
		
		for(int i=0; i<N; i++) {
			height[i] = (d == 0) ? mat[x][y+i] : mat[x+i][y];
		}
		
		for(int i=0; i<N-1; i++) {
			if(height[i] == height[i+1])
				continue;
			if(Math.abs(height[i] - height[i+1]) > 1)
				return 0;
			
			if(height[i]-1 == height[i+1]) {
				for(int j=i+1; j<=i+L; j++) {
					if(j >= N || height[i+1] != height[j] || used[j]) {
						return 0;
					}
					used[j] = true;
				}
			}
			else if(height[i] + 1 == height[i+1]) {
				for(int j=i; j>i-L; j--) {
					if(j < 0 || height[i] != height[j] || used[j]) {
						return 0;
					}
					used[j] = true;
				}
			}
		}
		return 1;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		mat = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
}
