package ThisWeek42;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2234 {
	static int N, M, count, max, acnt;
	static int[][] mat, area;
	static boolean[][] visit, list;
	static HashMap<Integer, Integer> hm;
	
	static int[] dirx = {0, -1, 0, 1};
	static int[] diry = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		count = 0;
		max = 0;
		hm = new HashMap<>();
		list = new boolean[2501][2501];
		
		find();
		System.out.println(count);
		System.out.println(max);
		max = 0;
		for(int i=1; i<=count; i++) {
			for(int j=i+1; j<=count; j++) {
				if(list[i][j]) {
					max =Math.max(max, hm.get(i) + hm.get(j));
				}
			}
		}
		System.out.println(max);
	}


	private static void find() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j]) continue;
				visit[i][j] = true;
				count++;
				acnt = 1;
				bfs(i, j);
			}
		}
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			area[cur[0]][cur[1]] = count;
			
			for(int di=1; di<=8; di*=2) {
				int dir =(int) (Math.log(di) / Math.log(2));
				int nx = cur[0] + dirx[dir];
				int ny = cur[1] + diry[dir];
				
				
				if((mat[cur[0]][cur[1]] & di) > 0) {
					if(nx>=0&&ny>=0&&nx<N&&ny<M) {
						if(visit[nx][ny]) {
							list[area[nx][ny]][count] = true;
							list[count][area[nx][ny]] = true;
						}
					}
					continue;
				}
				
				if(visit[nx][ny])
					continue;
				
				visit[nx][ny] = true;
				acnt++;
				queue.add(new int[] {nx, ny});
			}
		}
		hm.put(count, acnt);
		max = Math.max(max, acnt);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		area = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();		
	}
}
