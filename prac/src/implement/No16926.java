package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16926 {
	static int N, M, R;
	static int[][] mat;
	public static void main(String[] args) throws IOException {
		input();
		circle(R);
	}

	private static void circle(int r) {
		
		
		int[][] next = new int[N][M];
		
		for(int i=0; i<N; i++) {
			next[i] = mat[i].clone();
		}
		
		for(int i=0; i<Math.min(N, M) / 2; i++) {
			
			int temp = next[i][i];
			// 윗 변
			for(int j=i; j < M-i-1; j++) {
				next[i][j] = next[i][j+1]; 
			}
			// 오른변
			for(int j=i; j<N-i-1; j++) {
				next[j][M-i-1] = next[j+1][M-i-1];
			}
			
			// 아랫변
			for(int j=i; j<M-i-1; j++) {
				next[N-i-1][M-j-1] = next[N-i-1][M-j-2];
			}
			
			// 왼쪽변
			for(int j=i; j<N-i-1; j++) {
				next[N-j-1][i] = next[N-j-2][i];
			}
			next[i+1][i] = temp;
		}
		
		mat = next;
		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(mat[i][j] + " ");
//			}System.out.println();
//		}
//		System.out.println();
		circle(r-1);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		br.close();
	}
}
