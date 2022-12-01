package backjoon.fastcampus.ch06.GS_pra2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7562 {
	static int I;
	static boolean[][] visit;
	static int[] dirx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] diry = {-2, -1, 1, 2, 2, 1, -1, -2};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int ti=0; ti<T; ti++) {
			I = Integer.parseInt(br.readLine());
			visit = new boolean[I][I];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.add(new int[] {sx, sy, 0});
			
			while(!queue.isEmpty()) {
				int cur[] = queue.poll();
				
				if(cur[0]==ex && cur[1] == ey) {
					sb.append(cur[2]+"\n");
					break;
				}
				
				for(int di=0; di<8; di++) {
					int nx = cur[0] + dirx[di];
					int ny = cur[1] + diry[di];
					
					if(nx<0||ny<0||nx>=I||ny>=I) continue;
					if(visit[nx][ny])continue;
					visit[nx][ny] = true;
					queue.add(new int[] {nx, ny, cur[2] + 1});
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
}
