package ThisWeek31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No4936 {
	
	static int w, h;
	static boolean[][] mat,visit;
	static int dirx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int diry[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		w = h = -1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w+h ==0) break;
			mat = new boolean[h][w];
			visit = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					mat[i][j] = (st.nextToken().equals("1"));
				}
			}
			
			int count = 0;
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(visit[i][j] || !mat[i][j]) continue;
					count++;
					visit[i][j] = true;
					dfs(i, j);
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int x, int y) {
		
		for(int di=0; di<8; di++) {
			int nx = x + dirx[di];
			int ny = y + diry[di];
			
			if(nx<0 || ny<0 || nx>=h || ny>=w) continue;
			if(visit[nx][ny] || !mat[nx][ny]) continue;
			
			visit[nx][ny] = true;
			dfs(nx, ny);
		}
		
	}
}
