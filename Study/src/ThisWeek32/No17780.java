package ThisWeek32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17780 {
	static int N, K;
	static int[][] num;
	static Node17780[] list;
	static Node17780[][] mat;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int cnt = 0;
		boolean check = false;
		while(true) {
			cnt++;
			for(int i=0; i<K; i++) {
				if(move(i)) {
					check = true;
					break;
				}
			}
			if(check) {
				System.out.println(cnt);
				break;
			}
		}
		System.out.println(-1);
	}

	private static boolean move(int idx) {
		Node17780 cur = list[idx];
		
		return false;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new Node17780[K];
		num = new int[N][N];
		mat = new Node17780[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
				mat[i][j] = new Node17780(i,j, -1, -1);
			}
		}
		
		int idx = 0;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) -1;
			int y = Integer.parseInt(st.nextToken()) -1;
			int dir = Integer.parseInt(st.nextToken());
			mat[x][y].next = new Node17780(x, y, idx, dir);
			list[idx++] = mat[x][y].next;
		}
		
		br.close();
	}
}

class Node17780 {
	int x, y, idx, dir;
	Node17780 next;
	Node17780 prev;
	
	public Node17780(int x, int y, int idx, int dir) {
		this.x = x;
		this.y = y;
		this.idx = idx;
	}
}