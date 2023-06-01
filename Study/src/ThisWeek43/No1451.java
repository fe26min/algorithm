package ThisWeek43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1451 {
	static int N, M;
	static long max;
	static long[][] sum;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		max = 0L;
		check();
		System.out.println(max);
	}
	private static void check() {
		// | | |
		for(int i=0; i<M-2; i++) {
			for(int j=0; j<M-1; j++) {
				max = Math.max(max, sum[N-1][i] * (sum[N-1][j] - sum[N-1][i]) * (sum[N-1][M-1] - sum[N-1][j]));
			}
		}
		// -
		// -
		// -
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<N-1; j++) {
				max = Math.max(max, sum[i][M-1] * (sum[j][M-1] - sum[i][M-1]) * (sum[N-1][M-1] - sum[j][M-1]));
			}
		}
		
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<M-1; j++) {
				long seq1 = sum[i][j];
				long seq2 = sum[N-1][j] - sum[i][j];
				long seq3 = sum[i][M-1] - sum[i][j];
				long seq4 = sum[N-1][M-1] - sum[N-1][j] - sum[i][M-1] + sum[i][j];
				
				max = Math.max(max, (seq1 + seq2) * seq3 * seq4);
				max = Math.max(max, (seq1 + seq3) * seq2 * seq4);
				max = Math.max(max, seq1 * (seq2 + seq4) * seq3);
				max = Math.max(max, seq1 * seq2 * (seq3 + seq4));
			}
		}
		
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sum = new long[N+1][M+1];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				sum[i][j] += line.charAt(j)-'0';
				sum[i+1][j] += sum[i][j];
				sum[i][j+1] += sum[i][j];
				sum[i+1][j+1] -= sum[i][j];
			}
		}
		br.close();
	}
}
