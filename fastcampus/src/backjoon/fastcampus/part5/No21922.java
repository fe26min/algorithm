package backjoon.fastcampus.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No21922 {
	
	static int N, M;
	// 현재 공간에 거울과 에어컨 위치 입력
	static int[][] mat;
	
	// 바람의 방향도 기록이 된다.
	static int[][] wind;
	// 방향 그래프 바람의 이동을 도와준다.
	// 0 : 상
	// 1 : 좌
	// 2 : 하
	// 3 : 우
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		wind = new int[N][M];
		
		Queue<int[]> queue = new LinkedList<int[]>();

		int count = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j] == 9) {
					count++;
					queue.add(new int[] {i, j});
					wind[i][j] = 1 | 1<<1 | 1<<2 | 1<< 3;
				}
			}
		}
		

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			System.out.println(cx + " " + cy + " " + wind[cx][cy]);
			
			for(int i = 0; i < 4; i++){
				if((wind[cx][cy] & (1 << i)) != 0 ) {
					int nx = cx + dirx[i];
					int ny = cy + diry[i];
					
					if(nx<0 || ny<0 || nx >= N || ny >=M) continue;

					int ni = i;
					switch(mat[nx][ny]) {
					case 0 :
						break;
						
					case 1 :
						if(i % 2 == 1 ) {
							ni = (i + 2) % 4;
						}
						break;
						
					case 2 : 
						if(i % 2 == 0 ) {
							ni = (i + 2) % 4;
						}
						break;

					case 3 : 
						if(i==0) ni =3;
						else if(i==3) ni=0;
						else if(i==1) ni=2;
						else if(i==2) ni=1;
						break;
						
					case 4 : 
						if(i==0) ni =1;
						else if(i==1) ni=0;
						else if(i==2) ni=3;
						else if(i==3) ni=2;
						break;
					}
					if((wind[nx][ny] & (1 << ni)) !=0) continue;
					if(wind[nx][ny] == 0) count++;
					wind[nx][ny] |= (1 << ni);
					
					queue.add(new int[] {nx, ny});
				}
			}
		}
		System.out.println(count);
		br.close();
	}
}
