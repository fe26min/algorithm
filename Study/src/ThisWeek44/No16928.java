package ThisWeek44;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class No16928 {
	static int N, M, min;
	static int[] boards;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int[] check = new int[101];
		check[1] = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int di=1; di<=6; di++) {
				int nx = cur + di;
				
				if(nx > 100)
					continue;
				
				if(check[boards[nx]]==0) {
					queue.add(boards[nx]);
					check[boards[nx]] = check[cur] + 1;
				}
				if(boards[nx] == 100) {
					System.out.println(check[100]);
					return;
				}
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boards = new int[101];
		for(int i=1; i<101; i++) {
			boards[i] = i;
		}
		
		for(int i=0; i<N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			boards[x] = y;
		}
		
		br.close();		
	}
}
