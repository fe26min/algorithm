package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No16920 {
	
	// bfs 문제
	static int N, M, P;
	static int[] S, cnt;
	static int[][] mat;
	static PriorityQueue<Node16920> pq;
	
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		
		while(!pq.isEmpty()) {
			Node16920 cur = pq.poll();
			cnt[cur.idx - 1]++;
//			System.out.println(cur.x + " " + cur.y + " " + cur.idx + " " + cur.depth + " " + cur.time);
			for(int di=0; di<4; di++) {
				int nx = cur.x + dirx[di];
				int ny = cur.y + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=M)
					continue;
				if(mat[nx][ny] != 0)
					continue;
				mat[nx][ny] = cur.idx;
				if(cur.depth < S[cur.idx - 1] - 1) {
					pq.add(new Node16920(nx, ny, cur.idx, cur.time, cur.depth + 1));
				}
				else {
					pq.add(new Node16920(nx, ny, cur.idx, cur.time + 1, 0));
				}
			}
		}
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(mat[i][j] + " ");
//			}System.out.println();
//		}
		
		
		
		for(int i : cnt) {
			System.out.print(i + " ");
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		S = new int[P];
		cnt = new int[P];
		mat = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<P; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		pq = new PriorityQueue<Node16920>();
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				if(line.charAt(j) == '.') {
					mat[i][j] = 0;
				}
				else if(line.charAt(j)== '#') {
					mat[i][j] = -1;
				}
				else {
					mat[i][j] = line.charAt(j)-'0';
					pq.add(new Node16920(i, j, mat[i][j], 0, 0));
				}
			}
		}
		
		br.close();		
	}
}

class Node16920 implements Comparable<Node16920> { 
	int x, y, idx, time, depth;
	
	public Node16920(int x, int y, int idx, int time, int depth) {
		this.x = x;
		this.y = y;
		this.idx = idx;
		this.time = time;
		this.depth = depth;
	}

	@Override
	public int compareTo(Node16920 o) {
		if(this.time == o.time) {
			if(this.idx == o.idx)
				return this.depth - o.depth;
			return this.idx - o.idx;
		}
		return this.time - o.time;
	}
}
