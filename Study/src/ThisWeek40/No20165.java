package ThisWeek40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

enum Dir {
	E(0), W(1), S(2), N(3);
	
	private final int value;
	Dir(int value) {this.value = value; }
	public int getValue() {return value; };
}

public class No20165 {
	static int N, M;
	static int[][] mat;
	static boolean[][] isFallen;
	
	static int[] dirx = {0, 0, 1, -1};
	static int[] diry = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		isFallen = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sum=0;
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken()) - 1;
			int Y = Integer.parseInt(st.nextToken()) - 1;
			int D = Dir.valueOf(st.nextToken()).getValue();
//					dir(st.nextToken().charAt(0));
			
			Queue<int[]> queue = new LinkedList<int[]>();
			
			if(!isFallen[X][Y]) {
				isFallen[X][Y] = true;
				queue.add(new int[] {X, Y});
			}
			int count = 0;
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				count++;
				for(int i=1; i<mat[cur[0]][cur[1]]; i++) {
					int nx = cur[0] + dirx[D] * i;
					int ny = cur[1] + diry[D] * i;
					
					if(nx<0||ny<0||nx>=N||ny>=M)
						continue;
					if(isFallen[nx][ny])
						continue;
					isFallen[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
			
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken()) - 1;
			Y = Integer.parseInt(st.nextToken()) - 1;
			
			isFallen[X][Y] = false;
			sum += count;
		}
		System.out.println(sum);
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(isFallen[i][j])	
					System.out.print("F ");
				else
					System.out.print("S ");
			}System.out.println();
		}
		
		br.close();
	}

	private static int dir(char c) {
		switch(c) {
		case 'E':
			return 0;
		case 'W':
			return 1;
		case 'S':
			return 2;
		case 'N':
			return 3;
 		}
		return -1;
	}
}
