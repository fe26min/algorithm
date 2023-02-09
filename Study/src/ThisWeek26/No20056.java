package ThisWeek26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No20056 {
	static BufferedReader br;
	
	static ArrayList<FireBall> list;
	static Queue<FireBall>[][] queue;
	static int N;
	
	static int[] dirx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] diry = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i=0; i<M; i++) {
			input();
		}
		br.close();
		
		queue = new Queue[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				queue[i][j] = new LinkedList<FireBall>();
			}
		}
		for(int i=0; i<K; i++) {
			move();
			combineAndDivide();
		}
		
		int answer = 0;
		for(FireBall f : list) {
//			System.out.println(f.r + " " + f.c + " " + f.m + " " + f.d + " " + f.s);
			answer += f.m;
		}
		System.out.println(answer);
	}

	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		list.add(new FireBall(
				Integer.parseInt(st.nextToken())-1,
				Integer.parseInt(st.nextToken())-1,
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
				));
	}
	
	private static void move() {
		for(FireBall f : list) {
			f.r = (N + f.r + dirx[f.d] * (f.s) % N) % N;
			f.c = (N + f.c + diry[f.d] * (f.s) % N) % N;
			
			queue[f.r][f.c].add(f);
		}
	}
	
	private static void combineAndDivide() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(queue[i][j].size() >= 2) {
					int sumM = 0;
					int sumS = 0;
					int cnt = queue[i][j].size();
					int ndir = queue[i][j].peek().d % 2;
					boolean same = true;
					
					while(!queue[i][j].isEmpty()) {
						FireBall f = queue[i][j].poll();
						list.remove(f);
						
						sumM += f.m;
						sumS += f.s;
						
						if(!same)
							continue;
						same = ndir == f.d % 2;
					}
					
					int nm = sumM / 5;
					if(nm == 0)
						continue;
					
					int ns = sumS / cnt;
					
					if(same)
						ndir = 0;
					else
						ndir = 1;
					
					for(int di=0; di<4; di++) {
						list.add(new FireBall(i, j, nm, ns, 2 * di + ndir));
					}
				}else {
					queue[i][j].clear();
				}
			} 
		}
	}
}

class FireBall {
	int r, c, m, s, d;
	
	public FireBall(int r, int c, int m, int s, int d) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}