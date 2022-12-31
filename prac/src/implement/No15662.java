package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No15662 {
	static int T, K;
	static int[][] cmds;
	static int[][] wheel;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		for(int[] cmd : cmds) {
			Queue<int[]> queue = new LinkedList<int[]>();
			
			boolean[] visit = new boolean[T];
			
			queue.add(cmd);
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				visit[cur[0]] = true;
//				System.out.println(cur[0] + " " + cur[1]);
				// 회전하기 전에 옆에 거를 queue에 넣기
				
				// 왼쪽 보기
				if(cur[0] != 0 && !visit[cur[0] - 1]) {
					// 지금 회전하는 바퀴의 [6]번째와 왼쪽 바퀴의 [2]이 같다면 반대 방향으로 회전
					if(wheel[cur[0]][6] != wheel[cur[0]-1][2]) {
						queue.add(new int[] {cur[0]-1, -1  * cur[1]});
					}
				}
				
				// 오른쪽 보기
				if(cur[0] != T-1 && !visit[cur[0] + 1]) {
					// 지금 회전하는 바퀴의 [2]번째와 오른쪽 바퀴의 [6]이 같다면 반대 방향으로 회전
					if(wheel[cur[0]][2] != wheel[cur[0] + 1][6]) {
						queue.add(new int[] {cur[0]+1, -1 * cur[1]});
					}
				}
				// 회전시키기
				// 시계방향
				if(cur[1] == 1) {
					int temp = wheel[cur[0]][7];
					for(int i=7; i>0; i--) {
						wheel[cur[0]][i] = wheel[cur[0]][i-1];
					}
					wheel[cur[0]][0]= temp;
				}
				
				// 반시계방향
				else if(cur[1] == -1) {
					int temp = wheel[cur[0]][0];
					for(int i=0; i<7; i++) {
						wheel[cur[0]][i] = wheel[cur[0]][i+1];
					}
					wheel[cur[0]][7] = temp;
				}
			}
		}
		int count = 0;
//		for(int i=0; i<T; i++) {
//			for(int j=0; j<8; j++) {
//				System.out.print(wheel[i][j] + " ");
//			}System.out.println();
//		}
		
		for(int i=0; i<T; i++) {
			if(wheel[i][0] == 1)
				count++;
		}
		System.out.println(count);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		wheel = new int[T][8];
		for(int i=0; i<T; i++) {
			String line = br.readLine();
			for(int j=0; j<8; j++) {
				wheel[i][j] = line.charAt(j) - '0';
			}
		}
		K = Integer.parseInt(br.readLine());
		cmds = new int[K][2];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			cmds[i][0] = Integer.parseInt(st.nextToken()) - 1;
			cmds[i][1] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}
