package ThisWeek43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14620 {
	static int N;
	static int min = Integer.MAX_VALUE;
	static int mat[][];
	static boolean visit[][];
	
	static int arr[][] = new int[3][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		dfs(0, 1, 1);
		
		System.out.println(min);
		br.close();
	}

	private static void dfs(int depth, int sx, int sy) {
		
		if(depth == 3) {
			check();
			return;
		}
		
		
		for(int j=sy; j<N-1; j++) {
			boolean flag = false;
			for(int idx = 0; idx < depth; idx++) {
				if(distance(arr[idx], sx, j) <= 2) {
					flag = true;
				}
				if(flag) break;
			}
			if(flag) continue;
			
			arr[depth][0] = sx;
			arr[depth][1] = j;
			dfs(depth + 1, sx, j);
		}
		
		for(int i=sx + 1; i<N-1; i++) {
			for(int j=1; j<N-1; j++) {
				boolean flag = false;
				for(int idx = 0; idx < depth; idx++) {
					if(distance(arr[idx], i, j) <= 2) {
						flag = true;
					}
					if(flag) break;
				}
				if(flag) continue;
				
				arr[depth][0] = i;
				arr[depth][1] = j;
				dfs(depth + 1, i, j);
				
			}
		}
		
	}

	private static int distance(int[] point, int x, int y) {
		return Math.abs(point[0] - x) + Math.abs(point[1] - y);
	}

	private static void check() {
//		for(int point[] : arr) {
//			System.out.println(point[0] + " " + point[1]);
//		}System.out.println();
		
		int sum = 0;
		
		for(int point[] : arr) {
			sum += mat[point[0]][point[1]];
			sum += mat[point[0]-1][point[1]];
			sum += mat[point[0]+1][point[1]];
			sum += mat[point[0]][point[1]-1];
			sum += mat[point[0]][point[1]+1];
		}
		
		min = Math.min(min, sum);
	}
}