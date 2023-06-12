package ThisWeek45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1018 {
	static int N, M;
	static char[][] mat;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int score = 0;
		int maxscore = 64;
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				
				for(int x = i; x < i+8; x++) {
					for(int y = j; y < j+8; y++) {
						if((x+y) % 2 == 0 && mat[x][y] == 'W') score++;
						if((x+y) % 2 == 1 && mat[x][y] == 'B') score++;
					}
				}
				
				int num = 64;
				
				num = 64 - score > score ? score : 64-score;
				maxscore = maxscore > num ? num : maxscore;
				score = 0;
			}
		}
		System.out.println(maxscore);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new char[N][M];
		
		for(int i=0; i<N; i++) {
			mat[i] = br.readLine().toCharArray();
		}
		br.close();
	}
}