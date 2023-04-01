package ThisWeek34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No2174 {
	static int A, B, N, M;
	static HashMap<Integer, Robot2147> hm;
	static Robot2147[][] mat;
	static String[] cmds;
	
	static int[] dirx = {1, 0, -1, 0};
	static int[] diry = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		for(int i=0; i<M; i++) {
			String[] input = cmds[i].split(" ");
			
			int idx = Integer.parseInt(input[0]);
			char cmd = input[1].charAt(0);
			int cnt = Integer.parseInt(input[2]);
			
			func(idx, cmd, cnt);
		}
		System.out.println("OK");
	}
	
	private static void func(int idx, char cmd, int cnt) {
		Robot2147 robot = hm.get(idx);
		
		if(cmd == 'F') {
			int nx = robot.x;
			int ny = robot.y;
			
			for(int c=0; c<cnt; c++) {
				nx += dirx[robot.dir];
				ny += diry[robot.dir];
				
				if(nx<0||ny<0||nx>=B||ny>=A) {
					System.out.println("Robot " + idx + " crashes into the wall");
					System.exit(0);
				}
				if(mat[nx][ny] != null) {
					System.out.println("Robot " + idx + " crashes into robot " + mat[nx][ny].idx);
					System.exit(0);
				}
			}
			mat[robot.x][robot.y] = null;
			mat[nx][ny] = robot;
			robot.x = nx;
			robot.y = ny;
		}
		else {
			cnt %= 4;
			if(cmd == 'L')
				robot.dir += cnt;
			else
				robot.dir += 3*cnt;
			robot.dir %= 4;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		mat = new Robot2147[B][A];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cmds = new String[M];
		hm = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			char dirc = st.nextToken().charAt(0);
			int dir = getDir(dirc);
			mat[b][a] = new Robot2147(i, dir, b, a);
			hm.put(i, mat[b][a]);
		}
		
		for(int i=0; i<M; i++) {
			cmds[i] = br.readLine();
		}
		br.close();
	}

	private static int getDir(char dirc) {
		switch(dirc) {
		case 'N':
			return 0;
		case 'W':
			return 1;
		case 'S':
			return 2;
		case 'E':
			return 3;
		}
		return -1;
	}
}

class Robot2147 {
	int idx, dir, x, y;
	
	public Robot2147(int idx, int dir, int x, int y) {
		this.idx = idx;
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
}