package BOJ.samsung_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 조합 문제
// dfs의 깊이가 3인 수를 찾아야 한다
public class No17135 {
	static int N, M, D, max;
	static int[][] mat;
	static int[] arr = new int[3];
	
	public static void main(String[] args) throws IOException {
		input(); 
		pro();
	}
	
	private static void pro() {
		max = 0;
		// dfs 조합
		dfs(0, 0);
		System.out.println(max);
	}

	private static void dfs(int depth, int start) {
		if(depth == 3) {
			game();
			return;
		}
		
		for(int i=start; i<M; i++) {
			arr[depth] = i;
			dfs(depth + 1, i+1);
		}
	}

	private static void game() {
		// 죽인 적들의 수를 기록
		int count = 0;
		// Queue에 담는다.
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(mat[i][j]==1) {
					queue.add(new int[] {i, j});
				}
			}
		}

		while(!queue.isEmpty()) {
			// 다음 next
			Queue<int[]> next = new LinkedList<>();
			// 죽었는지를 본다.
			boolean[][] dead = new boolean[N][M];
			// 목표 리스트들을 받는다.
			int[][] target = new int[3][2];
			
			for(int i=0; i<3; i++) {
				Arrays.fill(target[i], -1);
			}
			
			// 적들 목록을 본다.
			for(int[] enemy : queue) {
				// 3명의 궁수들이 적들을 본다.
				
				// 최대 사거리 밖에 있을 경우 
				if(enemy[0] < N-D) continue;

				for(int j=0; j<3; j++) {
					// 적과 궁수간의 거리 측정
					int d = Math.abs(enemy[0] - N) + Math.abs(enemy[1] - arr[j]);
					// 사정거리 내이다. 타겟인지 아닌지 본다.
					if(d <= D) {
						
						// 지금 노리고 있는 타겟보다 더 가까운 타겟인가?
						if(Math.abs(target[j][0] - N) + Math.abs(target[j][1] - arr[j]) > d) {
							target[j] = enemy;
						}
						// 거리가 같다면 더 왼쪽에 있는가?
						else if(Math.abs(target[j][0] - N) + Math.abs(target[j][1] - arr[j]) == d) {
							if(target[j][1] > enemy[1]) {
								target[j] = enemy;
							}
						}
					}
				}
			}
			
			// 타겟들을 죽인다.
			for(int[] tar : target) {
				// 아무도 선정되지 않았다.
				if(tar[0] == -1)
					continue;
				
				if(!dead[tar[0]][tar[1]])
					count++;
				dead[tar[0]][tar[1]] = true;
			}
			// queue내에 죽은 애들을 제외하고는 한 칸씩 전진
			for(int[] i : queue) {
				if(dead[i[0]][i[1]]) continue;
				if(i[0] + 1 < N) {
					next.add(new int[] {i[0] + 1, i[1]});
				}
			}
			queue = next;
		}
		max = Math.max(max, count);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
}
