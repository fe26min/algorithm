package BOJ.samsung_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17281 {
	// 수열 문제

	static int max, N;
	static int[][] inning;
	static int[] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		inning = new int[N][9];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0;
		
		// dfs로 순서 정하기
		arr = new int[9];
		visit = new boolean[9];
		
		// 1번 타자는 4번으로 고정
		arr[3] = 0;
		visit[0] = true; 
		dfs(0);
	
		System.out.println(max);
		br.close();
	}

	private static void dfs(int depth) {
		if(depth == 9) {
			game();
			return;
		}
		if(depth == 3) {
			dfs(depth + 1);
		}
		
		for(int i=0; i<9; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			arr[depth] = i;
			dfs(depth + 1);
			visit[i] = false;
		}
	}

	private static void game() {
		int score = 0;
		int idx = 0;
		boolean[] base;
		
		for(int i=0; i<N; i++) {
			int outCnt = 0;
			base = new boolean[4];
			
			outer : while(true) {
				for(int j= idx; j<9; j++) {
					int hitter = inning[i][arr[j]];
					
					switch(hitter) {
					case 0:
						outCnt++;
						break;
					case 1:
						for(int k=3; k>=1; k--) {
							if(base[k]) {
								if(k==3) {
									score++;
									base[k] = false;
									continue;
								}
								
								base[k] = false;
								base[k + 1] = true;
							}
						}
						
						base[1] = true;
						break;
						
					case 2:
						for (int k=3; k>=1; k--) {
							if(base[k]) {
								if(k==3 || k==2) {
									score++;
									base[k] = false;
									continue;
								}
								
								base[k] = false;
								base[k+2] = true;
							}
						}
						base[2] = true;
						break;
						
					case 3:
						for(int k=3; k>=1; k--) {
							if(base[k]) {
								score++;
								base[k] = false;
							}
						}
						base[3] = true;
						break;
						
					case 4:
						for(int k=1; k<=3; k++) {
							if(base[k]) {
								score++;
								base[k] = false;
							}
						}
						score++;
						break;
					}
					
					if(outCnt == 3) {
						idx = (j + 1) % 9;
						break outer;
					}
				}
				idx = 1;
			}
		}
		max = Math.max(max, score);
		
	}
}
