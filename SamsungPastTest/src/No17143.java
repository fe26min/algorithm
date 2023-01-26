import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17143 {
	static int R, C, M, sumShark;
	static Shark[][] mat;
	
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		// 잡은 상어의 무게를 초기화
		sumShark = 0;

		// 테스트용 현재 상어들 위치 보이기
//		show();
		for(int c=0; c<C; c++) {
			// i열 낚시
			fishing(c);
			move();
			// 테스트용 현재 상어들 위치 보이기
//			show();
		}
		System.out.println(sumShark);
	}
	
	private static void show() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(mat[i][j] == null)
					System.out.print("0 ");
				else 
					System.out.print(mat[i][j].size + " ");
			}System.out.println();
		}System.out.println();
	}

	private static void move() {
		Queue<Shark> newSharks = new LinkedList<Shark>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (mat[i][j] == null)
					continue;
				newSharks.add(mat[i][j]);
			}
		}
		
		mat = new Shark[R][C];
		
		while(!newSharks.isEmpty()) {
			Shark cur = newSharks.poll();

			int nr = cur.r + dirx[cur.dir] * (cur.speed % (2 * (R-1)));
			int nc = cur.c + diry[cur.dir] * (cur.speed % (2 * (C-1)));
			int nd = cur.dir;
			
			while (nr < 0 || nc < 0 || nr >= R || nc >= C) {
				if (nr < 0) {
					nr *= -1;
					nd = (nd + 2) % 4;
				} else if (nc < 0) {
					nc *= -1;
					nd = (nd + 2) % 4;
				} else if (nr >= R) {
					nr = 2 * R - 2 - nr;
					nd = (nd + 2) % 4;
				} else if (nc >= C) {
					nc = 2 * C - 2 - nc;
					nd = (nd + 2) % 4;
				}
			}
			if (mat[nr][nc] == null || mat[nr][nc].size < cur.size)
				mat[nr][nc] = new Shark(nr, nc, cur.speed, nd, cur.size);
		}
		
	}

	private static void fishing(int i) {
		for(int j=0; j<R; j++) {
			if(mat[j][i] != null) {
				sumShark += mat[j][i].size;
				mat[j][i] = null;
				return;
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new Shark[R][C];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			switch (d) {
			case 1:
				d = 0;
				break;
			case 2:
				d = 2;
				break;
			case 3:
				d = 1;
				break;
			case 4:
				d = 3;
				break;
			}
			
			mat[r][c] = new Shark(r, c, s, d, z);
		}
		br.close();
	}
}

class Shark {
	int r, c, dir, size, speed;
	
	public Shark(int r, int c, int speed, int dir, int size) {
		this.r = r;
		this.c = c;
		this.dir = dir;
		this.size = size;
		this.speed = speed;
	}
}