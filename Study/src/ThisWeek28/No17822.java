package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No17822 {
	static int N, M, T, sum, cnt;
	static int[][] t;
	static Point17822[][] map;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		sum = 0;
		cnt = N * M;
		
		map = new Point17822[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = new Point17822(Integer.parseInt(st.nextToken()));
				sum += map[i][j].num;
			}
		}
		t = new int[T][3];
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			t[i][0] = Integer.parseInt(st.nextToken());
			t[i][1] = Integer.parseInt(st.nextToken());
			t[i][2] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}

	private static void pro() {
		for (int[] i : t) {
			move(i);
//			check();
			
			for(int k=0; k<N; k++) {
				for(int j=0; j<M; j++) {
					System.out.print(map[k][j].num + " ");
				}System.out.println();
			}System.out.println();
		}

		System.out.println(sum);
	}

	// 회전 하기
	private static void move(int[] arr) {
		arr[2] %= M;
		for(int i= arr[0] - 1; i<N; i += arr[0] ) {
			// 시계 방향
			
			Point17822[] newMap = new Point17822[M];
			if(arr[1] == 0) {
				
				for(int j = M-1; j>0; j--) {
					map[i][j].num = map[i][(j + (M - arr[2])) % M].num;
				}
			}
			// 반시계 방향
			else {
				for(int j=0; j<M-1; j++) {
					map[i][j].num = map[i][(j + arr[2]) % M].num;
				}
			}
		}
		
//		for (int t = 0; t < arr[2] % M; t++) {
//			for (int i = arr[0]; i <= N; i += arr[0]) {
//				// 시계 방향
//				if (arr[1] == 0) {
//					int temp = map[i - 1][N - 1].num;
//
//					for (int j = M - 1; j > 0; j--) {
//						map[i - 1][j].num = map[i - 1][j - 1].num;
//					}
//					map[i - 1][0].num = temp;
//				}
//				// 반시계 방향
//				else {
//					int temp = map[i - 1][0].num;
//					for (int j = 0; j < M - 1; j++) {
//						map[i - 1][j].num = map[i - 1][j + 1].num;
//					}
//					map[i - 1][N - 1].num = temp;
//				}
//			}
//		}
	}

	// 인접 제거
	private static void check() {
		boolean[][] visit = new boolean[N][M];
		HashSet<Point17822> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j].num == 0)
					continue;
				if(map[i][j].num == map[i][(j+1)%M].num) {
					set.add(map[i][j]);
					set.add(map[i][(j+1)%M]); 
				}
			}
		}
		
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N - 1; i++) {
				if(map[i][j].num == 0)
					continue;
				if (map[i][j].num == map[i + 1][j].num) {
					set.add(map[i][j]);
					set.add(map[i + 1][j]);
				}
			}
		}
		
		for (Point17822 p : set) {
			sum -= p.num;
			p.num = 0;
		}
		cnt -= set.size();
		System.out.println(sum + " " + cnt);
		if(set.isEmpty()) {
			int newSum = 0;
			int newCnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j].num == 0) {
						continue;
					}
					if((double)map[i][j].num <(double) sum / cnt) {
						map[i][j].num++;
					}
					else if((double)map[i][j].num > (double) sum / cnt){
						map[i][j].num--;
					}
					newCnt++;
					newSum+= map[i][j].num;
				}
			}
			sum = newSum;
			cnt = newCnt;
		}
	}
}

class Point17822 {
	int num;
	public Point17822(int num) {
		this.num = num;
	}
}