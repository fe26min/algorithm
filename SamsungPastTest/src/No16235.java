import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No16235 {
	static int N, M, K;
	static int[][] mat, add;
	static LinkedList<int[]> trees;
	
	static int[] dirx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] diry = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		for(int i=0; i<K; i++) {
			year();
		}
		System.out.println(trees.size());
	}

	private static void year() {
		LinkedList<int[]> nextTrees = new LinkedList<>();
		LinkedList<int[]> dieTrees = new LinkedList<>();
//		System.out.println("TREE:");
		//spring
		for(int[] tree : trees) {
//			System.out.println(tree[0] + " " + tree[1] + " " + tree[2]);
			
			if(mat[tree[0]][tree[1]] < tree[2]) {
				dieTrees.add(tree);
			}
			else {
				mat[tree[0]][tree[1]] -= tree[2];
				nextTrees.add(new int[] {tree[0], tree[1], tree[2] + 1});
			}
		}
		//summer
		
		for(int[] dtree : dieTrees) {
			mat[dtree[0]][dtree[1]] += dtree[2] / 2;
		}

//		System.out.println("nextTREE:");
		LinkedList<int[]> temp = new LinkedList<>();
		//fall
		for(int[] tree : nextTrees) {
//			System.out.println(tree[0] + " " + tree[1] + " " + tree[2]);
			if(tree[2] % 5 == 0) {
				for(int di=0; di<8; di++) {
					int nx = tree[0] + dirx[di];
					int ny = tree[1] + diry[di];
					
					if(nx<0||ny<0||nx>=N||ny>=N)
						continue;
					temp.add(new int[] {nx, ny});
				}
			}
		}
		
		for(int[] tree : temp) {
			nextTrees.addFirst(new int[] {tree[0], tree[1], 1});
		}
		
		//winter
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				mat[i][j] += add[i][j];
			}
		}
		
		trees = nextTrees;
	}

	private static void input() throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		mat = new int[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(mat[i], 5);
		}
		
		add = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				add[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		trees = new LinkedList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			trees.add(new int[] {x, y, z});
		}
		
		br.close();
	}
}