package backjoon.fastcampus.ch06.GS_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 4방 탐색 + 벽 세우기
public class No14502 {

	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int mat[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Node_14502> queue = new LinkedList<>();
		boolean visit[][] = new boolean[N][M];
		queue.add(new Node_14502(mat, visit, 0, N, M));
		
		while(!queue.isEmpty()) {
			Node_14502 cur = queue.poll();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					
				}
			}
		}
		
		br.close();
	}
}
class Node_14502 {
	public int[][] mat;
	public boolean[][] visit;
	public int count;
	
	Node_14502(int[][] mat, boolean[][] visit, int count, int N, int M){
		for(int i=0; i<N; i++) {
			this.mat[i] = mat[i].clone();
			this.visit[i] = visit[i].clone();
		}
		this.count = count;
	}
}
