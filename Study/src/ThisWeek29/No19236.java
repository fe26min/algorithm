package ThisWeek29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No19236 {
	static int max;
	
	static int[][] mat = new int[4][4]; 
	static List<Fish> fishes;
	
	static int[] dirx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] diry = {0, -1, -1, -1, 0, 1, 1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		fishes = new LinkedList();
		
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				Fish f = new Fish(a, b, i, j);
				mat[i][j] = a;
				fishes.add(f);
			}
		}
		max = 0;
		
		Fish f = fishes.get(mat[0][0]);
		
		dfs(0, 0, 0);
		
		br.close();
	}
	private static void dfs(int i, int j, int sum) {
		sum += mat[i][j];
		
	}
	
}

class Shark {
	int x, y, dir, sum;
	
	public Shark(int x, int y, int dir, int sum) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.sum = sum;
	}
}

class Fish implements Comparable<Fish>{
	int num, dir, x, y;
	boolean isDead;
	
	public Fish(int num, int dir, int x, int y) {
		this.num = num;
		this.dir = dir;
		this.x = x;
		this.y = y;
		isDead = false;
	}
	
	@Override
	public int compareTo(Fish o) {
		return this.num - o.num;
	}
}