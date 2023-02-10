package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No17837 {
	static int N, K;
	static int[][] map;
	static HashMap<Integer, Node17837> horse;
	static ArrayList<Integer>[][] list;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N][N];
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				list[i][j] = new ArrayList<>();
			}
		}
		horse = new HashMap<>();
		for(int i=0; i<K; i++) {
			
		}
		
		br.close();
	}
}

class Node17837 {
	int x, y, dir;
	
	public Node17837(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}