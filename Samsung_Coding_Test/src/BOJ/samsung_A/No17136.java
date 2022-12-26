package BOJ.samsung_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17136 {
	
	static int ans;
	static int[] used = new int[5];
	static int[][] mat = new int[10][10];
	static boolean[][] attached = new boolean[10][10];
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		ans = 26;
		dfs(0, 0, 0);
		if(ans == 26) ans = -1;
		System.out.println(ans);
	}

	private static void dfs(int x, int y, int count) {
		if(x>=9 && y > 9) {
			ans = Math.min(ans, count);
			return;
		}
		
		if(y==10) {
			dfs(x+1, 0, count);
			return;
		}
		
		if(mat[x][y] == 1) {
			for(int i=0; i<=4; i++) {
				if(check(x, y, i) && used[i] < 5) {
					draw(x, y, i, 0);
					used[i]++;
					dfs(x, y+1, count+1);
					draw(x, y, i, 1);
					used[i]--;
				}
			}
		}
		else {
			dfs(x, y+1, count);
		}
	}

	private static void draw(int x, int y, int i, int j) {
		for(int nx = x; nx <= x + i; nx++) {
			for(int ny = y; ny <= y+i; ny++) {
				mat[nx][ny] = j;
			}
		}
	}

	private static boolean check(int x, int y, int i) {
		if(x+i>9 ||y+i>9) return false;
		for(int nx = x; nx <= x + i; nx++) {
			for(int ny = y; ny <= y+i; ny++) {
				if(mat[nx][ny]==0) return false;
			}
		}
		return true;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();		
	}
}
