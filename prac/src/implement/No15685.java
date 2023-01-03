package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No15685 {
	
	static boolean[][] mat = new boolean[101][101];
	static HashSet<int[]> hs = new HashSet<>();
	
	static int[] dirx = {1, 0, -1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	// 4점이 전부 되어있는 칸을 구하기
	private static void pro() {
		int count = 0;
		for(int[] i : hs) {
			int x = i[0];
			int y = i[1];
			
			if(x==100 || y == 100) continue;
			if(mat[x][y] && mat[x+1][y] && mat[x][y+1] && mat[x+1][y+1]) count++;
		}
		System.out.println(count);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			dragon(x, y, d, g);
		}
		br.close();
	}

	private static void dragon(int x, int y, int d, int g) {
		String newLine = "" + d;
		
		int nx = x;
		int ny = y;
		
		if(!mat[nx][ny]) {
			mat[nx][ny] = true;
			hs.add(new int[] {nx, ny});
		}
		nx = x + dirx[d];
		ny = y + diry[d];
		
		if(!mat[nx][ny]) {
			mat[nx][ny] = true;
			hs.add(new int[] {nx, ny});
		}
		for(int i=0; i<g; i++) {
			String temp = "";
			
			for(int j=newLine.length()-1; j>=0; j--) {
				int nd = (newLine.charAt(j) + 1) % 4;
				temp += nd;
				nx += dirx[nd];
				ny += diry[nd];
				
				if(mat[nx][ny]) continue;
				
				mat[nx][ny] = true;
				hs.add(new int[] {nx, ny});
			}
			newLine += temp;
		}
	}
}
