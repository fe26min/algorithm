package backjoon.answer_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1562 {
	static int N;
	static int MOD = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	// 풀이
	private static void pro() {
		// n번째, 마지막 수, 사용한 숫자들 기록
		long [][][] dp = new long[N][10][1<<10];
		
		// 각 숫자들이 하나만 들어가는 경우를 적습니다. 0은 제외
		for(int i=1; i<10; i++) {
			dp[0][i][1<<i] = 1;
		}
		
		// N번 수행
		for(int i=1; i<N; i++) {
			// 마지막 수에 뭐가 오는지 보기
			for(int j=0; j<10; j++) {
				// 각 비트 별로 보기
				for(int k=0; k<1024; k++) {
					// 비트에다가 마지막 수 j가 들어간다.
					int bit = k | (1<<j);
					
					// j가 0일 경우 1만 온다.
					if(j==0) {
						dp[i][0][bit] = (dp[i][0][bit] + dp[i-1][1][k]) % MOD;
					}
					// j가 9일 경우 8만 온다.
					else if(j==9) {
						dp[i][9][bit] = (dp[i][9][bit] + dp[i-1][8][k]) % MOD;
					}
					// 0,9가 아닐 경우 j-1, j+1에서 온다.
					else {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k] + dp[i-1][j+1][k]) % MOD;
					}
				}
			}
		}
		
		// 값을 더해줘야 한다.
		long sum = 0;
		// 1023은 모든 숫자들을 사용한 경우이다.
		for(int i=0; i<10; i++) {
			// 합계 더해주기
			sum = (sum + dp[N-1][i][1023]) % MOD;
		}
		// 합계 출력
		System.out.println(sum);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();
	}
}
