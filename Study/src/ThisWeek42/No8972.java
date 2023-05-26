package ThisWeek42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No8972 {
	static int R, C;
	static int[] idx;
	static ArrayList<int[]> madRobot;
	static char[][] mat;
	static String cmd;

	static int[] dirx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int[] diry = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		for(int i=0; i<cmd.length(); i++) {
			if(moveJongsu(i)) {
				System.out.println("kraj " + (i + 1));
				return;
			}
			if(moveMad()) {
				System.out.println("kraj " + (i + 1));
				return;
			}
//			printMat();
		}
		printMat();
	}
	private static void printMat() {
		for(int x=0; x<R; x++) {
			for(int y=0; y<C; y++) {
				System.out.print(mat[x][y]);
			}System.out.println();
		}
	}
	private static boolean moveMad() {
		int[][] visit = new int[R][C];
		
		for(int[] i : madRobot) {
			
			int min = Math.abs(idx[0] - i[0]) + Math.abs(idx[1] - i[1]);
			int minx = i[0];
			int miny = i[1];
			
			for(int di=0; di<9; di++) {
				int nx = i[0] + dirx[di];
				int ny = i[1] + diry[di];
				int nd = Math.abs(idx[0] - nx) + Math.abs(idx[1] - ny);
				
				if(min > nd) {
					min = nd;
					minx = nx;
					miny = ny;
				}
				
			}
			mat[i[0]][i[1]] = '.';
			i[0] = minx;
			i[1] = miny;
			if(mat[i[0]][i[1]]=='I') {
				return true;
			}
			visit[minx][miny]++;
		}
		
		ArrayList<int[]> nextRobot = new ArrayList<>();
		
		for(int[] i : madRobot) {
			if(visit[i[0]][i[1]] == 1) {
				nextRobot.add(new int[] {i[0], i[1]});
				mat[i[0]][i[1]] = 'R';
				
			}
		}
		madRobot = nextRobot;
		return false;
	}
	private static boolean moveJongsu(int i) {
		mat[idx[0]][idx[1]] = '.';
		idx[0] += dirx[cmd.charAt(i)-'1'];
		idx[1] += diry[cmd.charAt(i)-'1'];
		
		if(mat[idx[0]][idx[1]] == 'R')
			return true;
		mat[idx[0]][idx[1]] = 'I';
		return false;
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		mat = new char[R][C];
		idx = new int[2];
		madRobot = new ArrayList<>();
		
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				mat[i][j] = line.charAt(j);
				if(mat[i][j]=='I') {
					idx[0] = i;
					idx[1] = j;
				}
				else if(mat[i][j]=='R') {
					madRobot.add(new int[] {i, j});
				}
			}
			
		}
		cmd = br.readLine();
		
		br.close();		
	}
}
