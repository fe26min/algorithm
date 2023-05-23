package ThisWeek42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1451 {
	static int N, M;
	static long max;
	static int[][] mat;
	static long[][] sum;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		makeSum();
		
		comb(0,0, M-1, new int[2], new boolean[M-1], true);
		comb(0,0, N-1, new int[2], new boolean[N-1], false);
		
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<M-1; j++) {
				long square1 = sum[i][j];
				long square2 = sum[i][M-1] - square1;
				long square3 = sum[N-1][j] - square1;
				long square4 = sum[N-1][M-1] - square1 - square2 - square3;
				
				max = Math.max(max, (square1 + square2) * square3 * square4);
				max = Math.max(max, (square1 + square3) * square2 * square4);
				max = Math.max(max, (square2 + square4) * square1 * square3);
				max = Math.max(max, (square3 + square4) * square1 * square2);
				
			}
		}
		System.out.println(max);
	}


	public static void comb(int depth,int start, int numLength,int[] answer, boolean[] v, boolean isRow) {
		if(depth == 2) {
			int leftIdx = answer[0];
			int rightIdx = answer[1];
			if(isRow) {
				long square1 = sum[N-1][leftIdx];
				long square2 = sum[N-1][rightIdx] - sum[N-1][leftIdx];
				long square3 = sum[N-1][numLength] - sum[N-1][rightIdx];
				max = Math.max(max, square1 * square2 * square3);
			}else {
				long square1 = sum[leftIdx][M-1];
				long square2 = sum[rightIdx][M-1] - sum[leftIdx][M-1];
				long square3 = sum[numLength][M-1] - sum[rightIdx][M-1];
				max = Math.max(max, square1 * square2 * square3);				
			}
			return;
		}
		
		for (int i = start; i < numLength; i++) {
			if(v[i]) continue;
			answer[depth] = i;
			comb(depth+1,i+1,numLength,answer,v, isRow);
			v[i] = false;
		}
	}
	
	private static void makeSum() {
		sum = new long[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i==0 && j==0)
					sum[i][j] = mat[i][j];
				else if(i==0)
					sum[i][j] = sum[i][j-1] + mat[i][j];
				else if(j==0)
					sum[i][j] = sum[i-1][j] + mat[i][j];
				else
					sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i][j];
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++)
				mat[i][j] = line.charAt(j)-'0';
		}
		
		br.close();	
	}
}
