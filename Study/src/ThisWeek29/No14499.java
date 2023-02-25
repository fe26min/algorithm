package ThisWeek29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14499 {
	static int N, M, x, y, K;
	static int[][] mat;
	static int[] dice;
	static StringBuilder sb;
	
	static int[] dirx = {0, 0, 0, -1, 1};
	static int[] diry = {0, 1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice = new int[6];
		
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		for(int i=0; i<K; i++) {
			move(Integer.parseInt(st.nextToken()));
		}
		System.out.println(sb);
		
		br.close();
	}

	private static void move(int dir) {
		int nx = x + dirx[dir];
		int ny = y + diry[dir];
		if(nx < 0 || ny<0 || nx>=N || ny>= M)
			return;
		
		int temp = -1;
		switch(dir) {
		case 0:
			break;
			
		case 1:
			temp = dice[3];
			for(int i=3; i>0; i--) {
				dice[i] = dice[i-1];
			}
			dice[0] = temp;
			break;
			
		case 2:
			temp = dice[0];
			for(int i=0; i<4; i++) {
				dice[i] = dice[i+1];
			}
			dice[3] = temp;
			break;
		case 3:
			temp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[2];
			dice[2] = dice[5];
			dice[5] = temp;
			break;
		case 4:
			temp = dice[0];
			dice[0] = dice[5];
			dice[5] = dice[2];
			dice[2] = dice[4];
			dice[4] = temp;
			break;
		}
		
		if(mat[nx][ny] == 0) {
			mat[nx][ny] = dice[0];
		}
		else {
			dice[0] = mat[nx][ny];
			mat[nx][ny] = 0;
		}
//		System.out.println(dir + ": " + nx + " "+ ny);
//		for(int i: dice) {
//			System.out.print(i + " ");
//		}System.out.println();
		x = nx;
		y = ny;
		sb.append(dice[2] + "\n");
	}
}
