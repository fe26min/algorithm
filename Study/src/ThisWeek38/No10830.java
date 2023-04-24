package ThisWeek38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10830 {
	static int N;
	static long B;
	static long[][] A, ans, temp;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		while(B > 0) {
			if(B % 2 == 1) {
				multiple(ans, A);
			}
			multiple(A, A);
			B /= 2;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(ans[i][j] + " ");
			}System.out.println();
		}
	}

	private static void multiple(long[][] x, long[][] y) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				temp[i][j] = 0;
				for(int k=0; k<N; k++) {
					temp[i][j] += (x[i][k] * y[k][j]);
				}
				temp[i][j] %= 1000;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				x[i][j] = temp[i][j];
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		A = new long[N][N];
		ans = new long[N][N];
		temp = new long[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j] = Long.parseLong(st.nextToken());
			}
			ans[i][i] = 1;
		}
		
		br.close();		
	}
}
