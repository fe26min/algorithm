package ThisWeek26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1194 {
	
	static int N, M;
	static char[][] mat;
	
	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new char[N][M];
		boolean visit[][][] = new boolean[N][M][1<<7];
		Queue<State> queue = new LinkedList<State>();
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				mat[i][j] = line.charAt(j);
				if(mat[i][j] == '0') {
					queue.add(new State(i, j, 0, 0));
					visit[i][j][0] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			State cur = queue.poll();
			
			if(mat[cur.x][cur.y]=='1') {
				System.out.println(cur.count);
				br.close();
				return;
			}
			
			for(int di=0; di<4; di++) {
				int nx = cur.x + dirx[di];
				int ny = cur.y + diry[di];
				int nkeys = cur.keys;
				
				if(nx<0||ny<0||nx>=N||ny>=M)
					continue;
				if(visit[nx][ny][cur.keys])
					continue;
				if(mat[nx][ny] == '#')
					continue;
				if('A' <= mat[nx][ny] && mat[nx][ny] <= 'F') {
					if((cur.keys & (1 << (mat[nx][ny]-'A'))) == 0) 
						continue;
				}
				if('a' <= mat[nx][ny] && mat[nx][ny] <= 'f') {
					nkeys |= 1 << (mat[nx][ny] - 'a');
				}
				
				visit[nx][ny][nkeys] = true;
				queue.add(new State(nx, ny, cur.count + 1, nkeys));
			}
		}
		System.out.println(-1);
		br.close();
	}
}

class State {
	int x, y, count;
	int keys;
	
	public State(int x, int y, int count, int keys) {
		this.x = x;
		this.y = y;
		this.count = count;
		this.keys = keys;
	}
}