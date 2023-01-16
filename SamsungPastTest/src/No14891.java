

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class No14891 {
	
	// 구현, 시물레이션
	
	static int[][] cmds;
	static int[][] gears;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		for(int[] cmd : cmds) {
			boolean visit[] = new boolean[4];
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.add(cmd);
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				
				int pos = cur[0];
				int dir = cur[1];
				
				if(visit[pos]) continue;
				visit[pos] = true;
				
				if(pos != 0) {
					if(!visit[pos-1] && gears[pos][6] != gears[pos-1][2])
						queue.add(new int[] {pos-1, dir * -1});
				}
				if(pos != 3) {
					if(!visit[pos+1] && gears[pos][2] != gears[pos+1][6])
						queue.add(new int[] {pos+1, dir * -1});
				}
				
				move(pos, dir);
			}
		}
		int score = 1;
		int sum = 0;
		
//		for(int i=0; i<4; i++) {
//			for(int j=0; j<8; j++) {
//				System.out.print(gears[i][j]);
//			}System.out.println();
//		}
		
		for(int i=0; i<4; i++) {
			sum += gears[i][0] * score;
			score *= 2;
		}
		System.out.println(sum);
	}
	
	// 회전 시키기
	private static void move(int pos, int dir) {
		if(dir == -1) {
			int imsi = gears[pos][0];
			for(int i=0; i<7; i++) {
				gears[pos][i] = gears[pos][i+1];
			}
			gears[pos][7] = imsi;
		}
		else {
			int imsi = gears[pos][7];
			for(int i=7; i>0; i--) {
				gears[pos][i] = gears[pos][i-1];
			}
			gears[pos][0] = imsi;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gears = new int[4][8];
		
		for(int i=0; i<4; i++) {
			String line = br.readLine();
			for(int j=0; j<8; j++) {
				gears[i][j] = line.charAt(j)-'0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		cmds = new int[K][2];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			cmds[i][0] = Integer.parseInt(st.nextToken()) - 1;
			cmds[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}
