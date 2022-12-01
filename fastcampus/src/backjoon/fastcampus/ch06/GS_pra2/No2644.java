package backjoon.fastcampus.ch06.GS_pra2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2644 {
	static int n;
	static int[][] mat;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		mat = new int[n][n];
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken()) - 1;
		int e = Integer.parseInt(st.nextToken()) - 1;
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			mat[x][y] = 1;
			mat[y][x] = 1;
		}
		br.close();

		boolean visit[] = new boolean[n];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {s, 0});
		visit[s] = true;
		
		while(!queue.isEmpty()) {
			int[] c = queue.poll();
			
			if(c[0] == e) {
				System.out.println(c[1]);
				return;
			}
			
			for(int i=0; i<n; i++) {
				if(mat[c[0]][i] != 1) continue;
				if(visit[i]) continue;
				visit[i] = true;
				queue.add(new int[] {i, c[1]+1});
			}
		}
		System.out.println(-1);
	}
}
