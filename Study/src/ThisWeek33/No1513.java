package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참고 https://steins-gate.tistory.com/entry/BAEJOON-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-1513-%EA%B2%BD%EB%A1%9C-%EC%B0%BE%EA%B8%B0
public class No1513 {
	static int N, M, C;
	static int[][] mat;
	static int[][][][] dp;
	
	static int[] dirx = {1, 0};
	static int[] diry = {0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(i==1 && j==1) continue;
				if(mat[i][j] > 0) {
					for(int prev = 0; prev<mat[i][j]; prev++) {
						for(int cnt = 0; cnt<=prev; cnt++) {
							dp[i][j][mat[i][j]][cnt+1] += dp[i-1][j][prev][cnt] + dp[i][j-1][prev][cnt];
							dp[i][j][mat[i][j]][cnt+1] %= 1_000_007;
						}
					}	
				}
				else {
					for(int prev=0; prev<=C; prev++) {
						for(int cnt=0; cnt<=prev; cnt++) {
							dp[i][j][prev][cnt] = (dp[i-1][j][prev][cnt] + dp[i][j-1][prev][cnt]) % 1_000_007;
						}
					}
				}
			}
		}
		for(int cnt = 0; cnt<=C; cnt++) {
			int sum = 0;
			for(int prev = 0; prev<=C; prev++) {
				sum += dp[N][M][prev][cnt];
				sum %= 1_000_007;
			}
			System.out.print(sum + " ");
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		dp = new int[51][51][51][51];
		mat = new int[51][51];

		dp[1][1][0][0] = 1;
		for(int i=1; i<=C; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x==1 && y==1) {
				dp[1][1][0][0] = 0;
				dp[1][1][i][1] = 1;
			}
			mat[x][y] = i;
		}
		br.close();
	}
}
