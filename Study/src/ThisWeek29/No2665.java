package ThisWeek29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No2665 {
	static int N;
	static boolean[][] mat;
	static int[][] cnt;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		cnt = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				cnt[i][j] = 2 * N;
			}
		}
		PriorityQueue<Node2665> queue = new PriorityQueue<>();
		queue.add(new Node2665(0,0,0));
		cnt[0][0] = 0;
		
		while(!queue.isEmpty()) {
			Node2665 cur = queue.poll();
			
			for(int di=0; di<4; di++) {
				int nx = cur.x + dirx[di];
				int ny = cur.y + diry[di];
				int ncnt = cur.cnt;
				
				if(nx<0||ny<0||nx>=N||ny>=N)
					continue;
				if(mat[nx][ny])
					ncnt++;
				if(cnt[nx][ny] <= ncnt)
					continue;
				
				cnt[nx][ny] = ncnt;
				
				queue.add(new Node2665(nx, ny, ncnt));
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(mat[i][j] + " ");
			}System.out.println();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(cnt[i][j] + " ");
			}System.out.println();
		}
		
		System.out.println(cnt[N-1][N-1]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		mat = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				mat[i][j] = (line.charAt(j) == '0');
			}
		}
		br.close();
	}
}

class Node2665 implements Comparable<Node2665>{
	int x, y, cnt;
	
	public Node2665(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Node2665 o) {
		return this.cnt - o.cnt;
	}
}