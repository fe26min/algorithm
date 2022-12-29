package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14499 {
	static int N, M, x, y, K;
	static int[][] mat;
	static int[] cmd;
	
	// 주사위 전개도
	static int[] dice = {0, 0, 0, 0, 0, 0};
	
	static int[] dirx = {0, 0, 0, -1, 1};
	static int[] diry = {0, 1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		// 명령어 이동
		for(int c : cmd) {
			int nx = x + dirx[c];
			int ny = y + diry[c];
			
			if(nx<0 || ny<0 || nx>=N || ny>=M)
				continue;
			x = nx;
			y = ny;
			// 굴려야 한다.
			roll(c);
		}
	}

	private static void roll(int c) {

		int temp = dice[1];
		switch(c) {
		// 동쪽 이동
		case 1:
			dice[1] = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[4];
			dice[4] = temp;
			break;
		
		// 서쪽 이동
		case 2:
			dice[1] = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[5];
			dice[5] = temp;
			break;
		
		// 북쪽 이동
		case 3:
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = dice[0];
			dice[0] = temp;
			break;
		
		// 남쪽 이동
		case 4:
			dice[1] = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[2];
			dice[2] = temp;
			break;
		}
		if(mat[x][y] == 0) {
			mat[x][y] = dice[1];
		}
		else {
			dice[1] = mat[x][y];
			mat[x][y] = 0;
		}
		System.out.println(dice[3]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		cmd = new int[K];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			cmd[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}
