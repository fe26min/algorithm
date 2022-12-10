package backjoon.fastcampus.ch08.TopoSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2637 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] inCnt = new int[N+1];
		int[][] sum = new int[N+1][N+1];
		boolean[] isBasic = new boolean[N+1];
		ArrayList<int[]>[] list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			list[Y].add(new int[] {X, K});
			inCnt[X]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(inCnt[i] == 0) {
				queue.add(i);
				isBasic[i] = true; 
				sum[i][i] = 1;
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int[] child : list[cur]) {
				for(int i=1; i<=N; i++) {
					sum[child[0]][i] += child[1] * sum[cur][i];
				}
				inCnt[child[0]]--;
				if(inCnt[child[0]]==0) {
					queue.add(child[0]);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(isBasic[i]) {
				System.out.println(i + " " + sum[N][i]);
			}
		}
		br.close();
	}
}
