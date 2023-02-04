package ThisWeek26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No20056 {

	static int N;
	static FireBall[][] mat;
	static Queue<FireBall> queue;
	
	static int[] dirx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] diry = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		mat = new FireBall[N][N];
		
		queue = new LinkedList<FireBall>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			FireBall f = new FireBall(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
			mat[f.r][f.c] = f;
			queue.add(f);
		}
		
		for(int i=0; i<K; i++) {
			move();
		}
		
		br.close();
	}

	private static void move() {
		Queue<FireBall> newQueue = new LinkedList<>();
		FireBall[][] newMat = new FireBall[N][N];
		
		while(!queue.isEmpty()) {
			FireBall cur = queue.poll();
			
		}
		mat = newMat;
		queue = newQueue;
	}
}

class FireBall {
	int r, c, m, d, s;
	
	public FireBall(int r, int c, int m, int d, int s) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.d = d;
		this.s = s;
	}
}